import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        char[] temp = S.toCharArray();
        boolean chk = false;

        for(int i =0;i<S.length();i++){
            if(temp[i]=='<'){
                chk = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(temp[i]);
            }else if(temp[i]=='>'){
                chk = false;
                sb.append(temp[i]);
            }else if(temp[i]==' '&&!chk){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(temp[i]);
            }
            else{
                if(chk){
                    sb.append(temp[i]);
                }else{
                    stack.push(temp[i]);
                }
            }

        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
