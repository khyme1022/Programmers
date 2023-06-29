import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[M+1];
        int j = 0;
        arr[0] = true;
        arr[1] = true;

        for(int i=2;i<arr.length;i++){
            j=1;
            if(arr[i] == false){// 소수면
                j++;
            }
            while(i*j<arr.length){
                arr[i*j] = true;
                j++;
            }
        }
        int count = 0 ;


        for(int i =N;i<arr.length; i++ ){
            if(arr[i] == false)
                sb.append(i).append("\n");
        }
        System.out.println(sb);

    }
}
