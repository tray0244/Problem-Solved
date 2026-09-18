import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n == 1) return sticker[0];
        
        int caseA = solveLinear(sticker, 0, n - 2);
        int caseB = solveLinear(sticker, 1, n - 1);
        
        return Math.max(caseA, caseB);
    }
    
    private int solveLinear(int[] sticker, int start, int end){
        int len = end - start + 1;
        int[] dp = new int[len];
        dp[0] = sticker[start];
        
        if(len > 1){
            dp[1] = Math.max(sticker[start], sticker[start + 1]);
        }
        
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }
        
        return dp[len - 1];
    }
}