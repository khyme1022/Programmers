
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num; // 정점 집합
    static int[] print;  // 출력해야하는 길이 만큼
    static boolean[] visited; // 방문 배열
    static int N; // 정점 개수
    static int M; // 방문할 정점 수
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[N]; // 
        visited = new boolean[N]; 
        print = new int[M];
       
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        DFS(0);
        System.out.println(sb);

    }
    static void DFS(int depth){
        if(depth == M){
            for(int i =0;i<M;i++){
                sb.append(print[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                print[depth] = num[i];
                DFS(depth+1);
                visited[i] = false;
            }
        }


    }
}
// 방문은 제대로 하는데 출력을 못함
// 이미 방문한 위치를 배열에 저장해서 한번에 출력하기
// 전부 연결된 그래프라 point 필요 없음

// 방문보다 if문 먼저 사용하기