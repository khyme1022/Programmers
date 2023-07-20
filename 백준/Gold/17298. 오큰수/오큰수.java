import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){ // stack이 비어있다면 현재 인덱스를 stack에 넣어주기
                stack.push(i);
            }
            else{ // stack이 비어 있지 않다면 비교하기
                while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){ // 비교해서 현재 원소가 더 크면
                    arr[stack.peek()] = arr[i];
                    stack.pop();
                }
                stack.push(i);
            }

        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        for(int i=0;i<N;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);


    }
    // 원소 추가

    // -1이 없는
}
