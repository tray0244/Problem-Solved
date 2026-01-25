class Solution {
    public int solution(String arr[]) {
        int nums = arr.length / 2 + 1;
        
        int[][] max = new int[nums][nums];
        int[][] min = new int[nums][nums];
        
        for(int i = 0; i < nums; i++){
            int num = Integer.parseInt(arr[i * 2]);
            max[i][i] = num;
            min[i][i] = num;
        }
        
        for(int i = 1; i < nums; i++){
            for(int j = 0; j < nums - i; j++){
                int end = j + i;
                max[j][end] = Integer.MIN_VALUE;
                min[j][end] = Integer.MAX_VALUE;
                
                for(int k = j; k < end; k++){
                    String op = arr[k * 2 + 1];
                    
                    if(op.equals("+")){
                        max[j][end] = Math.max(max[j][end], max[j][k] + max[k + 1][end]);
                        min[j][end] = Math.min(min[j][end], min[j][k] + min[k + 1][end]);
                        
                    }else if(op.equals("-")){
                        max[j][end] = Math.max(max[j][end], max[j][k] - min[k + 1][end]);
                        min[j][end] = Math.min(min[j][end], min[j][k] - max[k + 1][end]);
                    }
                }
            }
        }
        return max[0][nums - 1];
    }
}