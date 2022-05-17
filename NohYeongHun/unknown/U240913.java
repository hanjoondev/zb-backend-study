package NohYeongHun.unknown;

public class U240913 {
    public int solution(int n) {
        if(n == 1){
            return 0;
        }
        else if(n % 2 == 0){
            return 1 + solution(n / 2);
        }else{
            return 1 + Math.min(solution(n - 1), solution(n + 1));
        }
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(new U240913().solution(8));    // 3
        System.out.println(new U240913().solution(7));    // 4
        System.out.println(new U240913().solution(9));    // 4
        System.out.println(new U240913().solution(6));    // 3
        System.out.println(new U240913().solution(127));    // 8
    }
}