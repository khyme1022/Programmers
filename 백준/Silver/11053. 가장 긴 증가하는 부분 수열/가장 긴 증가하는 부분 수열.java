
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1초, 1~1000 최대 N^2
public class Main {
    static int[] A; // 수열 A
    static int[] DP; // 최장부분수열 시작 요소 저장 배열

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        DP = new int[N+1];
        DP[0] = 0;

        int max = 0;

        for(int i =0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(DP[max]<A[i]){
                DP[++max] = A[i];

            }else{
                for(int j=max;j>=0;j--){ // A[i]의 위치 찾기
                    if(DP[j]<A[i]){ // 위치를 찾음
                        DP[j+1] = A[i];
                        break;
                    }
                    else if(DP[j] == A[i]){
                        break;
                    }
                }
            }

        }
        System.out.println(max);


    }
}

