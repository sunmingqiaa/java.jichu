package dataStructure.linkedList.circleLinked;

public class CircleLinkedDemo {
    public static void main(String[] args) {
        System.out.println("创建环形连表");
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.add(5);
        circleLinked.showBoy();
        circleLinked.josephuProblem(1,2,5);
    }
}
