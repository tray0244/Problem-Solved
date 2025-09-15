import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] wordMasks;
    static int answer = 0;
    static int essentialMask;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wordMasks = new int[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= (1 << (word.charAt(j) - 'a'));
            }
            wordMasks[i] = mask;
        }

        // 필수 알파벳 5개
        essentialMask = 0;
        for (char c : new char[]{'a','n','t','i','c'}) {
            essentialMask |= (1 << (c - 'a'));
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }

        search(0, 0, essentialMask);
        System.out.println(answer);
    }

    static void search(int idx, int count, int learnedMask) {
        if (count == K - 5) {
            int readable = 0;
            for (int mask : wordMasks) {
                if ((mask & ~learnedMask) == 0) { // learnedMask가 wordMask를 모두 포함
                    readable++;
                }
            }
            answer = Math.max(answer, readable);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((essentialMask & (1 << i)) != 0) continue; // 이미 필수 알파벳은 건너뜀
            if ((learnedMask & (1 << i)) == 0) {
                search(i + 1, count + 1, learnedMask | (1 << i));
            }
        }
    }
}