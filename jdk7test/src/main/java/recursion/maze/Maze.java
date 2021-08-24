package recursion.maze;


public class Maze {
    /**
     * @author: smq
     * @date: 2021/8/24
     */
    public int line;
    public int colum;
    public int[][] maze;

    /*
     * 说明：1代表墙
     *      2代表走过的路
     *      3代表走过但是走不通的路
     * */
    public Maze(int line, int colum) {
        this.line = line;
        this.colum = colum;
        maze = new int[line][colum];
        initMaze();
    }

    private void initMaze() {
//        初始化第一行和最后一行为1
        for (int i = 0; i < colum; i++) {
            maze[0][i] = 1;
            maze[line - 1][i] = 1;

        }
//        初始化第一列和最后一列为1
        for (int i = 0; i < line; i++) {
            maze[i][0] = 1;
            maze[i][colum - 1] = 1;
        }
//        初始化入口和出口
//        maze[1][1] = 2;
//        maze[line - 2][colum - 2] = 2;
//        初始化障碍物
        maze[3][1] = 1;
        maze[3][2] = 1;
//        maze[1][2] = 1;
//        maze[2][2] = 1;

    }

    public void show() {
        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    public boolean getPath(int a, int b) {
        if (maze[line - 2][colum - 2] == 2) {
            return true;
        }
        if (maze[a][b] == 0) {
            maze[a][b] = 2;
            //        下——>右——>上——>左
            if (getPath(a + 1, b)) {
                return true;
            } else if (getPath(a, b + 1)) {
                return true;
            } else if (getPath(a - 1, b)) {
                return true;
            } else if (getPath(a, b - 1)) {
                return true;
            }
            maze[a][b] = 3;
            return false;
        }
        return false;
    }

}

