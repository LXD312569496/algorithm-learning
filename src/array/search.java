package array;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class search {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        return searchNum(nums, 0, nums.length - 1, target);
    }

    public static int searchNum(int nums[], int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < nums[right]) {
            //右侧有序
            if (target > nums[mid] && target <= nums[right]) {
                //目标值在mid的左侧还是右侧
                return searchNum(nums, mid + 1, right, target);
            } else {
                return searchNum(nums, left, mid - 1, target);
            }
        } else {
            //左侧有序
            if (nums[mid] > target && nums[left] <= target) {
                return searchNum(nums, left, mid - 1, target);
            } else {
                return searchNum(nums, mid + 1, right, target);
            }
        }
    }
}
