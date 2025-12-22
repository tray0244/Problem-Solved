import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    // Union-Find: 최상위 부모 찾기
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union-Find: 두 그룹 합치기
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 1. 통나무 정보 저장 (x1, x2, 원래번호)
        int[][] logs = new int[N][3];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 부모 배열 초기화
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            logs[i][0] = Integer.parseInt(st.nextToken()); // x1
            logs[i][1] = Integer.parseInt(st.nextToken()); // x2
            int y = Integer.parseInt(st.nextToken());      // y (사용 안 함)
            logs[i][2] = i + 1; // 원래 번호 (1-indexed)
        }

        // 2. x1(시작점) 기준으로 정렬
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Sweep-line을 이용한 그룹화 (Union)
        int curMaxX = logs[0][1];
        int curId = logs[0][2];

        for (int i = 1; i < N; i++) {
            // 현재 통나무의 시작점이 이전까지의 최대 도달 범위보다 작거나 같다면 연결 가능
            if (logs[i][0] <= curMaxX) {
                union(curId, logs[i][2]);
                // 연결되었으므로 최대 도달 범위 갱신
                curMaxX = Math.max(curMaxX, logs[i][1]);
            } else {
                // 끊겼다면 새로운 기준점 설정
                curMaxX = logs[i][1];
                curId = logs[i][2];
            }
        }

        // 4. 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 두 통나무의 대표 부모가 같다면 연결된 것
            if (find(u) == find(v)) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.print(sb.toString());
    }
}