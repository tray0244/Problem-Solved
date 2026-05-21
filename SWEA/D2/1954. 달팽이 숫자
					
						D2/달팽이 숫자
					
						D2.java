import java.util.*;
import java.io.*;

class Solution{
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int x = 0, y = 0, dis = 0;
            int count = 1;

            while(count <= N * N){
                map[x][y] = count++;

                int nx = x + dx[dis];
                int ny = y + dy[dis];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0){
                    dis = (dis + 1) % 4;
                    nx = x + dx[dis];
                    ny = y + dy[dis];
                }
                x = nx;
                y = ny;
            }
            sb.append("#").append(t).append("\n");
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    sb.append(map[r][c]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}