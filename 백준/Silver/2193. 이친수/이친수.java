import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2초
// N<100 O(N^4)도 가능?
public class Main {
    static Long[][] DP = new Long[91][2];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DP[0][0] = DP[0][1] = 0L;
        DP[1][0] = 0L;
        DP[1][1] = 1L;
        if(N>1)
            recur(N);
        System.out.print(DP[N][0] + DP[N][1]);

    }

    static void recur(int N){
        int result = 0;
        if (DP[N-1][0] != null && DP[N-1][1] != null) {
            DP[N][0] = DP[N-1][0] + DP[N-1][1];
            DP[N][1] = DP[N-1][0];
        }else{
            recur(N-1);
            DP[N][0] = DP[N-1][0] + DP[N-1][1];
            DP[N][1] = DP[N-1][0];
        }

    }
}

// 1 1
// 2 10 - 앞이 1이니까 0 붙히기
// 3 101 100 - 앞이 0이니까 0,1 붙히기
// 4 1010 1000 1001 - 101은 앞이 1이라 0 붙히기, 100 이니까 0,1 붙히기
// 5
// 1로 끝나면 0 무조건
// 0으로 끝나면 0,1 을 붙힐 수 있다

// 0, 1을 체크
// 이전단계에서 0으로 끝난 수에는 0,1을 붙힐수 있으니까 *2 1로 끝나면 0만가능하니까 그냥 더하기
//
// 이때 DP[N][0]의 뜻은 N자리 이친수 중 0으로 끝난 이친수를 뜻함

// DP[N][0]을 구하는 방법 = DP[N-1][0] + DP[N-1][1] - 0은 0과 1 뒤에 모두 붙힐 수 있다.
// DP[N][1]을 구하는 방법 = DP[N-1][0] - 1로 끝나면 1을 붙힐 수 없기 때문

// 1 - 0 1
// 2 = 1 0
// 3 = 1 1
// 4 = 2 1
// 5 = 3 2
// 6 = 5 3
// 7 = 8 5