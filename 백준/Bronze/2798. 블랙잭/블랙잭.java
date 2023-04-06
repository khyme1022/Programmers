
import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        int result = 0;

        /*
        모든 합을 구하고 그중 M과 가장 가까운 값을 구한다.
        M과의 차가 적으면 result
        500
        400 // +100
        600 // -100
         */
        for(int i=0; i<N-2;i++){ // 0 1 2
            for(int j=i+1; j<N-1;j++){ // 1 2 3
                for(int k=j+1; k<N;k++){ // 2 3 4
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum > result&& sum<M){
                        result = sum;
                    }
                    if(sum == M){
                        result = sum;

                        break;
                    }

                }
            }
        }
        System.out.println(result);

    }
}