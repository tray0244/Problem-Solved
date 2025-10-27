import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int ans = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
                
                checkT(i, j);
            }
        }
        System.out.println(ans);
    }
    
    private static void dfs(int x, int y, int sum, int depth){
        if(depth == 4){
            ans = Math.max(ans, sum);
            return;
        }
        
        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny, sum + arr[nx][ny], depth + 1);
            visited[nx][ny] = false;
        }        
    }
    private static void checkT(int x, int y){
        int center = arr[x][y];
        int wings = 0;
        int minWing = Integer.MAX_VALUE;
        
        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            wings++;
            minWing = Math.min(minWing, arr[nx][ny]);
            center += arr[nx][ny];
        }
        if(wings >= 3){
            if(wings == 4){
                ans = Math.max(ans, center - minWing);
            }else {
                ans = Math.max(ans, center);
            }
        }
    }
}