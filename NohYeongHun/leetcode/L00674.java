package NohYeongHun.leetcode;

import java.util.Arrays;

public class L00674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n < 2 ? 2 : n + 1];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            if(nums[i - 1] < nums[i]){
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = new int[]{10, 20, 30, 10, 50, 10};
        System.out.println(new L00674().findLengthOfLCIS(arr));
        arr = new int[]{1,3,5,4,7};
        System.out.println(new L00674().findLengthOfLCIS(arr));
    }
}
