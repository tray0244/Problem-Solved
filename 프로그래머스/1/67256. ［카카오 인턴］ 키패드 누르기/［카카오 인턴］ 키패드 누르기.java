class Solution {
    static class Finger{
        int row, col;
        
        Finger(int row, int col){
            this.row = row;
            this.col = col;
        }
        
        void move(int r, int c){
            this.row = r;
            this.col = c;
        }
        
        int dist(int r, int c){
            return Math.abs(this.row - r) + Math.abs(this.col - c);
        }
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Finger left = new Finger(3, 0);
        Finger right = new Finger(3, 2);
        
        for(int n : numbers){
            int[] pos = getPos(n);
            int r = pos[0];
            int c = pos[1];
            
            if(c == 0){
                sb.append("L");
                left.move(r, c);
            }else if(c == 2){
                sb.append("R");
                right.move(r, c);
            }else{
                int lDist = left.dist(r, c);
                int rDist = right.dist(r, c);
                
                if(lDist < rDist){
                    sb.append("L");
                    left.move(r, c);
                }else if(lDist > rDist){
                    sb.append("R");
                    right.move(r, c);
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right.move(r, c);
                    }else{
                        sb.append("L");
                        left.move(r, c);
                    }
                }
            }
        }
        return sb.toString();
    }
    private int[] getPos(int n){
        if(n == 0) return new int[] {3, 1};
        return new int[] {(n - 1) / 3, (n - 1) % 3};
    }
}