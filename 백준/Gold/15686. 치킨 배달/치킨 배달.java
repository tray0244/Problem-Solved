import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] maps;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static void dfs(int depth, int start, int[] pick) {
        if (depth == M) {

            int sum = 0;
            for (int[] h : house) {
                int dist = Integer.MAX_VALUE;
                for (int p : pick) {
                    int[] c = chicken.get(p);
                    dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
                sum += dist;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            pick[depth] = i;
            dfs(depth + 1, i + 1, pick);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] == 2) chicken.add(new int[]{i, j});
                if(maps[i][j] == 1) house.add(new int[]{i, j});
            }
        }

        dfs(0, 0, new int[M]);
        System.out.println(answer);
    }
}