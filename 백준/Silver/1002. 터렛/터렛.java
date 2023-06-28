import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int case_no = Integer.parseInt(br.readLine());
    for(int i=0;i<case_no;i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int x1 =Integer.parseInt(st.nextToken());
      int y1 =Integer.parseInt(st.nextToken());
      int r1 =Integer.parseInt(st.nextToken());
      int x2 =Integer.parseInt(st.nextToken());
      int y2 =Integer.parseInt(st.nextToken());
      int r2 =Integer.parseInt(st.nextToken());
      int r_max = 0;
      int distance = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
      r_max = r1>r2 ? r1:r2;
      if(r_max*r_max>distance){ // 내접
        if((r1-r2)*(r1-r2)==distance){
          if(r1==r2&&distance==0) System.out.println("-1");
          else System.out.println("1");
        } else if((r1-r2)*(r1-r2)>distance) System.out.println("0");
        else  System.out.println("2");
      }else if(r_max*r_max==(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)){
        System.out.println("2");
      }else{ // 외접
        if((r1+r2)*(r1+r2)==distance) System.out.println("1");
        else if((r1+r2)*(r1+r2)>distance) System.out.println("2");
        else  System.out.println("0");
      }
      

    }
  }
}