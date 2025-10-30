import java.util.*;
import java.io.*;

public class Main {
    static int N, M, a, b;
    static int[][] arr;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        bfs(a);
        System.out.println(dist[b] == 0 ? -1 : dist[b]);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i = 1; i <= N; i++){
                if(!visited[i] && arr[now][i] == 1){
                    visited[i] = true;
                    dist[i] = dist[now] + 1;
                    q.offer(i);
                }
            }
        }
    }
}