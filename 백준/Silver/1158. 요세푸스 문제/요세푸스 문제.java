
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=N;i++){
            queue.add(i);
        }
        sb.append("<");
        boolean yn = false;
        while(!queue.isEmpty()){ // 큐가 비어있지 않을 때까지
            if(yn) sb.append(", ");
            for(int i=0;i<K-1;i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            yn = true;
        }
        sb.append(">");
        System.out.println(sb);
    }
}
