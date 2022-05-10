package NohYeongHun.leetcode;

public class L00581 {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1){
             return 0;
         }
 
         int start = 0, end = -1;
         int prevMin = Integer.MAX_VALUE, prevMax = Integer.MIN_VALUE;
 
         int idx = 0;
         while(idx < nums.length){
             if(prevMax < nums[idx]){
                 prevMax = nums[idx];
             }else if(nums[idx] < prevMax){
                 end = idx;
             }
             idx++;
         }
 
         idx = nums.length - 1;
         while(idx >= 0){
             if(prevMin > nums[idx]){
                 prevMin = nums[idx];
             }else if(nums[idx] > prevMin){
                 start = idx;
             }
             idx--;
         }
 
         return end - start + 1;
     }
}
