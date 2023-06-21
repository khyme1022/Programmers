import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2초 128MB
public class Main {

    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] D_visited;
    public static boolean[] B_visited;

    public static int X;
    public static int Y;
    public static int N;

    public static StringBuilder sb = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            StringTokenizer stM = new StringTokenizer(br.readLine());

            X = Integer.parseInt(stM.nextToken());
            Y = Integer.parseInt(stM.nextToken());
            for(int j=0;j<X;j++){

            }
            graph.get(X).add(Y);
            graph.get(Y).add(X);
        }
        // 두 정점 사이 여러 개의 간선이 있을 수 있다
        // 간선이 여러개여서 바뀌는 점을 찾아야할 듯
        // 딱히 없는 거 같다. 어차피 왔다갔다는 똑같음 하지만 graph.get(X).size()는 바뀜
        for(int i =0;i<=N;i++){
            Collections.sort(graph.get(i));
        } // 작은 것 먼저 방문하기 때문에 정렬해주기

        D_visited = new boolean[N+1];
        B_visited = new boolean[N+1];

        DFS(V);
        System.out.println(sb);
        BFS2(V);
        System.out.println(sb2);
    }

    public static void DFS(int index){
        if(!D_visited[index]){
            D_visited[index] = true;
            sb.append(index).append(" ");
        }
        for(int i =0;i<graph.get(index).size();i++){
            if(!D_visited[graph.get(index).get(i)]){
                DFS(graph.get(index).get(i));
            }
        }
    }

    public static void BFS(int point){
        Queue<Integer> queue = new LinkedList<>();
        int index = point;
        queue.add(point);
        B_visited[index] = true;
        while(!queue.isEmpty()){
            index = queue.remove();
            sb2.append(index).append(" ");
            for(int i =0;i<graph.get(index).size();i++){
                if(!B_visited[graph.get(index).get(i)]){
                    queue.add(graph.get(index).get(i));
                    B_visited[graph.get(index).get(i)] = true;
                }
            }
        }
    }

    public static void BFS2(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(point);
        int index = 0;
        int node = 0;

        while (!queue.isEmpty()) {

            index = queue.remove();
            if (B_visited[index]) continue; // 방문했으면
            B_visited[index] = true;
            sb2.append(index).append(" ");
            for (int i = 0; i < graph.get(index).size(); i++) {
                node = graph.get(index).get(i);
                if (!B_visited[node]) { // 방문하지 않았으면
                    queue.add(node);
                }
            }
        }
    }
}

// 1
// 2
// 3
// 4