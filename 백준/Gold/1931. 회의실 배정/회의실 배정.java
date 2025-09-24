import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            list.add(new int[]{I, J});
        }
        list.sort((a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<int[]> q = new LinkedList<>(list);

        int[] first = q.poll();
        int s = first[0];
        int e = first[1];
        int count = 1;

        while(!q.isEmpty()){
            int[] room = q.poll();
            int start = room[0];
            int end = room[1];

            if(e <= start){
                count++;
                e = end;
            }
        }
        System.out.println(count);
    }
}