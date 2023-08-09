import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] print;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[N];
        print = new int[M];
        visited = new boolean[N];
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        DFS(0,0);
        System.out.print(sb);


    }
    static void DFS(int depth, int before){
        if(depth == M){
            for(int i =0;i<M;i++){
                sb.append(print[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0;i<N;i++){
            if(!visited[i]&&num[i]>before){
                visited[i] = true;
                print[depth] = num[i];
                DFS(depth+1, print[depth]);
                visited[i] = false;
            }
        }

    }
}
