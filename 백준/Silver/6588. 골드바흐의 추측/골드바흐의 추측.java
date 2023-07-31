import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        boolean[] prime = new boolean[1000001];
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<prime.length;i++){ // 체
            if(!prime[i]){
                for(int j=2;i*j<prime.length;j++){
                    prime[i*j] = true;
                }
                list.add(i);
            }

        }
        boolean goldbach = true;
        while (true)
        {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int a = 0;
            int b = 0;


            for(int i=0;i<=list.size();i++){
                a = list.get(i);
                b = n-a;
                if(!prime[b]) // b가 소수면
                    break;
            }
            sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
        }
        if(goldbach) System.out.println(sb);
        else System.out.println("Goldbach's conjecture is wrong.");


    }
} // 0이 나올때까지 입력 받기
