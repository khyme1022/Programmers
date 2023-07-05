import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = 9;
        int[] arr = new int[N];
        int sum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int a = 0;
        int b = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(sum - (arr[i]+arr[j])==100){
                    a = i;
                    b = j;
                    sum = 100;
                    break;
                }
            }
            if(sum == 100) break;
        }

        for(int k =0;k<N;k++){
            if(k==a || k==b) continue;
            sb.append(arr[k]).append("\n");
        }
        System.out.println(sb);
    }
}
