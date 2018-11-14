
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs(10));
        System.out.println(climbStairs1(10));
    }

    /**
     * 利用递归的方法实现，不过比较耗时，leetcode运行超时
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     *  利用临时变量来存放结果，比用临时的数组存储结果快一些
     */
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a=1;
        int b=2;
        int result=0;
        while (n>=3){
            result=a+b;
            a=b;
            b=result;
            n--;
        }
        return result;
    }




}
