
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // depth

        arr = new int[M]; //
        visited = new boolean[N]; // 정점 방문 배열
        DFS(0);
        System.out.print(sb);
    }

    public static void DFS(int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]) visited[i] = true;
            if(depth==0){
                arr[depth] = i+1;
                DFS(depth+1);
            }
            if(depth>=1){
                if(i+1>arr[depth-1]){
                    arr[depth] = i+1;
                    DFS(depth+1);
                }
            }
            visited[i] = false;
        }
    }
    
    // 오름차순으로 하기
    //
}
