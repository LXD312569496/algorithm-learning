import java.util.Arrays;

public class findKthLargest {
    public static void main(String args[]){
        int a[]={1,2,3,4,5,6,8,9};
        System.out.println(findKthLargest(a,5));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
