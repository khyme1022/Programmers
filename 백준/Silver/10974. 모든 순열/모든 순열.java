import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        arr = new int[N];
        recur(0);
        System.out.println(sb);
    }
    static void recur(int depth){
        if(depth == N) {
            for(int i =0;i<N;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i;
                recur(depth+1);
                visit[i] = false;
            }
        }
    }
}


/*
백트래킹 아닌감?

 */