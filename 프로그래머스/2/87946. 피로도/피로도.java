class Solution {
    static boolean[] visited;
    static int maxCount;

    public void dfs(int k, int[][] dungeons, int count){
        maxCount = Math.max(maxCount, count);
        for (int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;

            if(k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        maxCount = 0;
        dfs(k, dungeons, 0);
        return maxCount;
        }
    }