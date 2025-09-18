import java.util.*;
import java.io.*;

class Solution {
    static int[] left = {3, 0};
    static int[] right = {3, 2};
    
    private int[] getPos(int n){
        if(n == 0) return new int[] {3, 1};
        return new int[]{(n - 1) / 3, (n - 1) % 3};
    }
    
    private int dist(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        for(int n : numbers){
            int[] pos = getPos(n);
            
            if(n == 1 || n == 4 || n == 7){
                sb.append("L");
                left = pos;
            }else if(n == 3 || n == 6 || n == 9){
                sb.append("R");
                right = pos;
            }else{
                int lDist = dist(left, pos);
                int rDist = dist(right, pos);
                
                if(lDist < rDist){
                    sb.append("L");
                    left = pos;
                }else if(lDist > rDist){
                    sb.append("R");
                    right = pos;
                }else {
                    if(hand.equals("right")){
                        sb.append("R");
                        right = pos;
                    }else{
                        sb.append("L");
                        left = pos;
                    }
                }
            }
        }
        return sb.toString();
    }
}