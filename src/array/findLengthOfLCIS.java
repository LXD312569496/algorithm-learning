package array;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 */
public class findLengthOfLCIS {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findLengthOfLCIS(new int[]{1, 2, 5, 8, 0}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;//最大的连续个数
        int temp = 1;//保存临时的连续个数

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
            } else {
                if (max < temp) {
                    max = temp;
                }
                temp = 1;
            }
        }
        //最后也要比较一次，不然会出错
        if (max < temp) {
            max = temp;
        }
        return max;
    }
}
