package NohYeongHun.leetcode;

import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int item: nums){
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(countMap.keySet());
        Collections.sort(list);

        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            int cnt = countMap.get(list.get(i));
            while(cnt > 0){
                nums[idx++] = list.get(i);
                cnt--;
            }
        }
    }
}