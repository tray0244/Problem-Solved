class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] value = new int[3];
        int round = -1;
        
        String[] parts = dartResult.split("");
        for(int i = 0; i < parts.length; i++){
            if(Character.isDigit(parts[i].charAt(0))){
                round++;
                if(parts[i].equals("1") && i + 1 < parts.length && parts[i + 1].equals("0")){
                    value[round] = 10;
                    i++;
                } else {
                    value[round] = Integer.parseInt(parts[i]);
                }
            }
            
            if(parts[i].equals("S")){
                value[round] = (int) Math.pow(value[round], 1);
            }else if(parts[i].equals("D")){
                value[round] = (int) Math.pow(value[round], 2);
            }else if(parts[i].equals("T")){
                value[round] = (int) Math.pow(value[round], 3);
            }
            
            else if (parts[i].equals("*")){
                value[round] *= 2;
                if(round > 0) value[round - 1] *= 2;
            }else if (parts[i].equals("#")){
                value[round] *= -1;
            }
        }
        for(int v : value) answer+= v;
        return answer;
    }
}