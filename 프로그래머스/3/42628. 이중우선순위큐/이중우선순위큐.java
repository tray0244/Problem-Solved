import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            if(command.equals("I")){
                    max.offer(value);
                    min.offer(value);
                }else if(command.equals("D")){
                    if(min.isEmpty()) continue;
                    if(value > 0){
                        int cur = max.poll();
                        min.remove(cur);
                    }else{
                        int cur = min.poll();
                        max.remove(cur);
                    }
                }
            }
        
        if(!min.isEmpty()){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        return answer;
    }
}