import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    /*
    u, v: 간선이 연결하는 두 정점
    w: 간선의 가중치
    Comparable을 구현해서 간선을 가중치 오름차순 정렬할 수 있도록 만듬
    크루스칼 알고리즘은 가중치가 작은 간선부터 탐색해야 하므로 정렬이 필수
     */
    int u, v, w;
    Edge(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
    public int compareTo(Edge other){
        return this.w - other.w;
    }
}
public class Main{
    static int[] partent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        Collections.sort(edges);

        partent = new int[V + 1];
        for (int i = 1; i <= V ; i++) partent[i] = i;

        int result = 0;
        for (Edge e : edges){
            if(find(e.u) != find(e.v)){
                union(e.u, e.v);
                result += e.w;
            }
        }

        System.out.println(result);
    }

    // 이 아래부터는 유니온 파인드 연산
    /*
    find(x): x의 루트 노드를 재귀적으로 찾아간다. (경로 압축으로 효율화)
    union(a, b): 두 집합의 루트를 합한다.
    Union Find를 사용해 사이클 여부를 빠르게 판별이 가능하다.
     */
    static int find(int x){
        if(partent[x] != x) partent[x] = find(partent[x]);
        return partent[x];
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) partent[b] = a;
    }
}