import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String s = br.readLine();
            if (s.equals("*")) break;
            
            boolean isSurprising = true;

            for (int d = 1; d < s.length(); d++) {
                Set<String> set = new HashSet<>();

                for (int i = 0; i + d < s.length(); i++) {
                    String pair = s.charAt(i) + "" + s.charAt(i + d);
                    if (set.contains(pair)) {
                        isSurprising = false;
                        break;
                    }
                    set.add(pair);
                }

                if (!isSurprising) break;
            }

            if (isSurprising) {
                System.out.println(s + " is surprising.");
            } else {
                System.out.println(s + " is NOT surprising.");
            }
        }
    }
}