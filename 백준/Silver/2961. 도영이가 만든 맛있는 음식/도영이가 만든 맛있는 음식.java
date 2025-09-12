import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] S;
    static int[] B;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        search(0, 1, 0, false);
        System.out.println(min);
    }

    static void search(int index, int sour, int bitter, boolean onOff){
        if(index == N){
            if(onOff){
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }
        search(index + 1, sour * S[index], bitter + B[index], true);
        search(index + 1, sour, bitter, onOff);
    }
}