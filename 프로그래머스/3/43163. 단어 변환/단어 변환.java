import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean targetExists = false;

        for(String w : words){
            if(w.equals(target)) {
                targetExists = true;
                break;
            }
        }
        if (!targetExists) return 0;
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j && isOneChar(words[i], words[j])){
                    graph.get(i).add(j);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        for(int i = 0; i < words.length; i++){
            if(!visited[i] && isOneChar(begin, words[i])){
                visited[i] = true;
                q.offer(i);
            }
        }

        int answer = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                
                if(words[cur].equals(target)){
                    return answer;
                }

                for(int next : graph.get(cur)){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            answer++;
        }
        
        
        return 0;
    }

    public static boolean isOneChar(String a, String b){
        int diffCount = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}