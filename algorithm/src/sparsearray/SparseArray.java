package sparsearray;

/*
 *
 *
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始二维数组，0表示无棋子，1表示黑子，2表示白子
        int chessArray[][] = new int[10][10];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][4] = 1;
        chessArray[4][5] = 2;
        chessArray[5][6] = 1;
        chessArray[6][7] = 2;
        chessArray[7][8] = 1;
        chessArray[8][9] = 2;
        chessArray[9][0] = 1;
        //输出原始二维数组
        System.out.println("原始二维数组");
        for(int[] row:chessArray){
            for (int data:row
                 ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转化为稀疏数组
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(chessArray[i][i]!=0) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 10;
        sparseArr[0][1] = 10;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;//用于记录第几个非零数据
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(chessArray[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArray[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为原始二维数组
        //先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArray1[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //读取稀疏数组的后几行，并赋值给原始的二维数组
        for (int i = 0; i < sparseArr.length; i++) {
            chessArray1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组:");

        for (int[] row : chessArray1
             ) {
            for (int data : row
                 ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
