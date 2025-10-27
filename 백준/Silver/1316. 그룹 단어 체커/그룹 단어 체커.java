import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) count++;
        }

        System.out.println(count);
    }

    public static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char prev = 0;

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if (now != prev) {
                if (visited[now - 'a']) return false;
                visited[now - 'a'] = true;
            }
            prev = now;
        }
        return true;
    }
}