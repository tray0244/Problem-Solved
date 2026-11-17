import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int arrIdx = 0;
        answer = new int[commands.length];
        for(int[] c : commands){
            int i = c[0];
            int j = c[1];
            int k = c[2];
            int[] arr = new int[j - i + 1];
            
            int idx = 0;
            for(int a = i - 1; a < j; a++){
                arr[idx] = array[a];
                idx++;
            }
            Arrays.sort(arr);
            
            int count = 1;
            for(int a : arr){
                if(count == k){
                    answer[arrIdx] = a;
                    arrIdx++;
                    break;
                }else count++;
            }
            System.out.println(Arrays.toString(arr));
            
        }
        return answer;
    }
}