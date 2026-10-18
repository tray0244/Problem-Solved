import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> allRoutes;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        allRoutes = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs("ICN", "ICN", 0, tickets);
        
        return allRoutes.get(0).split(" ");
    }
    
    boolean dfs(String current, String route, int depth, String[][] tickets){
        if(depth == tickets.length){
            allRoutes.add(route);
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], depth + 1, tickets);
                visited[i] = false;
            }
        }
        return false;
    }
}