package NohYeongHun.leetcode;

public class L00122 {
    public int solution(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int result = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]){
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] prices = {5, 1, 6, 4, 3, 5};
        System.out.println(new L00122().solution(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(new L00122().solution(prices));

        prices = new int[]{5, 4, 3, 2, 1};
        System.out.println(new L00122().solution(prices));
    }

}