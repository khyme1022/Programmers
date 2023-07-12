import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        int front = 1;
        int back = 1;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.countTokens()==2){
                st.nextToken();
                arr[back++] = Integer.parseInt(st.nextToken()); // 정수를 큐에 넣기
            }
            else{
                switch(st.nextToken()){
                    case "pop": // 큐에 가장 앞에 있는 정수를 빼고 출력 / 없으면 -1
                        if(front == back) sb.append(-1).append("\n");
                        else sb.append(arr[front++]).append("\n");
                        break;
                    case "size": // 큐에 들어있는 정수의 개수 출력
                        sb.append(back-front).append("\n");
                        break;
                    case "empty": // 큐가 비어있으면 1 아니면 0 출력
                        if(front== back) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "front": // 큐의 가장 앞에 있는 정수 출력 / 없으면 -1
                        if(front==back) sb.append(-1).append("\n");
                        else sb.append(arr[front]).append("\n");
                        break;
                    case "back": //큐의 가장 뒤에 있는 정수 출력 / 없으면 -1
                        if(front==back) sb.append(-1).append("\n");
                        else sb.append(arr[back-1]).append("\n");
                        break;

                }
            }
        }
        System.out.println(sb);

    }
}
