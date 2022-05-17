package NohYeongHun.leetcode;

public class L00670 {
    public int maximumSwap(int num) {
        char[] charNum = String.valueOf(num).toCharArray();
        int p1 = charNum.length - 1;
        int maxPos = charNum.length -1;
        int p2 = charNum.length -1;
        int maxNum = charNum[p2] - '0';

        for (int i = charNum.length - 1; i >= 0; i--) {
            int curNum = charNum[i] - '0';

            if(curNum < maxNum){
                p1 = i;
                p2 = maxPos;
            }else if(curNum > maxNum){
                maxNum = curNum;
                maxPos = i;
            }
        }

        char temp = charNum[p1];
        charNum[p1] = charNum[p2];
        charNum[p2] = temp;

        return Integer.parseInt(String.valueOf(charNum));
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(new L00670().maximumSwap(2736));
        System.out.println(new L00670().maximumSwap(7116));
        System.out.println(new L00670().maximumSwap(91));
    }
}
