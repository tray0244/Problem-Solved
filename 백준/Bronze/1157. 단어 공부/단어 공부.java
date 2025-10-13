import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();

        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        char answer = '?';
        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count > max) {
                max = count;
                answer = key;
            } else if (count == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}