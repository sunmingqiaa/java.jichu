package staticTest;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Util.name="Test1修改name";
        System.out.println(Util.name);
        Util util = new Util();
        System.out.println(util.name);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新县城"+Util.name);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新县城2"+Util.name);
            }
        }).start();
    }
}
