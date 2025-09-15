import java.util.*;
import java.io.*;

class Solution {
    static Map<Character, Integer> score = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        for(char c : new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'}){
            score.put(c, 0);
        }
        
        for(int i = 0; i < survey.length; i++){
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            int choice = choices[i];
            
            if(choice < 4){
                score.put(left, score.get(left) + (4 - choice));
            } else if(choice > 4){
                score.put(right, score.get(right) + (choice - 4));
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