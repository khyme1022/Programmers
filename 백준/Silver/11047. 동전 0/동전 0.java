import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 입력받을 동전의 개수 
        int K = Integer.parseInt(st.nextToken()); // 목표 금액

        int result = 0;

        int[] arr = new int[N];
        // 배열에 오름차순으로 사용가능한 돈 배열로 저장
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int j = N-1;
        while(K>0){
            if(K>=arr[j]){
                K -= arr[j];
                result++;
            }
            else {
                j--;
            }

        }
        System.out.println(result);
    }
}
