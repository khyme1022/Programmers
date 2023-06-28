
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 대문자 입력 개수
        double[] temp = new double[N]; // 대문자와 상응하는 값 보관 배열

        String s = br.readLine(); // 표기식

        for(int i=0;i<N;i++){
            temp[i] = Double.parseDouble(br.readLine());
        }

        char[] s_Array = s.toCharArray(); // 표기식 변환
        Stack<Double> stack = new Stack<>(); // 후위 표기식 표현에 사용할 스택
        

        double result = 0.00;
        double a = 0;
        double b = 0;
        for(int i=0;i<s_Array.length;i++){

            switch(s_Array[i]){
                case '+':
                    a = stack.pop();
                    b = stack.pop();
                    result = b+a;
                    stack.push(result);
                    break;
                case '-':
                    a = stack.pop();
                    b = stack.pop();
                    result = b-a;
                    stack.push(result);
                    break;
                case '*':
                    a = stack.pop();
                    b = stack.pop();
                    result = b*a;
                    stack.push(result);
                    break;
                case '/':
                    a = stack.pop();
                    b = stack.pop();
                    result = b/a;
                    stack.push(result);
                    break;
                default:
                    stack.push(temp[s_Array[i]-65]);
                    break;
            }

        }
        System.out.println(String.format("%.2f",result));

    }


}
