import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 봉지는 3, 5가 있다.
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;


        while(N>0){
            if(N%5==0){
                result += N/5;
                N=0;
                break;
            }

            else{
                N -= 3;
                result++;
            }

        }
        if(N==0){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
        // 3만 쓰기
        // 5만 쓰기

    }
}
