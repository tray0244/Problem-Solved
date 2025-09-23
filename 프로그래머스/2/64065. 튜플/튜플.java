import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2); // 앞에 2개, 뒤에 2개를 자른다.
        String[] parts = s.split("\\},\\{");
        Arrays.sort(parts, (a, b) -> a.length() - b.length());
        List<Integer> answerList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for(String part : parts){
            String[] nums = part.split(",");
            for(String numStr : nums){
                int num = Integer.parseInt(numStr);
                if(!seen.contains(num)){
                    answerList.add(num);
                    seen.add(num);
                }
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}