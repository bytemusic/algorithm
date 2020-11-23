package recursion;

public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组
        int[][] map = new int[8][7];
        //
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //从左到右全部置为1
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
        //使用递归给小球找路
        setWay(map,1,1);
        //输出新地图
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
    }
    //使用递归回给小球找路
    /*map表示地图，i，j表示地图的哪个位置开始出发
     *小球能到map[6][5]，说明道理找到
     *当map[i][j]为0表示这个位置还没走过。1表示墙，2表示通路可以走，3表示走过单不通
     *策略：下-》右-》上-》左
     *
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0) {
                //假定可以走通
                map[i][j] = 2;
                if(setWay(map, i+1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)){//向上走
                    return true;
                } else if (setWay(map, i, j - 1)){//向左走
                    return true;
                } else {
                    //说明该店是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] != 0,可能是1,2,3
                return false;
            }
        }
    }
}
