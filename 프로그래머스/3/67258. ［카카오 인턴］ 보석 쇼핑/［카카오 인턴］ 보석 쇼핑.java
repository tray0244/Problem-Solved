import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> allFind = new HashSet<>();
        for(String g : gems) allFind.add(g);
        int total = allFind.size();
        
        Map<String, Integer> windowCount = new HashMap<>();
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        
        for(int end = 0; end < gems.length; end++){
            windowCount.put(gems[end], windowCount.getOrDefault(gems[end], 0) + 1);
            
            while(windowCount.size() == total){
                int curLength = end - start - 1;
                if(curLength < minLength){
                    minLength = curLength;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                
                String leftGem = gems[start];
                windowCount.put(leftGem, windowCount.get(leftGem)- 1);
                if(windowCount.get(leftGem) == 0){
                    windowCount.remove(leftGem);
                }
                start++;
            }
        }
        return answer;
    }
}