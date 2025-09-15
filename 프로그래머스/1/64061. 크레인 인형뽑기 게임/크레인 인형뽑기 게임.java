import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> s = new Stack<>();
        
        for(int m : moves){
            int col = m - 1;
            for(int row = 0; row < N; row++){
                if(board[row][col] != 0){
                    int doll = board[row][col];
                    board[row][col] = 0;
                    
                    if(!s.isEmpty() && s.peek() == doll){
                        s.pop();
                        answer += 2;
                    } else{
                        s.push(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}