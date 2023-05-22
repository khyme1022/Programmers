import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 시간 제한 1초, 메모리 제한 128MB
public class Main {

    static List<Integer>[] graph;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (정점)
        int M = Integer.parseInt(br.readLine()); // 네트워크로 연결되있는 쌍의 수 (간선)

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        check = new boolean[N+1];

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        System.out.println(BFS(graph,check));

    }

    // start = 1;
    public static int BFS(List<Integer>[] graph, boolean[] check){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int index= 0;
        int node = 0;
        int seq = 0;

        while(!queue.isEmpty()){

            index = queue.remove();
            if(check[index]) continue; // 방문했으면 
            check[index] = true;
            seq++;
            for(int i=0;i<graph[index].size();i++){
                node = graph[index].get(i);
                if(!check[node] ){ // 방문하지 않았으면
                    queue.add(node);
                }
            }
        }
        return seq-1; // 1도 포함된 결과기 때문에 -1 해줘야 함
    }
}
