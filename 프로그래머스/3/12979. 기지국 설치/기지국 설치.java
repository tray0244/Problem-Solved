class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;
        int prevEnd = 0;
        
        for(int station : stations){
            int start = station - w;
            int gap = start - prevEnd - 1;
            if(gap > 0){
                answer += (gap + range - 1) / range;
            }
            prevEnd = Math.max(prevEnd, station + w);
        }
        int lastGap = n - prevEnd;
        if(lastGap > 0){
            answer += (lastGap + range - 1) / range;
        }
        
        return answer;
    }
}