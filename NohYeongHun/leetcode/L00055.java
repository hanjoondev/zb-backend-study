package NohYeongHun.leetcode;

public class L00055 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1){
            return true;
        }

        int end = nums.length - 1;
        int cur = 0;
        for (int i = 0; i < end; i++) {

            cur = Math.max(nums[i] , cur - 1);

            if(cur <= 0){
                return false;
            }

            if((i + cur) >= end){
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(new L00055().canJump(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(new L00055().canJump(nums));

        nums = new int[]{0};
        System.out.println(new L00055().canJump(nums));

        nums = new int[]{3, 0, 0, 1, 1};
        System.out.println(new L00055().canJump(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(new L00055().canJump(nums));
    }
}
