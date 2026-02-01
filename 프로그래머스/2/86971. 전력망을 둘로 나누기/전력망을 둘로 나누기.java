import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int count = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i = 0; i < wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            graph[u].remove((Integer) v);
            graph[v].remove((Integer) u);
            
            search(1);
            answer = Math.min(answer, Math.abs(count - (n - count)));
            
            count = 0;
            Arrays.fill(visited, false);
            graph[u].add(v);
            graph[v].add(u);
        }
        return answer;
    }
    
    static void search(int node){
        visited[node] = true;
        count++;
        for(int next : graph[node]){
            if(!visited[next]) search(next);
        }
    }
}

