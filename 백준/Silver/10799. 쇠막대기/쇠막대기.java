import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> s = new Stack<>();
        int result = 0;

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '('){
                s.push(c);
            }else{
                s.pop();
                if(input.charAt(i - 1) == ')'){
                    result += 1;
                }else result += s.size();
            }
        }
        System.out.println(result);
    }
}