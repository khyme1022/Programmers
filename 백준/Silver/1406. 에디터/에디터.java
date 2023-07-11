import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> Lstack = new Stack<>();
        Stack<Character> Rstack = new Stack<>();


        String s = br.readLine();
        for(int i=0;i<s.length();i++){
            Lstack.push(s.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for(int i =0;i<N;i++){
            String command = br.readLine();
            switch(command.charAt(0)){
                case 'L':
                    if(!Lstack.isEmpty())
                        Rstack.push(Lstack.pop());
                    break;
                case 'D':
                    if(!Rstack.isEmpty())
                        Lstack.push(Rstack.pop());
                    break;
                case 'B':
                    if(!Lstack.isEmpty())
                        Lstack.pop();
                    break;
                case 'P':
                    Lstack.push(command.charAt(2));
                    break;

            }
        }
        while(!Lstack.isEmpty()){
            Rstack.push(Lstack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!Rstack.isEmpty()){
            sb.append(Rstack.pop());
        }
        System.out.println(sb);
    }
}

// L 왼쪽 이동 index 빼기
// D 오른쪽 이동 index 더하기
// B 왼쪽문자 삭제 index에 있는 거 삭제 index 빼기
// P $ $문자를 커서 왼쪽에 추가 // index에 추가후

// L L스택 pop해서 R스택에 넣기 (비어있지 않아야함)
// D R스택 pop해서 L스택에 넣기 (비어있지 않아야함)
// B L스택 pop() (비어있지 않아야함)
// P L스택에 push()