import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for(int i = 0; i < N; i++){
                char c = input.charAt(i);
                
                if(c == ')' || c == ']' || c == '}' || c == '>'){
                    if(!stack.isEmpty() && c == ')' && stack.peek() == '(') stack.pop();
                    else if(!stack.isEmpty() && c == ']' && stack.peek() == '[') stack.pop();
                    else if(!stack.isEmpty() && c == '}' && stack.peek() == '{') stack.pop();
                    else if(!stack.isEmpty() && c == '>' && stack.peek() == '<') stack.pop();
                    else stack.push(c);
                } else {
                    stack.push(c);
                }
            }
            
            sb.append("#").append(t).append(" ");
            if(!stack.isEmpty()){
                sb.append(0).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        }
        System.out.println(sb);
    }
}