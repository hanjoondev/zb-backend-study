package NohYeongHun.leetcode;

public class L00074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1){
            return binarySearch(matrix[0], 0, matrix[0].length - 1, target);
        }

        // 각 행의 첫번째 값이 target 보다 큰지 비교
         int targetIdx = -1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == target){
                return true;
            }
            else if(matrix[i][0] < target){
                targetIdx = i;
            }
        }

        if(targetIdx == -1){
            return false;
        }
        
        return binarySearch(matrix[targetIdx], 0, matrix[0].length - 1, target);
    }
    
    public boolean binarySearch(int nums[], int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }


        return false;
    }
}
