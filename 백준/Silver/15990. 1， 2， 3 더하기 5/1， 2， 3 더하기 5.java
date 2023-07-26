import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];

        final int div = 1000000009;

        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        int[] arr = new int[T];
        int max = 0;
        for(int i =0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            max = Math.max(n,max);
            arr[i] = n;
        }
        for(int i=4;i<=max;i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % div;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % div;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % div;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append((dp[arr[i]][1]+dp[arr[i]][2]+dp[arr[i]][3])%div).append("\n");
        }

        System.out.println(sb);
    }

}
// 1 - 1
// 2 - 2u
//
// 1로 끝난 놈 2로 끝난 놈 3으로 끝난 놈 따로 계산해서 더하기
// 