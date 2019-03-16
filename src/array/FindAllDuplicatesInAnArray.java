package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * <p>
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {

        int a[] = {4, 3, 2, 7, 8, 2, 3, 1};
//        List<Integer> list=findDuplicates(a);
        List<Integer> list = findDuplicates2(a);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    /**
     * 比较暴力的方法：排序后遍历
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //先利用快速排序，复杂度为O(nlogn)
        Arrays.sort(nums);
        //一次遍历
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                list.add(nums[i]);
                i++;
            }
        }
        return list;
    }


    /**
     * 好一点的方法
     * 解题思路：遍历一遍，将每个数字对应成下标找到相应的位置，该位置置为相反数，
     * 因此只遍历过一次的是负数，遍历两次的是正数。注意下标有可能出现负数，所以要使用下标的绝对值
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -nums[index];
            if (nums[index] > 0) {
                result.add(index + 1);
            }
        }
        return result;
    }

}
