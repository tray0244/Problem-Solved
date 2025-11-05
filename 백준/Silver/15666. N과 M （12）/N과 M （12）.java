import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        search(0, 0);
        System.out.println(sb);
    }

    static void search(int depth, int start){
        if(depth == M){
            for(int i =0; i < M; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (arr[i] == prev) continue;
            prev = arr[i];
            answer[depth] = arr[i];
            search(depth + 1, i);
        }
    }
}