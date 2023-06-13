
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 제한 2초, 메모리 제한 128MB
public class Main {
    static final int INDEX = 4;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())-1; // 입력 받는 수 N번째 종말의 수 0부터 세기 때문에 -1

        int[] F = new int[INDEX];
        int[] special = new int[INDEX];
        int[] cnt = new int[INDEX];

        for(int i=0;i<INDEX;i++){ // 건너뛰기 수를 구해서 저장하는 DP
            F[i] = cal(i+1);
            special[i] = F[i] + (int)Math.pow(10,i)*9;
            cnt[i] = 0;
        }


        int idx = INDEX - 1; // 배열 index로 0부터 시작해서 -1 해주기
        int max = 0;

        while(N>0&&idx>=0){ // N이 0이되거나 idx가 음수가 되면 종료
            if(cnt[idx]!=6&&N >= F[idx]){ // 6번째 건너뛰기가 아니고 N에서
                N -= F[idx];
                cnt[idx]++;
            }else if(cnt[idx]==6){
                if(max!=0){
                    if(N>=max){
                        N-=max;
                        cnt[idx]++;
                    }
                    else{
                        idx--;
                    }
                }
                else{
                    if(N>= special[idx]){
                        N-=special[idx];
                        cnt[idx]++;
                    }else{
                        max = Math.max(max,(int)Math.pow(10,idx+1));
                        idx--;
                    }
                }

            }else{
                idx--;

            }
        }
        int result = 0;
        int K = 0;

        for(int i =0;i<INDEX;i++){ // 연속되는 6개수 구하기 
            if(cnt[i]==6){
                K++;
            }else{
                break;
            }
        }
        // 범위가 크다면 변수를 하나 더 만들어서 앞에서도 666이 나오는 지 세주어야함
        // 지금은 끽해야 7자리라서 그렇게 안했다
        for(int i =0; i<3-K;i++){ // 연속되지 않는 만큼 뒤에 추가
            result += 6*(int)Math.pow(10,2-i);
        }

        for(int i =0;i<INDEX;i++){
            result += cnt[i] * (int)Math.pow(10,i+3);
        }
        System.out.println(result+N);

    }

    static int cal(int n){
        int temp = 0;
        for(int i =1;i<n;i++){
            temp += cal(i);
        }
        temp = temp * 9 + (int)Math.pow(10,n-1);
        return temp;
    }
    // 10^0
    // 1 1 1 1 1 10^1 1 1 1                   <- 666, 1666, ... , 6660~6669,...9666 총 19
    // 19 * 6       + 1*6           + 10^2      + 1*3       +   19 * 3     <- 666, 1666, ... , ,...99666 총 280
    // 666~59666  60666~+65666  66600~66699     67666~69666 + 70666~99666

    // 4자리 수에서 5자리 수로 갈 때마다 규칙적으로 증가한다.
    // 증가하는 만큼
}


