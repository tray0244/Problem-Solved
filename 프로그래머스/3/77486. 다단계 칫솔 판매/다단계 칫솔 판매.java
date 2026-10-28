import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < seller.length; i++){
            String current = seller[i];
            int money = amount[i] * 100;
            
            while(!current.equals("-")){
                int up = money / 10;
                answer[index.get(current)] += money - up;
                current = parent.get(current);
                
                if(up == 0) break;
                money = up;
            }
        }
        return answer;
    }
}