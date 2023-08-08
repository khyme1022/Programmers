import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static char[][] graph;

    static int N;
    static int max;
    public static void main(String args[])  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 줄수
        graph = new char[N][N];

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            graph[i] = s.toCharArray();
        } // 표에 넣기

        max = 1;

        check(0,N-1,0,N-1);
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                if(j+1<N){
                    swap(i,j,i,j+1);
                    check(i,j,i,j+1);
                    swap(i,j,i,j+1);
                }
                if(i+1<N){
                    swap(i,j,i+1,j);
                    check(i,j,i+1,j);
                    swap(i,j,i+1,j);
                }
            }
        }

        System.out.println(max);

    }
    static void swap(int a, int b, int x, int y){ // 교환 함수
        char temp;
        temp = graph[a][b];
        graph[a][b] = graph[x][y];
        graph[x][y] = temp;


    }

    static void check(int a, int b, int x, int y){ // 확인하는 함수
        int result = 1;
        for(int i=a;i<=x;i++){ // 수직
            result = 1;
            for(int j=0;j<N-1;j++){

                if(graph[i][j]==graph[i][j+1]){
                    result++;
                }
                else result = 1;
                max = Math.max(max, result);
            }
        }
        for(int j =b;j<=y;j++){ // 수평 검사
            result = 1;
            for(int i=0;i<N-1;i++){

                if(graph[i][j]==graph[i+1][j]) {
                    result++;
                }
                else result = 1;
                max = Math.max(max, result);

            }
        }
    }
}

// 최장 길이 기록
// 교체전에 행과 열을 한번 씩 체크한다
// 상하 교체 시 해당 열과 교체된 각각 행 체크
// 좌우 교체 시 해당 행과 교체된 각각 열 체크
// 오른쪽 막힐 때
// 아래 막힐 때




// 상하 교체 시 - 교체한 행의 가로 최장 체크.
// 좌우 교체 시 - 교체한 열의 세로 최장 체크.