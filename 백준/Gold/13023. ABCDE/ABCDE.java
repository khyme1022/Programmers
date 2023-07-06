
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int V; // vertex
    public static int E; // edge
    public static int depth;
    public static boolean[] visit;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean chk;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 사람 수
        E = Integer.parseInt(st.nextToken()); // 관계 수

        visit = new boolean[V];
        graph = new ArrayList<>();

        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i =0;i<V;i++){
            DFS(i,0);
            visit = new boolean[V];
            if(chk) break;
        }
        if(chk) System.out.println(1);
        else System.out.println(0);

    }

    public static void DFS(int point,int depth){
        if(chk) return;
        
        if(depth==4){
            chk = true;
            return;
        }
        visit[point] = true;

        for(int i =0;i<graph.get(point).size();i++){
            if(!visit[graph.get(point).get(i)]){
                DFS(graph.get(point).get(i),depth+1);
                visit[graph.get(point).get(i)] = false;
            }

        }
    }

}

// DFS 돌려서 깊이가 4