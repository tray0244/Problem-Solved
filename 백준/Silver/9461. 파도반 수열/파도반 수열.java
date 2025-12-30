import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        int[] A = new int[T];
        int maxN = 0;

        for(int i = 0; i < T; i++)
        {
            A[i] = in.nextInt();
            if(A[i] > maxN)
            {
                maxN = A[i];
            }
        }

        long[] P = new long[Math.max(101, maxN + 1)];
        
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        
        for(int j = 6; j <= maxN; j++)
        {   
            P[j] = P[j - 1] + P[j - 5];
        }
        
       for(int i = 0; i < T; i++)
       {
           System.out.println(P[A[i]]);
       }
    }
}
