
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//ArrayList<Integer[] 사용하기
public class Main {

    static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken());
        ; // 간선의 수
        int R = Integer.parseInt(st.nextToken());
        ; // 시작 정점

        visited = new int[N + 1]; // 정점 수 +1 만큼 (1~N이라서) 방문 여부 배열
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) { // N+1개의 정점 생성 (0 때문)
            graph[i] = new ArrayList<>();
        } // 0~N 까지 생성

        for (int i = 0; i < M; i++) { // 간선 입력 받는 부분
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            graph[start].add(end);
            graph[end].add(start);
            // 방향이 없는 무방향 간선이기 때문에 양쪽으로 이어준다.
        }
        for(int i=1;i<=N;i++){
            Collections.sort(graph[i],Collections.reverseOrder()); // 오름차순 정렬해주기 BFS는 Queue를 사용하기 때문에 정렬하고자하는 차순과 같게 정렬한다.
        }

        bfs(R,graph);

        for(int i=1;i<=N;i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }


    // 시작 정점을 Queue에 넣는다.
    // 반복문
    // index = queue.remove();
    // index와 접한 정점을 Queue에 넣는다
    // Queue가 빌때까지 반복
    // 반복문

    public static void bfs(int start, ArrayList<Integer>[] graph){
        Queue<Integer> queue = new LinkedList<>();
        int seq = 1;
        queue.add(start);
        int index = 0;
        int node = 0;

        while(!queue.isEmpty()){
            index = queue.remove();
            if(visited[index] !=0) continue;
            visited[index] = seq++;


            for(int i =0;i<graph[index].size();i++){
                node = graph[index].get(i);
                if(visited[node] == 0){ // 연결 되어 있고 아직 방문하지 않은 정점이면 Queue에 집어 넣는다.
                    queue.add(node);
                }
            }

        }



    }
}
