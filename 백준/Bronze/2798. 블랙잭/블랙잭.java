import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int card_num = Integer.parseInt(st.nextToken());
    int target_num = Integer.parseInt(st.nextToken());
    int[] card = new int[card_num];
    int sum =0;
    StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

    for(int i=0;i<card.length;i++){
      card[i] = Integer.parseInt(st2.nextToken());
    }
    Arrays.sort(card);
    for(int i=0;i<card.length-2;i++){
      for(int j=i+1;j<card.length-1;j++){
        for(int k=j+1;k<card.length;k++){
          if(card[i] + card[j] + card[k]>target_num)
            break;
          if(card[i] + card[j] + card[k]>sum)
            sum = card[i] + card[j] + card[k];
        }
      }
    }
    System.out.print(sum);


  }
}
