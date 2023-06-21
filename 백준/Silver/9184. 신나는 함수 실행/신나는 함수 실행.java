
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int a = 0;
        int b = 0;
        int c =0;
        while(true){
            st = new StringTokenizer(br.readLine());

            a= Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());
            c= Integer.parseInt(st.nextToken());

            if(a==-1&&b==-1&&c==-1){
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(recur(a, b, c)).append("\n");

        }
        System.out.println(sb);
    }

    public static int recur(int a, int b, int c){ // -1 넣으면 outofbound
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
//        else if (a == 0 || b == 0 || c == 0) {
//            dp[a][b][c] = 1;
//            return dp[a][b][c];
//        } // 하나라도 0보다 작을 때

        else if (a > 20 || b > 20 || c > 20) { // 하나라도 20보다 클때
            dp[20][20][20] = recur(20,20,20);
            return dp[20][20][20];

        }else if(dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        else if (a < b && b < c){  // a<b<c를 만족할 때
            dp[a][b][c] = recur(a, b, c-1) + recur(a, b-1, c-1) - recur(a, b-1, c);
            return dp[a][b][c];

        }else{ // a<b<c를 만족하지 않으면
            dp[a][b][c] =recur(a-1, b, c) + recur(a-1, b-1, c) + recur(a-1, b, c-1) - recur(a-1, b-1, c-1);
            return dp[a][b][c];
        }

    }

}
