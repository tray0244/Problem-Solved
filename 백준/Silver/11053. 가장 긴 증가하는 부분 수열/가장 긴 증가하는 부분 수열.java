import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(A[j] < A[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}