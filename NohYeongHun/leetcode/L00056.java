package NohYeongHun.leetcode;

import java.util.*;

public class L00056 {
    public int[][] solution(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        // 우선 시작 값, 종료 값에 맞춰서 정렬.
        Arrays.sort(intervals,
                (x,y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        int prevFront = intervals[0][0];
        int prevBack = intervals[0][1];

        ArrayList<int[]> result = new ArrayList<>(List.of(new int[]{prevFront, prevBack}));

        int resIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            int curFront = intervals[i][0];
            int curBack = intervals[i][1];

            if(curFront <= prevBack){
                if(prevBack > curBack){
                    continue;
                }
                prevBack = curBack;
                result.set(resIdx, new int[]{prevFront, prevBack});

            }else{
                result.add(new int[]{curFront, curBack});
                prevFront = curFront;
                prevBack = curBack;
                resIdx++;
            }
        }
        int[][] res = new int[result.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
