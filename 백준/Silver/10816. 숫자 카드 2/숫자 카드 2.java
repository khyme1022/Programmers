import java.util.*;
import java.io.*;

class Main {
  public static int[] arrN;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine()," ");
    arrN = new int[N];
    for(int i=0;i<N;i++){
      arrN[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arrN);
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine()," ");
    int[] arrM = new int[M];
    for(int i=0;i<M;i++){
      arrM[i] = Integer.parseInt(st.nextToken());
      sb.append((upper_bound(arrM[i],N)-lower_bound(arrM[i],N))+" ");
    }
    System.out.print(sb);
  }

  public static int upper_bound(int num,int bound){
    int start = 0;
    int end = bound-1;
    int mid;
    while(end>start){
      mid = (start+end)/2;
      if(arrN[mid]>num)  end = mid;
      else start = mid+1;
    }
    if(arrN[end]==num)  return end+1;
    else return end;
  }

  public static int lower_bound(int num,int bound){
    int start = 0;
    int end = bound-1;
    int mid;
    while(end>start){
      mid = (start+end)/2;
      if(arrN[mid]>=num)  end = mid;
      else start = mid+1;
    }  
    return end;
  }

} 