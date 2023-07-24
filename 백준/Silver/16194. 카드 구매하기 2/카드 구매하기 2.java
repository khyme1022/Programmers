
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N+1];
        int[] price = new int[N+1];
        dp[0] = 0;
        for(int i =1;i<=N;i++){
            price[i] = Integer.parseInt(st.nextToken());
            dp[i] = 10001;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j]+price[j]);

            }
        }

        System.out.println(dp[N]);
    }
}

// 최소비용으로 카드팩 N개를 구매하는 방법

