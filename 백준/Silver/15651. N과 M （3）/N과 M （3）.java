import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M]; // N개의 한 값당 M개의 값을 가져야 한다.
        
        search(1, 0);
        System.out.println(sb);
    }
    /*
    만약 입력값이 4 2라면
    search함수 입력값 n = 1 -> n = 3까지 실행해야 한다.
    기저조건은 N이 가질 수 있는 m을 찾아내는 영역
    1 -> 3
    */
    private static void search(int n, int m){
        if(m == M){
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 1; i <= N; i++){
            arr[m] = i;
            search(i + 1, m + 1);
        }
    }
}