import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int camera = Integer.MIN_VALUE;
        
        for(int[] r : routes){
            int start = r[0];
            int end = r[1];
            
            if(camera < start){
                answer++;
                camera = end;
            }else continue;
        }
        return answer;
    }
}