import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[N + 1][10];
        
        for(int j = 0; j < 10; j++){
            dp[1][j] = 1;
        }
        
        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        
        int answer = 0;
        for(int j = 0; j <= 9; j++){
            answer += dp[N][j];
            answer %= 10007;
        }
        System.out.println(answer);
    }
}