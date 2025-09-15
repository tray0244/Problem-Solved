import java.util.*;
import java.io.*;
/*
1062번 가르침
*/
public class Main{
    static int N, K;
    static String[] words;
    static int count = 0;
    static boolean[] visited = new boolean[26];

    public static void search(int idx, int depth) {
        if (depth == K - 5) {
            int readable = 0;
            for (int i = 0; i < N; i++) {
                boolean canRead = true;
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (!visited[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) readable++;
            }
            count = Math.max(count, readable);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        if (K < 5) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);
        } else {
            search(0, 0);
            System.out.println(count);
        }
        return;
    }
}