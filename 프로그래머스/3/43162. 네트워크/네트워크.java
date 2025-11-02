class Solution {
    private boolean[] visited;
    private int[][] computers;
    private int n;

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];

        int networkCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                networkCount++;
            }
        }
        return networkCount;
    }

    private void dfs(int current) {
        visited[current] = true;
        for (int next = 0; next < n; next++) {
            if (!visited[next] && computers[current][next] == 1) {
                dfs(next);
            }
        }
    }
}