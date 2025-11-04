import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
    static int N, M;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        search(0);
    }

    static void search(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.print("\n");
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = arr[i];
                search(depth + 1);
                visited[i] = false;
            }
        }
    }
}