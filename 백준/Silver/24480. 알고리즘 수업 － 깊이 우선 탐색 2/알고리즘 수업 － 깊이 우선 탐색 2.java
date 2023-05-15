
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/24479
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken());; // 간선의 수
        int R = Integer.parseInt(st.nextToken());; // 시작 정점

        int visited[] = new int[N+1]; // 정점 수 +1 만큼 (1~N이라서) 방문 여부 배열

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=N;i++){ // N+1개의 정점 생성 (0 때문)
            graph.add(new ArrayList<>());
        } // 0~N 까지 생성

        for(int i=0;i<M;i++){ // 간선 입력 받는 부분
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
            // 방향이 없는 무방향 간선이기 때문에 양쪽으로 이어준다.
        }

        for(int i=1;i<=N;i++){
            Collections.sort(graph.get(i)); // 오름차순 정렬 -> 내림차순으로 빼야하기 떄문
        }
        dfs(R,visited,graph);

        for(int i=1;i<=N;i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }

    // 시작 정점을 stack에 넣는다
    // index = stack.pop()
    // index와 인접한 정점 중 방문하지 않은 정점을 모두 stack 에 넣는다
    // 반복
    public static void dfs(int start,int visited[],ArrayList<ArrayList<Integer>> graph){
        Stack<Integer> stack = new Stack<>();
        int seq = 1;
        stack.push(start);
        int index = start;

        while(!stack.isEmpty()){
            index = stack.pop(); // 주변 원소 탐색을 위해
            if(visited[index] !=0) continue; // 이미 방문한 원소면 처음으로

            visited[index] = seq++;
            for(int i=0;i<graph.get(index).size();i++){
                if(visited[graph.get(index).get(i)]==0)
                    stack.push(graph.get(index).get(i));
            }

        }


    }
}