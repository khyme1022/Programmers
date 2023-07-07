import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken()); // 정점
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        visit = new boolean[V+1]; // 방문 배열 생성
        graph = new ArrayList<>(); // 객체 생성
                
        for(int i =0;i<=V;i++){ // 정점 배열리스트 내 배열리스트 생성
            graph.add(new ArrayList<>());
        }

        for(int i =0;i<E;i++){ // 간선 연결하기
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = 0;

        for(int i=1;i<=V;i++){
            if(!visit[i]) { // 해당 정점 미 방문 시 DFS 실행
                result++;
                DFS(i);
            }else{ // 방문했을 시 패스
                continue;
            }
        }
        System.out.println(result);
    }

    public static void DFS(int point){
        if(visit[point]) return;
        visit[point] = true;

        for(int i=0;i<graph.get(point).size();i++){
            if(!visit[graph.get(point).get(i)])
                DFS(graph.get(point).get(i));
        }
    }

}
// 연결 요소 : 연결된 하나의 덩어리 123 / 45 이렇게 연결되어 있으면 연결요소는 2개
// 정점마다 DFS or BFS를 실행
// 방문 체크가 된 정점에는 실행하지 않음