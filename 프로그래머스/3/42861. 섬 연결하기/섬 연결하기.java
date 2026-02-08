import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int v = 0;
        
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int[] cost : costs){
            int nodeA = cost[0];
            int nodeB = cost[1];
            int vertex = cost[2];
            
            if(find(nodeA) != find(nodeB)){
                union(nodeA, nodeB);
                answer += vertex;
                v++;
                
                if(v == n - 1) break;
            }
        }
        return answer;
    }
    
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y){
        int X = find(x);
        int Y = find(y);
        if(X != Y){
            parent[Y] = X;
        }
    }
}