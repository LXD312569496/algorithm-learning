package array;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class longestConsecutive {
    public static void main(String[] args){

        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));//4
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));//3
    }

    /**
     * 排序后，两两判断
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums){
        //处理特殊情况
        if (nums.length==0){
            return 0;
        }

        int maxLength=1;
        int temp=1;
        Arrays.sort(nums);

        for (int i = 1; i <nums.length ; i++) {
            //处理下两个数字相同的情况，continue
            if (nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i]-nums[i-1]==1){
                temp++;
            }else {
                if (temp>maxLength){
                    maxLength=temp;
                }
                temp=1;
            }
        }
        //结束完再加一次判断
        if (temp>maxLength){
            maxLength=temp;
        }

        return maxLength;
    }
}
