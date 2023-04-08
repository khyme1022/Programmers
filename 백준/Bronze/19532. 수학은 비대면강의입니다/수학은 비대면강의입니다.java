import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // ax + by = c
        // dx + ey = f
        // y = (-ax+c) / b
        // y = (-dx+f) / e
        // e * (-ax+c) = b * (-dx+f)
        // -eax + ec = -bdx + bf
        // (bd-ea)x = bf - ec
        // x = (bf-ec)/(bd-ea)
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        int left = b*f-e*c;
        int right = b*d-e*a;

        if(b*d-e*a==0){
            x= 0;
        }else{
            x = left/ right;
        }

        if(b==0){
            y = (-d*x+f)/e;
        }else{
            y = (-a*x+c)/b;
        }


        System.out.println(x + " " + y);

    }
}