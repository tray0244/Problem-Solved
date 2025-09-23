import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int unique = 0;

        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) unique++;
            count[belt[i]]++;
        }

        int answer = unique;
        if (count[c] == 0) answer++;

        for (int i = 1; i < N; i++) {
            int left = belt[i - 1];
            count[left]--;
            if (count[left] == 0) unique--;

            int right = belt[(i + k - 1) % N];
            if (count[right] == 0) unique++;
            count[right]++;

            int current = unique;
            if (count[c] == 0) current++;

            answer = Math.max(answer, current);
        }

        System.out.println(answer);
    }
}