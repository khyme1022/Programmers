import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int[][] arr = new int [15][15];
    int b;
    int c;
    int answer = 0;

     for(int j=1;j<=14;j++){
         arr[0][j] =j;
      } // 0층 초기화

    for(int i=0;i<a;i++){
      b = Integer.parseInt(br.readLine()); //층 수
      c = Integer.parseInt(br.readLine()); //호 수
      for(int j=1;j<=b;j++){
        for(int k=1;k<=c;k++){
          arr[j][k] = arr[j-1][k]+arr[j][k-1];
        }
      }
      System.out.println(arr[b][c]);
    }

  }
}