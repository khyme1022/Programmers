import java.util.*;
import java.io.*;

class Main {
  public static int[] arr;
  public static int cnt;
  public static int N;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken()); // 원
    arr = new int[N];
    cnt = 0;
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(br.readLine()); // 동전 가치
    }
    System.out.print(greedy(K));

  }
  public static int greedy(int won){
    for(int i=N-1;i>=0;i--){
      while(won>=arr[i]){
        won -= arr[i];
        cnt++;
      }
    }
    return cnt;
  }
}