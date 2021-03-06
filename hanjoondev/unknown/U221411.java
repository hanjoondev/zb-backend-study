package hanjoondev.unknown;

import java.util.Arrays;

public class U221411 {

    public static int[] solution(int[] arr){
        int idx = 0, len = arr.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (ans[i] == 0) 
                    break;
                idx = (idx + 1) % len;
            }
            ans[idx] = arr[i];
            idx = (idx + 1) % len;
        }
        return ans;
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];

        while (cnt < arr.length) {
            while (val == 0) {
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }
            arrNew[cnt++] = val;
            arr[idx] = 0;
            idx = (val + idx) % arr.length;
            val = arr[idx];
        }
        return arrNew;
    }


    public static void main(String[] args) {
        // Test code
        // Modification test
        int[] arr = {1, 3, 7, 9, 5};
        int[] arrNew = modification(arr);
        System.out.println(Arrays.toString(arrNew));

        // Revert data
        arr = new int[]{1, 3, 5, 7, 9};
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));
    }
}
