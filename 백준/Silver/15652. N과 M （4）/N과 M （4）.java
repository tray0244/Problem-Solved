import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        search(1, 0);
        System.out.println(sb);
        }

    static void search(int start, int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <=  N; i++){
            arr[depth] = i;
            search(i, depth + 1);
        }
    }
}