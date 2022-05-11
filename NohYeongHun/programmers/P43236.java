package NohYeongHun.programmers;

import java.util.Arrays;

public class P43236 {
    public int solution(int distance, int[] rocks, int n) {
        /*
            바위를 제거했을 때
            거리의 최소값이 가장 크게 만들기.
        */
        // 정렬
        Arrays.sort(rocks);

        int left = 0;
        int right = distance;
        
        // 지운 값 중에 최대값
        int result = Integer.MIN_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            // 초기 돌의 위치
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid){
                    cnt++;
                }else{
                    prev = rocks[i];
                }

                if (cnt > n) {
                    break;
                }

            }
            if(distance - prev < mid){
                cnt++;
            }

            // 지운 돌의 개수가 많으므로 => mid 감소.
            if(cnt > n) right = mid -1 ;

            // 지운 돌의 개수 적으므로 => mid 증가.
            else{
                result = mid > result ? mid : result;
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int distance = 25;
        int[] rocks = {11, 2, 14, 21, 17};
        int n = 2;
        System.out.println(new P43236().solution(distance, rocks, n));
    }
}
