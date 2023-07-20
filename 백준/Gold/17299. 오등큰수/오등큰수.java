import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] time = new int[1000001];

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            time[arr[i]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            if(!stack.isEmpty()){ // stack이 비어있지 않으면
                while(!stack.isEmpty()&&time[arr[stack.peek()]]<time[arr[i]]){ // time 배열 비교하기
                    arr[stack.pop()] = arr[i]; 
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        for(int i=0;i<N;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
    
    // F(a1) = a1이 수열에서 등장한 횟수
    // NGF(a1) = F(a1) < F(N)인 오른쪽에서 가장 가까운 수
    // 방법 1. 수열의 수를 전부 F(a1)로 바꾼다음 오큰수 구하기
}
