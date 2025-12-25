import java.util.*;
import java.io.*;

// 백준 2178반 미로 탐색
// https://www.acmicpc.net/problem/2178
public class Main {
    // Node 클래스는 BFS에서 사용할 노드를 정의합니다.
    static class Node {
        int x, y, distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static final int[] dx = {0, 0, -1, 1}; // 상하좌우
    static final int[] dy = {-1, 1, 0, 0}; // 상하좌우

    // BFS를 사용하여 최단 경로를 찾는 함수
    static int bfs(int[][] maze, int N, int M){
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();

        // 시작점 (0, 0)에서 BFS 시작
        // offer에 왜 new를 쓸까? // Node 객체를 생성하여 큐에 추가합니다.
        // 그렇게 큐에 들어가는 값은 q.peak() = (0, 0, 1) // 시작점의 거리는 1로 설정
        queue.offer(new Node(0, 0, 1)); // 시작점의 거리는 1로 설정
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 도착점에 도달했을 때
            if (current.x == N - 1 && current.y == M - 1) {
                return current.distance;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 체크 및 벽이 아닌지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, current.distance + 1));
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자열을 정수로 변환
            }
        }

        int result = bfs(maze, N, M);
        System.out.println(result);
    }
}