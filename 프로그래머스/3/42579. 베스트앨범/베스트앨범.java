import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> map = new HashMap<>();
        
        for (int idx = 0; idx < genres.length; idx++) {
            String genre = genres[idx];
            if (!map.containsKey(genre)) {
                map.put(genre, new ArrayList<>());
            }
            map.get(genre).add(new int[]{idx, plays[idx]});
        }
        
        Map<String, Integer> totalPlays = new HashMap<>();
        for (String genre : map.keySet()) {
            int sum = 0;
            for (int[] song : map.get(genre)) {
                sum += song[1];
            }
            totalPlays.put(genre, sum);
        }
        
        List<String> genreOrder = new ArrayList<>(map.keySet());
        genreOrder.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        for (String genre : genreOrder) {
            List<int[]> songs = map.get(genre);
            songs.sort((a, b) -> b[1] - a[1]);
            
            int count = Math.min(2, songs.size());
            for (int i = 0; i < count; i++) {
                answerList.add(songs.get(i)[0]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}