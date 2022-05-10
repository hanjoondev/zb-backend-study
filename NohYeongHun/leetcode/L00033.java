package NohYeongHun.leetcode;

public class L00033 {
    public int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivotIdx = 0;

        // pivot search
        while(left <= right){
            if(nums[left] <= nums[right] && nums[left] < nums[pivotIdx]){
                pivotIdx = left;
            }else if(nums[right] < nums[left] && nums[right] < nums[pivotIdx]){
                pivotIdx = right;
            }
            left++;
            right--;
        }

        int front = binarySearch(nums, 0, pivotIdx - 1, target);
        int back = binarySearch(nums, pivotIdx, nums.length - 1, target);

        return front != -1 ? front : back;
    }
    
    public int binarySearch(int[] nums, int left, int right, int target){

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }

        return -1;
    }
}
