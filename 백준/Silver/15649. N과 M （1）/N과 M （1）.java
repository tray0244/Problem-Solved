import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] result;
    
    public static void backtrack(int depth) {
        if (depth == M) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }    
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true; 
                result[depth] = i; 
                backtrack(depth + 1); 
                
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        visited = new boolean[N + 1];
        result = new int[M];
        
        backtrack(0);
    }
}
