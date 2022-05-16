package NohYeongHun.leetcode;
import java.util.Stack;

public class L00151 {
    public String reverseWords(String s) {
        String str = removeSpaces(s);
        Stack<String> result = new Stack<>();
        for (String item : str.split(" ")){
            result.push(item);
        }
        StringBuilder sb = new StringBuilder();
        int length = result.size();

        for (int i = 0; i < length - 1; i++) {
            sb.append(result.pop());
            sb.append(" ");
        }

        sb.append(result.pop());

        return sb.toString();
    }
    
    public String removeSpaces(String s) {
        int p1 = 0;
        int p2 = 0;

        char[] cArr = s.toCharArray();
        int length = s.length();

        while (p2 < length) {
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            while (p2 < length && cArr[p2] != ' ') {
                cArr[p1++] = cArr[p2++];
            }

            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            if (p2 < length) {
                cArr[p1++] = ' ';
            }
        }

        return new String(cArr).substring(0, p1);
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(new L00151().reverseWords("the sky is blue"));
        System.out.println(new L00151().reverseWords("  hello      java    "));
        System.out.println(new L00151().reverseWords("a good   example"));
    }
}
