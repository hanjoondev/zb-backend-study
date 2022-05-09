package NohYeongHun.leetcode;

import java.util.*;

public class L00049{
    public List<List<String>> solution(String[] strs) {
        /*
            1. 배열을 순회한다.
            2. 정렬된 문자열을 HashMap의 키로 설정한다.
            3 - 1. 정렬된 문자열이 있는 경우
            => 해당 Key에 Value 추가
            3 - 2. 정렬된 문자열이 없는 경우
            => 새로운 Key 생성 후 Value 추가.
            
        */
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        if(strs.length == 1){
            List<String> list = new ArrayList<String>(List.of(strs));
            return new ArrayList<List<String>>(List.of(list));
        }


        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String item: strs){
            char[] sortItem = item.toCharArray();
            Arrays.sort(sortItem);
            String mapKey = String.valueOf(sortItem);

            ArrayList<String> li = map.getOrDefault(mapKey, new ArrayList<String>());
            li.add(item);
            map.put(mapKey, li);
        }

        List<List<String>> result = new ArrayList<>(map.values());

        return result;
    }
}