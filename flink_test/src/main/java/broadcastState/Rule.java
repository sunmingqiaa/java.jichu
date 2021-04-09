package broadcastState;

import java.io.Serializable;

public class Rule implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rule(String name, String first, String second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    String first;
    String second;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public Rule(String first, String second) {
        this.first = first;
        this.second = second;
    }


    @Override
    public String toString() {
        return "Rule{" +
                "name='" + name + '\'' +
                ", first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
