package recursion.queen;

public class QueenTest {
    public static void main(String[] args) {
        Queen queen = new Queen(4);
        queen.check(0);
        System.out.println(queen.count);
    }
}
