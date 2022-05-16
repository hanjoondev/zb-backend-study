package NohYeongHun.unknown;

public class U240711 {
    public static String solution(String s) {

        if(s.length() <= 1){
            return s;
        }
        int p1 = 0;
        int p2 = s.length() - 1;

        while(p1 < p2 && s.charAt(p1) == s.charAt(p2)){
            char c = s.charAt(p2);

            while(p1 <= p2 && s.charAt(p1) == c){
                p1++;
            }
            while(p1 <= p2 && s.charAt(p2) == c){
                p2--;
            }

        }

        return s.substring(p1, p2 + 1);
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("ab"));         // ab
        System.out.println(solution("aaabbaa"));    //
        System.out.println(solution("aabcddba"));   // cdd
        System.out.println(solution("aabcddbx"));   // cdd
    }
}