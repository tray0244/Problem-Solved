import java.util.*;

class Solution {
    static Map<Character, Integer> score = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        
       for(char c : new char[]{'R', 'T', 'F', 'C', 'M', 'J', 'A', 'N'}){
           score.put(c, 0);
       }
        
        for(int i = 0; i < survey.length; i++){
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            int num = choices[i];
            
            if(num < 4){
                score.put(left, score.get(left) + (4 - num));
            }else{
                score.put(right, score.get(right) + (num - 4));
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(score.get('R') >= score.get('T') ? 'R' : 'T');
        result.append(score.get('C') >= score.get('F') ? 'C' : 'F');
        result.append(score.get('J') >= score.get('M') ? 'J' : 'M');
        result.append(score.get('A') >= score.get('N') ? 'A' : 'N');
        
        return result.toString();
    }
}