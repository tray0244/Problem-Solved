import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }
        int totalRain = 0;
        
        
        
        for(int i = 1; i < W - 1; i++){
            int leftMax = 0;
            int rightMax = 0;
            
            for(int j = 0; j < i; j++){
                leftMax = Math.max(leftMax, block[j]);
            }
            
            for(int j = i + 1; j < W; j++){
            rightMax = Math.max(rightMax, block[j]);
            }
            
            int bound = Math.min(leftMax, rightMax);
            
            if(bound > block[i]){
                totalRain += bound - block[i];
            }
        }
        System.out.println(totalRain);
    }
}