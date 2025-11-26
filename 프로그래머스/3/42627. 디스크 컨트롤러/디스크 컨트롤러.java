import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int now = 0; // 현 시간
        int count = 0; // 완성된 수
        int end = -1; // 마지막 작업이 끝난 시간
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while(count < jobs.length){
            for(int[] job : jobs){
                if(end < job[0] && job[0] <= now)
                    pq.offer(new int[]{job[0], job[1]});
            }
            if(!pq.isEmpty()){
                int[] current = pq.poll();
                end = now;
                now += current[1];
                answer += now - current[0];
                count++;
            }
            else
                now++;
        }
        
        return answer / jobs.length;
    }
}