package broadcastState;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.KeyedBroadcastProcessFunction;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.apache.flink.util.Collector;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {
   private static Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);
//        模拟数据流
        DataStreamSource<Item> itemDataStreamSource = env.addSource(new RichSourceFunction<Item>() {
            private final Item[] dataSet = new Item[]{
                    new Item("red", "square"),
                    new Item("red", "round"),
//                    new Item("red", "square"),
                    new Item("yellow", "square"),
//                    new Item("yellow", "square"),
                    new Item("yellow", "round"),

            };

            @Override
            public void run(SourceContext<Item> sourceContext) throws Exception {
                System.out.println("运行source");
                int size = dataSet.length;
                while (true) {
                    logger.warn("kaishizhixing");
                    int seed = (int) (Math.random() * size);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(dataSet[seed]);
                    sourceContext.collect(dataSet[seed]);
                }
            }

            @Override
            public void cancel() {

            }
        });
//        创建控制流
        final MapStateDescriptor<String, Rule> RulesBroadcastState = new MapStateDescriptor<>(
                "RulesBroadcastState",
                BasicTypeInfo.STRING_TYPE_INFO,
                TypeInformation.of(new TypeHint<Rule>() {
                }));

        // 自定义广播流
        BroadcastStream<Rule> broadcastStream = env.addSource(new RichSourceFunction<Rule>() {

            private volatile boolean isRunning = true;
            //测试数据集
            private Rule[] dataSet = new Rule[]{
                    new Rule("rule1", "square", "round"),
            };

            /**
             * 数据源：模拟每30秒随机更新一次拦截的关键字
             * @param ctx
             * @throws Exception
             */
            @Override
            public void run(SourceContext<Rule> ctx) throws Exception {
                int size = dataSet.length;
//                while (isRunning) {
                    int seed = (int) (Math.random() * size);
//                    TimeUnit.SECONDS.sleep(3);
                    //随机选择关键字发送
                    ctx.collect(dataSet[seed]);
                    System.out.println("读取到上游发送的处理规则:" + dataSet[seed]);
               /* for (int i = 0; i <1000 ; i++) {
                    logger.info("读取到上游发送的处理规则:" + dataSet[seed]);
                }*/
//                }
            }

            @Override
            public void cancel() {
                isRunning = false;
            }
        }).broadcast(RulesBroadcastState);

        KeyedStream<Item, String> colorPartitionedStream = itemDataStreamSource.keyBy(new KeySelector<Item, String>() {
            @Override
            public String getKey(Item item) throws Exception {
                return item.color;
            }
        });

        ConnectedStreams<Item, Item> connect = colorPartitionedStream.connect(colorPartitionedStream);

        SingleOutputStreamOperator<String> process = colorPartitionedStream.connect(broadcastStream)
                .process(

                        // type arguments in our KeyedBroadcastProcessFunction represent:
                        //   1. the key of the keyed stream
                        //   2. the type of elements in the non-broadcast side
                        //   3. the type of elements in the broadcast side
                        //   4. the type of the result, here a string

                        new KeyedBroadcastProcessFunction<String, Item, Rule, String>() {
                            // store partial matches, i.e. first elements of the pair waiting for their second element
                            // we keep a list as we may have many first elements waiting
                            private final MapStateDescriptor<String, Item> mapStateDesc =
                                    new MapStateDescriptor<>(
                                            "items",
                                            BasicTypeInfo.STRING_TYPE_INFO,
                                            TypeInformation.of(new TypeHint<Item>() {
                                            }));

                            // identical to our ruleStateDescriptor above
                            private final MapStateDescriptor<String, Rule> ruleStateDescriptor =
                                    new MapStateDescriptor<>(
                                            "RulesBroadcastState",
                                            BasicTypeInfo.STRING_TYPE_INFO,
                                            TypeInformation.of(new TypeHint<Rule>() {
                                            }));

                            @Override
                            public void processElement(Item value, ReadOnlyContext ctx, Collector<String> out) throws Exception {

                                final MapState<String, Item> state = getRuntimeContext().getMapState(mapStateDesc);
                                final String shape = value.shape;

                                for (Map.Entry<String, Rule> entry :
                                        ctx.getBroadcastState(ruleStateDescriptor).immutableEntries()) {
                                    final String ruleName = entry.getKey();
                                    System.out.println(ruleName);
                                    final Rule rule = entry.getValue();

                                    Item stored = state.get(ruleName);

                                    if (shape .equals(rule.second)  && stored!=null) {

                                            out.collect("MATCH: "+stored  + " - " + value);


                                    }

                                    // there is no else{} to cover if rule.first == rule.second


                                    if (shape .equals(rule.first)) {
                                        state.put(ruleName, value);
                                    }
                                }


                            }

                            @Override
                            public void processBroadcastElement(Rule value, Context ctx, Collector<String> collector) throws Exception {
                                ctx.getBroadcastState(ruleStateDescriptor).put(value.name, value);
                            }

                        });
        process.printToErr();
        env.execute();
    }
}
