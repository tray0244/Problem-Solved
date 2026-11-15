import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        answer = map.keySet().size();
        if(answer > (nums.length / 2)){
            answer = nums.length / 2;
        }
        return answer;
    }
}