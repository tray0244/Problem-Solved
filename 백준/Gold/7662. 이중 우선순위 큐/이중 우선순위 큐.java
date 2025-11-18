import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            
            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String token = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(token.equals("I")){
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }else if(token.equals("D")){
                    if(map.isEmpty()) continue;
                    
                    if(n == 1){
                        int maxKey = map.lastKey();
                        if(map.get(maxKey) == 1){
                            map.remove(maxKey);
                        }else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    }else{
                        int minKey = map.firstKey();
                        if(map.get(minKey) == 1){
                            map.remove(minKey);
                        }else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }
            if(!map.isEmpty()){
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }else {
                sb.append("EMPTY\n");
            }
        }        
        System.out.print(sb);
    }
}