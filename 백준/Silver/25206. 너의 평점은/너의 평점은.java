import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double hakjum = 0.0;
        double grade = 0.0;
        double t_grade = 0.0;
        double answer = 0.0;
        double t_hakjum = 0.0;

        for(int i=0;i<20;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            st.nextToken(); // 과목명 - 필요없음
            hakjum = Double.parseDouble(st.nextToken()) ; // 학점
            grade = 0.0;
            switch (st.nextToken()){
                case "A+":
                    grade = hakjum * 4.5;
                    t_hakjum += hakjum;
                    break;
                case "A0":
                    grade = hakjum *4.0;
                    t_hakjum += hakjum;
                    break;
                case "B+":
                    grade = hakjum *3.5;
                    t_hakjum += hakjum;
                    break;
                case "B0":
                    grade = hakjum *3.0;
                    t_hakjum += hakjum;
                    break;
                case "C+":
                    grade = hakjum *2.5;
                    t_hakjum += hakjum;
                    break;
                case "C0":
                    grade = hakjum *2.0;
                    t_hakjum += hakjum;
                    break;
                case "D+":
                    grade = hakjum *1.5;
                    t_hakjum += hakjum;
                    break;
                case "D0":
                    grade = hakjum * 1.0;
                    t_hakjum += hakjum;
                    break;
                case "F":
                    t_hakjum += hakjum;
                    break;
                case "P":
                    break;
            }
            t_grade += grade;

        }

        System.out.println(t_grade / t_hakjum);
    }
}
