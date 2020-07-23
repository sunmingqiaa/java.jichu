package designModel.factory;

import designModel.factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void getShape() {
        System.out.println("rectangle");
    }
}
