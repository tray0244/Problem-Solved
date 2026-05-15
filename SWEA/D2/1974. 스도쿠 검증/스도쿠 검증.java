import java.util.*;
import java.io.*;
class Solution{
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] map = new int[9][9];

        for(int t = 1; t <= T; t++){
            StringTokenizer st;
            for(int r = 0; r < 9; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < 9; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(t).append(" ");

            boolean allValid = true;

            // 가로 검사
            for(int r = 0; r < 9; r++){
                visited = new boolean[10];
                boolean valid = true;
                for(int c = 0; c < 9; c++){
                    if(visited[map[r][c]]){ 
                        valid = false; 
                        break; 
                    }
                    visited[map[r][c]] = true;
                }
                if(!valid) allValid = false;
            }

            // 세로 검사
            for(int c = 0; c < 9; c++){
                visited = new boolean[10];
                boolean valid = true;
                for(int r = 0; r < 9; r++){
                    if(visited[map[r][c]]){ 
                        valid = false;
                        break; 
                    }
                    visited[map[r][c]] = true;
                }
                if(!valid) allValid = false;
            }

            // 박스 검사
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    visited = new boolean[10];
                    boolean valid = true;
                    for(int r = i*3; r < i*3+3; r++){
                        for(int c = j*3; c < j*3+3; c++){
                            if(visited[map[r][c]]){ 
                                valid = false; 
                                break; 
                            }
                            visited[map[r][c]] = true;
                        }
                        if(!valid) break;
                    }
                    if(!valid) allValid = false;
                }
            }

            sb.append(allValid ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}