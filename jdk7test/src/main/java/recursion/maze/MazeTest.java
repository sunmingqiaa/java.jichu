package recursion.maze;

public class MazeTest {
    public static void main(String[] args) {
        Maze maze = new Maze(8, 8);
        maze.show();
        boolean path = maze.getPath(1, 1);
        if (path){
            System.out.println("找到了");
            maze.show();
        }else {
            System.out.println("走不通");
            maze.show();
        }

    }
}
