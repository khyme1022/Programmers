
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean[] check_list = new boolean[n];

        int input = 0;
        stack.push(0);
        int last_input = 0; // 가장 마지막에 넣은 원소 기억하기

        boolean condition = true;

        for(int i =0;i<n;i++){
            if(condition == false) break; // 불가능한 경우 break

            input = Integer.parseInt(br.readLine()); // 입력 받기

            if(input == stack.peek()){ // 현재 스택 원소와 입력된 원소가 같으면 pop() 해주기
                stack.pop();
                sb.append("-").append("\n");
            }

            else if(input > stack.peek()){ // 입력 받은수가 최근 스택보다 높을 경우 스택 쌓기 실행 후 pop()
                for(int j=last_input+1;j<=input;j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                last_input = stack.peek(); // 마지막 원소 기억
                stack.pop();
                sb.append("-").append("\n");

            }

            else{ // input < stack.peek()일 시 condition을 false로 만들어 탈출
                condition = false;
                break;
            }


        }
        if(condition) System.out.println(sb);
        else System.out.println("NO");
    }
}
