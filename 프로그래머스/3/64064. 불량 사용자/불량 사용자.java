import java.util.*;

class Solution {
    HashSet<String> uniqueSets = new HashSet<>();
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(0, banned_id, user_id, new String[banned_id.length]);
        return uniqueSets.size();
    }
    
    private void dfs(int depth, String[] banned_id, String[] user_id, String[] selected){
        if(depth == banned_id.length){
            String[] copy = selected.clone();
            Arrays.sort(copy);
            uniqueSets.add(String.join(",", copy));
            return;
        }
        
        String currentBan = banned_id[depth];
        
        for(int i = 0; i < user_id.length; i++){
            if(!visited[i] && isMatch(user_id[i], currentBan)){
                visited[i] = true;
                selected[depth] = user_id[i];
                dfs(depth + 1, banned_id, user_id, selected);
                visited[i] = false;
            }
        }
    }
    
    private boolean isMatch(String userId, String bannedId){
        if(userId.length() != bannedId.length()) return false;
        
        for(int i = 0; i < userId.length(); i++){
            char b = bannedId.charAt(i);
            if(b != '*' && b != userId.charAt(i)) return false;
        }
        return true;
    }
}