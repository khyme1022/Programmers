import java.util.*;
import java.io.*;

class Main {
  public static int[] dp;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    dp = new int[N+1];

    for(int i=1;i<N+1;i++){
      dp[i] = -1;
    }
    dp[0] = 0;
    dp[1] = 0;
    
    System.out.print(cnt(N));
  }

  public static int cnt(int num){
    if(dp[num]==-1){
      if(num%6==0){
        dp[num] = Math.min(cnt(num/3),Math.min(cnt(num/2),cnt(num-1)))+1;
      }else if(num%3==0){
        dp[num] = Math.min(cnt(num/3),cnt(num-1))+1;
      }else if(num%2==0){
        dp[num] = Math.min(cnt(num/2),cnt(num-1))+1;
      }else{
        dp[num] = cnt(num-1)+1;        
      }
    
    }
    return dp[num];    
  }
}