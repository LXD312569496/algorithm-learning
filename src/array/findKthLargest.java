package array;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
 */
public class findKthLargest {

    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));//4
        System.out.println(findKthLargest(new int[]{1}, 1));//4
        System.out.println(findKthLargest(new int[]{2,1}, 2));//4

//        sort(new int[]{3, 2, 1, 5, 6, 4}, 0, 5);
//        sort(new int[]{3,2,3,1,2,4,5,5,6}, 0, 5);
    }

    public static int findKthLargest(int[] nums, int k) {
        return  findKthLargest(nums, 0, nums.length-1,k);
    }

    public static int findKthLargest(int[] a, int low, int high,int k) {
        int i = low;
        int j = high;

        int key = a[i];

        while (i < j) {
            while (i < j && a[j] >= key)
                j--;
            a[i] = a[j];
            while (i < j && a[i] <= key)
                i++;
            a[j] = a[i];
        }
        a[i] = key;

        /**
         * 核心代码
         */
        if (i == a.length - k) {
            return key;
        } else if (i < a.length - k) {
            return findKthLargest(a, i + 1, high, k);
        } else {
            return findKthLargest(a, low, i - 1, k);
        }
    }

    public static void sort(int[] a, int low, int high) {
        System.out.println(Arrays.toString(a));

        if (low >= high)
            return;
        int i = low;
        int j = high;
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key)
                j--;
            a[i] = a[j];
            while (i < j && a[i] <= key)
                i++;
            a[j] = a[i];
        }
        a[i] = key;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }


}
