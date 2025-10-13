import java.io.*;
import java.util.*;

public class Main {
    static char ch;
    static boolean flag;
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[10000]; // 충분히 크게
        int idx = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                ch = input.charAt(j);

                if (Character.isDigit(ch)) {
                    sb.append(ch);
                    flag = true;
                } else {
                    if (flag) {
                        n = sb.toString().replaceFirst("^0+", "");
                        if (n.equals("")) n = "0"; // 모두 0이면 "0" 처리
                        arr[idx++] = n;
                        sb.setLength(0);
                        flag = false;
                    }
                }
            }

            if (sb.length() > 0) {
                n = sb.toString().replaceFirst("^0+", "");
                if (n.equals("")) n = "0";
                arr[idx++] = n;
                sb.setLength(0);
                flag = false;
            }
        }

        // 문자열 정렬: 길이 우선, 길이 같으면 사전순
        Arrays.sort(arr, 0, idx, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
        }
    }
}