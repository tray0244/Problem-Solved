import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        int[] dp = new int[100001];
        int[] coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i <= K; i++){
            for(int c : coin){
                if(i - c >= 0){
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        System.out.println(dp[K] == 100001 ? -1 : dp[K]);
    }
}