class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            
            answer = Math.max(answer, Math.max(odd, even));
        }
        return answer;
    }
    
    private int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        return right - left - 1;
    }
}