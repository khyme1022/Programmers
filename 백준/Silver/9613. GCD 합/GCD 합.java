
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i =0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long result = 0L;
            for(int j=0;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++){
                    result += GCD(arr[j],arr[k]);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    public static int GCD(int a, int b){
        int temp = Math.min(a,b);
        a = Math.max(a,b);
        b = temp;
        while(b!=0){
            temp = a%b;
            a = b;
            b = temp;

        }

        return a;
    }
}
