import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 1~15
        int S = Integer.parseInt(st.nextToken()); // 1~28
        int M = Integer.parseInt(st.nextToken()); // 1~19

        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=0;i<7980;i++){ 
            a++;
            b++;
            c++;
            if(a>15)
                a= a- 15;
            if(b>28)
                b = b-28;
            if(c>19)
                c= c-19;
            if(a==E&&b==S&&c==M){ // 입력받은 세 수와 모두 같으면 출력 후 break
                System.out.println(i+1);
                break;
            }
        }
    }
}


// 15 15 15 = 15년
// 1 16 16 = 16년
// 2 17 17 =

// 16 1 2
// 15 28 1
// 14 27 19