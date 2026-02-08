class Solution {
    long left, right;
    
    public long solution(int n, int[] times) {
        long answer = 0;
        left = 1;
        right = (long)times[times.length - 1] * n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(int time : times){
                sum += mid / time;
            }
            
            if(sum < n){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}