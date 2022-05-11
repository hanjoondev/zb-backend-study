package NohYeongHun.leetcode;

public class L00410 {
    
    public int solution(int[] nums, int m) {
        int right = 0, left = 0;
        for(int num : nums){
            if(left < num){
                left = num;
            }
            right += num;
        }

        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 1;
            int curNum = 0;
            for(int num : nums){
                if(curNum + num > mid){
                    cnt++;
                    curNum = 0;
                }
                curNum += num;
            }

            if(cnt > m) left = mid + 1;
            else right = mid - 1;

        }
        return left;
    }
}
