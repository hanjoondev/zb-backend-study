package NohYeongHun.leetcode;

import java.util.*;

public class L00015 {
    public List<List<Integer>> solution(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int length = nums.length;
        Set<List<Integer>> curSet = new HashSet<>();
        List<Integer> curArr = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int cur = nums[i];
            int p1 = i + 1;
            int p2 = length - 1;
            curArr = new ArrayList<>();

            while(p1 < p2){
                // 1. 합이 0 이라면?
                if(cur + nums[p1] + nums[p2] == 0){
                    curArr.add(cur);
                    curArr.add(nums[p1++]);
                    curArr.add(nums[p2--]);
                    curSet.add(curArr);
                    curArr = new ArrayList<>();
                }
                // 2. 합이 0보다 작으면
                while(p1 < p2 && cur + nums[p1] + nums[p2] < 0 ){
                    p1++;
                }

                // 3. 합이 0보다 크면?
                while(p1 < p2 && cur + nums[p1] + nums[p2] > 0){
                    p2--;
                }
            }
        }


        List<List<Integer>> result = new ArrayList<>(curSet);

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-1, 0, 1, 2, -1, -4};     // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(new L00015().solution(nums));

        nums = new int[] {1, -7, 6, 3, 5, 2};   // [[-7, 1, 6], [-7, 2, 5]]
        System.out.println(new L00015().solution(nums));
    }
}