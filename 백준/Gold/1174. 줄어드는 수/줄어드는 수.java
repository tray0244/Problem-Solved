import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            N = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            dfs(i, 1);
        }

        Collections.sort(list);

        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }
    }

    static void dfs(long num, int len) {
        list.add(num);

        int lastDigit = (int) (num % 10);

        for (int i = 0; i < lastDigit; i++) {
            dfs(num * 10 + i, len + 1);
        }
    }
}