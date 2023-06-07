
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 제한 2초
// 메모리 제한 128MB
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Boolean[][] board = new Boolean[N][M]; // 0~N / 0~M
        String s = "";

        for(int i=0;i<N;i++){
            s = br.readLine();
            for(int j=0;j<M;j++){
                if(s.charAt(j)=='W')    board[i][j] = true; // 백색이 true 흑색은 false
                else board[i][j] = false;

            }
        }

        int min = 50*50;
        // i와 j의 합이 짝수 홀수
        for(int i =0;i<N-7;i++){ // 카운트 두개 하기 백색 스타트, 흑색 스타트
            for(int j=0;j<M-7;j++){

                boolean w_start = true;
                boolean b_start = false;
                int w_count = 0;
                int b_count = 0;

                for(int k=i;k<i+8;k++){
                    for(int l=j;l<j+8;l++){
                        if(board[k][l] != w_start){
                            w_count++;
                        }
                        if(board[k][l] != b_start){
                            b_count++;
                        }
                        w_start = !w_start;
                        b_start = !b_start;
                    }
                    w_start = !w_start;
                    b_start = !b_start; // wbwbwbwb를 하고 다음칸에선 bwbw하기 때문에 다시한번 바꿔줌
                }
                min = Math.min(min,Math.min(w_count,b_count));
            }
        }

        System.out.println(min);



    }
}
