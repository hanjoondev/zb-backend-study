package NohYeongHun.leetcode;

public class L00053 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int length = nums.length;
        int curSum = 0;
        int right = 0;
        int left = 0;

        for (int i = 0; i < length; i++) {
            if(curSum < 0){
                curSum = nums[i];
            }else{
                curSum += nums[i];
            }
            
            max = Math.max(curSum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(new L00053().maxSubArray(nums));

        nums = new int[]{5, 4, 0, 7, 8};
        System.out.println(new L00053().maxSubArray(nums));

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new L00053().maxSubArray(nums));

        nums = new int[]{-2,1};
        System.out.println(new L00053().maxSubArray(nums));

        nums = new int[]{1, 2};
        System.out.println(new L00053().maxSubArray(nums));

        nums = new int[]{8,-19,5,-4,20};
        System.out.println(new L00053().maxSubArray(nums));
    }
}
