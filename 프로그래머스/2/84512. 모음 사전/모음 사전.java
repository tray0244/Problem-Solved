import java.util.*;

class Solution {
    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        search("", 0);
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    static void search(String str, int depth){
        list.add(str);
        if(depth == 5) return;
        
        for(int i = 0; i < 5; i++){
            search(str + words[i], depth + 1);
        }
    }
}