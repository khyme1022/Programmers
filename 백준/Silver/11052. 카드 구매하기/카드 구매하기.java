import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp;
    public static int[] arr;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dp = new int[N+1];
        arr = new int[N+1];

        dp[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[N]);
    }

}
