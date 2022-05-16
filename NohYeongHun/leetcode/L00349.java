package NohYeongHun.leetcode;
import java.util.Arrays;
import java.util.HashSet;

public class L00349 {
    public static int[] solution(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return null;
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1){
            set1.add(num);
        }

        for (int num : nums2){
            set2.add(num);
        }

        // 교집합
        set1.retainAll(set2);

        int[] result = new int[set1.size()];
        int idx = 0;
        
        for(int num: set1){
            result[idx++] = num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}