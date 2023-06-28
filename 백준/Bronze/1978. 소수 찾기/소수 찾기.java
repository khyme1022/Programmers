
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[1001];
        int j = 0;
        arr[0] = true;
        arr[1] = true;

        for(int i=2;i<arr.length;i++){
            j=1;
            if(arr[i] == false){// 소수면
                j++;
            }
            while(i*j<1001){
                arr[i*j] = true;
                j++;
            }
        }
        int count = 0 ;
        for(int i=0;i<N;i++){
            if(!arr[Integer.parseInt(st.nextToken())]) // false는 소수 false면 count++
                count++;
        }
        System.out.println(count);


    }
}
