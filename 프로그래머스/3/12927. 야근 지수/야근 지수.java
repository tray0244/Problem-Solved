import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work: works){
            pq.offer(work);
        }
        
        for(int i = 0; i < n; i++){
            int cur = pq.poll();
            if(cur == 0) break;
            cur -= 1;
            pq.offer(cur);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer += cur * cur;
        }
        
        return answer;
    }
}

/*
input: works[], n
output: result
rule: 매 시간 1을 깎는다
constraint: works.length = 1 < N < 20000, works = N > 50000, n = n > 1000000
state: n, works
invariant: result

*/
