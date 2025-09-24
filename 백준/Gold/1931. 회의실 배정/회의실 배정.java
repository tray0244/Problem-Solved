import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Room implements Comparable<Room>{
    int stime;
    int etime;
    public Room(int stime, int etime){
        super();
        this.stime = stime;
        this.etime = etime;
    }
    @Override
    public int compareTo(Room o){
        // 종료 타임을 기준으로 오름 차순 정렬
        int time = etime - o.etime;
        // 종료 타임이 동일한 경우 시작 타입으로 오름 차순 정렬
        if(time == 0){
            time = stime - o.etime;
        }
        return time;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받고
        int N = Integer.parseInt(br.readLine());
        ArrayList<Room> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Room(Integer.parseInt(st.nextToken()),
                              Integer.parseInt(st.nextToken())));
        }

        // 종료 타임을 기준으로 오름 차순으로 정렬
        Collections.sort(list);

        // 가장 빨리 끝나는 첫 회의를 시작 시켜준다. ==> endTime
        int endTime = list.get(0).etime;
        int cnt = 1;

        // 전체 회의를 반복 돌면서
        for (int i = 1, size = list.size(); i < size; i++) {
            // 회의 가능한지 비교 - 이전 회의의 종료 시간과 다음 회의 시작시간을 비교
            if(endTime <= list.get(i).stime){
                // 카운트 증가
                cnt++;
                // endTime 갱신
                endTime = list.get(i).etime;
            }
        }
        System.out.println(cnt);
    }
}
