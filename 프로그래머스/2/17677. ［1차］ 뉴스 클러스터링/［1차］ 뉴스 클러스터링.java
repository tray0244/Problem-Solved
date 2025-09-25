import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> part1 = new ArrayList<>();
        List<String> part2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);
            if(sub.matches("[a-z]{2}")){
                part1.add(sub);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2);
            if(sub.matches("[a-z]{2}")){
                part2.add(sub);
            }
        }

        Map<String, Integer> union1 = new HashMap<>();
        Map<String, Integer> union2 = new HashMap<>();

        for(String p1 : part1){
            union1.put(p1, union1.getOrDefault(p1, 0) + 1);
        }

        for(String p2 : part2){
            union2.put(p2, union2.getOrDefault(p2, 0) + 1);
        }
        
        int inter = 0;
        int uni = 0;

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(union1.keySet());
        allKeys.addAll(union2.keySet());

        for (String key : allKeys) {
            int count1 = union1.getOrDefault(key, 0);
            int count2 = union2.getOrDefault(key, 0);

            inter += Math.min(count1, count2);
            uni   += Math.max(count1, count2);
        }

        if(inter == 0 && uni == 0){
            return 65536;
        }

        double zakad = (double)inter / uni;
        int answer = (int)Math.floor(zakad * 65536);

        return answer;
    }
}