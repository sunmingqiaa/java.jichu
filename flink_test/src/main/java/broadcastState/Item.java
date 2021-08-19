package broadcastState;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
     String color;
    String shape;

    public Item(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Item{" +
                "color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return color.equals(item.color) && shape.equals(item.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, shape);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
