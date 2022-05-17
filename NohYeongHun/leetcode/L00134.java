package NohYeongHun.leetcode;

public class L00134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prevVal = 0;
        int startIdx = 0;
        int val = 0;
        
        for (int i = 0; i < gas.length; i++) {
            val += gas[i] - cost[i];

            if(val < 0){
                prevVal += val;
                startIdx = i + 1;
                val = 0;
            }
        }

        return val + prevVal >= 0 ? startIdx : -1;
    }
    
    public static void main(String[] args) {
        // Test code
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new L00134().canCompleteCircuit(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(new L00134().canCompleteCircuit(gas, cost));

        gas = new int[]{5,8,2,8};
        cost = new int[]{6,5,6,6};
        System.out.println(new L00134().canCompleteCircuit(gas, cost));
    }

}
