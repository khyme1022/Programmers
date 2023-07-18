import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        int now = 1; // 무조건 처음은 (이기 때문에 1로 설정
        // 현재 아래에 있는 스틱 개수
        int stick = 0;
        // 현재 잘라진 스틱 개수
        char[] cmd = input.toCharArray();
        // 명령어 배열
        for(int i=1;i<cmd.length;i++){
            if(cmd[i]=='('){
                now++;
            }else{ // cmd[i] == ')'
                if(cmd[i-1]=='('){ // 레이저 일때
                    now--;
                    stick += now;
                }else{ // 레이저가 아닐때
                    now--;
                    stick++;
                }
            }
        }
        System.out.println(stick);
    }
}
