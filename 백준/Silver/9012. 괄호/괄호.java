
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        String s = "";
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<N;i++){
            s = br.readLine();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='(') count++;
                else count--;
                if (count<0) break;
            }
            if(count == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
            count = 0;
        }

        System.out.println(sb);
    }
}
