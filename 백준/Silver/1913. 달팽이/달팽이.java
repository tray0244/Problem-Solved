import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] arr;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int x = 0, y = 0;
        int dir = 0;
        int num = N * N;
        int targetX = 0, targetY = 0;

        while(num > 0){
            arr[x][y] = num;
            if(num == M){
                targetX = x + 1;
                targetY = y + 1;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0){
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
            num--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(' ').append(targetY);
        System.out.println(sb);
    }
}