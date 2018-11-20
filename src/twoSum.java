import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 */
public class twoSum {

    public static void main(String[] args) {
        int a[] = {3, 3};

        System.out.println(twoSum(a, 6)[0] + "," + twoSum(a, 6)[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        //存储符合条件的元素的两个下标
        int[] result = new int[2];
        int[] temp = Arrays.copyOf(nums, nums.length);

        //先进行排序，由大到小
        Arrays.sort(temp);
        int left = 0, right = temp.length - 1;
        //从左边和右边，往中间进行遍历
        while (true) {
            int sum = temp[left] + temp[right];
            if (sum == target) {
                //计算在数组中的位置
                for (int i = 0; i < nums.length; i++) {
                    if (temp[left] == nums[i]) {
                        result[0] = i;
                        break;
                    }
                }
                for (int i = nums.length - 1; i > 0; i--) {
                    if (temp[right] == nums[i]) {
                        result[1] = i;
                        break;
                    }
                }
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    /**
     * 优化方法，利用哈希表
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     */
    public static int[] twoSum2(int[] nums, int target) {
        //存储符合条件的元素的两个下标
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
