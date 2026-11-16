import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            q.offer(i);   // 진도가 아니라 작업 번호를 넣는다
        }
        
        int time = 0;     // 시작한 뒤 지난 날 수
        while(!q.isEmpty()){
            int current = q.poll();   // 맨 앞 작업
            
            // 1. 맨 앞 작업이 끝날 때까지 하루씩 센다
            while(progresses[current] + time * speeds[current] < 100){
                time++;
            }
            
            // 2. 그날 함께 끝난 뒤 작업들을 꺼낸다
            int count = 1;
            while(!q.isEmpty() && progresses[q.peek()] + time * speeds[q.peek()] >= 100){
                q.poll();
                count++;
            }
            answerList.add(count);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}