import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        boolean DP[] = new boolean[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        int min = 0; //
        StringBuilder sb = new StringBuilder();

        for(int i=N;i>0;i--){
            if(i==1){
                sb.append("-1");
                break;
            }
            // [i-1] [i]
            // 2 1 4 3
            // i = 3일때 arr[2] = 1 / arr[3] = 4

            if(arr[i-1]<arr[i]){ // 내림차순이 끊어졌을때
                for(int j=i;j<=N;j++){
                    if(arr[i-1]<arr[j]){
                        min = j;
                    } // arr[i-1]보다 큰수중에 가장 작은수를 찾아야함
                    if(arr[i-1]>arr[j]){ // arr[i-1]이 arr[j] 보다 크다면 저장된 min 인덱스와 교환하기
                        break;
                    }
                }
                temp = arr[i-1];
                arr[i-1] = arr[min];
                arr[min] = temp;
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
생각정리
- 뒤에서부터 내림차순인 부분을 찾기
- 내림차순인 부분을 찾았다면 i-1번째 수와 내림차순 수중 가장 작은 i-1번째수보다 큰 수의 자리를 바꾼다.
- i~N의 자리를 오름차순으로 교환한다.
- 만약 내림차순의 길이가 전체 배열과 같다면 -1을 출력한다.
최장 감소 수열 비슷?
 */