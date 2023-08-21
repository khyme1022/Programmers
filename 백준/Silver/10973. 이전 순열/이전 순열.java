
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        boolean DP[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        int temp = 0;
        for(int i=N;i>0;i--){
            if(i==1){
                sb.append("-1");
                break;
            }
            if(arr[i-1]>arr[i]){ // 오름차순 끝
                for(int j=i;j<=N;j++){
                    if(arr[i-1]>arr[j])
                        max = j;
                    if(arr[i-1]<arr[j]){
                        break;
                    }
                }
                temp = arr[i-1];
                arr[i-1] = arr[max];
                arr[max] = temp;
                for(int j=1;j<=i-1;j++){ // 앞부분은 정순으로 추가하기
                    sb.append(arr[j]).append(" ");
                }
                for(int j=N;j>=i;j--){ // 뒷부분은 역순으로 추가
                    sb.append(arr[j]).append(" ");
                }
                break;
            }
        }
        System.out.println(sb);
    }
}

/*
    이전 문제랑 비슷하다
    그냥 반대로 구현하면 되는 문제
    1. 오름차순 부분을 찾기
    2. i-1과 보다 작은 제일 큰수 찾기
    3. 교환
    4. i부터 N부분 뒤집어서 출력하기
    4 5 3 2 1
    5 1 2 3 4
    
    5 3 2 1 4
    5 3 1 4 2
 */