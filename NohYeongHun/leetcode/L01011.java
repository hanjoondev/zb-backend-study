package NohYeongHun.leetcode;

public class L01011{
    public int solution(int[] weights, int days) {
        int maxWeight = 0, maxRange = 0;
        for(int weight : weights){
            if(maxWeight < weight){
                maxWeight = weight;
            }
            maxRange = maxRange + weight;
        }

        while(maxWeight <= maxRange){
            int mid = (maxWeight + maxRange) / 2;
            int day = 1;
            int curWeight = 0;
            for(int w : weights){
                if(curWeight + w > mid){
                    // 적재량 제한을 넘을 때마다 요일을 증가 시킨다.
                    day++;
                    curWeight = 0;
                }
                curWeight += w;
            }

            if(day > days) {
                // 필요 이상으로 많이 쪼갰으므로 쪼개는 허용 값의 범위를 늘려야 한다.
                maxWeight = mid + 1;
            } else {
                // 필요 만큼 쪼갰거나 적게 쪼갰으므로 허용 값의 범위를 좁혀야 한다.
                maxRange = mid - 1;
            }
        }

        return maxWeight;
    }
}