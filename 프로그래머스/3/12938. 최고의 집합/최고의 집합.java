import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int q = s / n;
        int r = s % n;
        
        if(s < n){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        if((n - r) != 0){
            for(int i = 0; i < (n - r); i++){
                answer[i] = q;
            }
        }
        if(r != 0){
            for(int j= (n - r); j < n; j++){
                answer[j] = q + 1;
            }
        }
        
        return answer;
    }
}