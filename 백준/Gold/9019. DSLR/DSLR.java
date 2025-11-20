import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static boolean[] visited;
    static int A, B;
    static String[] path;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            char[] dx = {'D', 'S', 'L', 'R'};
            
            path = new String[10000];
            visited = new boolean[10000];
            q.offer(A);
            visited[A] = true;
            path[A] = "";

            int next = 0;
            while(!q.isEmpty()){
                int current = q.poll();
                if(current == B){
                    System.out.println(path[B]);
                    break;
                }

                for(int j = 0; j < 4; j++){
                    switch(j){
                        case 0:
                            next = (current * 2) % 10000;
                            break;
                        case 1:
                            next = current == 0 ? 9999 : current - 1;
                            break;
                        case 2:
                            next = (current % 1000) * 10 + (current / 1000);
                            break;
                        case 3:
                            next = (current % 10) * 1000 + (current / 10);
                    }

                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                        path[next] = path[current] + dx[j];
                    }
                }
            }
        }
    }
}