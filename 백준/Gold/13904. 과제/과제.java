import java.io.*;
import java.util.*;

class Report{
    int d, w;
    Report(int d, int w){
        this.d = d;
        this.w = w;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Report[] arr = new Report[N];
        int maxDay = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Report(d, w);
            maxDay = Math.max(maxDay, d);
        }

        Arrays.sort(arr, (a, b) -> b.d - a.d); // 마감일 내림차순

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int score = 0;
        int idx = 0;
        for(int day = maxDay; day >= 1; day--){
            while(idx < N && arr[idx].d >= day){
                pq.add(arr[idx].w);
                idx++;
            }
            if(!pq.isEmpty()){
                score += pq.poll();
            }
        }

        System.out.println(score);
    }
}