package array;

/**
 *   最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class maximalSquare {
    public static void main(String[] args){

    }
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return 0;
        }

        int max=0;//最大边长




        return max*max;
    }


}
