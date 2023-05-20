import java.util.*;
import java.io.*;

class Main { 
  public static int[][] arr;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    arr = new int[9][9];

    for(int i=0;i<9;i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j=0;j<9;j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    sudoku(0,0);

  }

  public static void sudoku(int row, int col){
    if(col==9) {sudoku(row+1,0);
    	return;
    }
    else if(row==9) {
      for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
          sb.append(arr[i][j]).append(" ");
        }
        sb.append("\n");
      }
      System.out.print(sb);
      System.exit(0);
    }

    if(arr[row][col]==0){
      for(int i=1;i<=9;i++){
        if(check(row,col,i)){
          arr[row][col] = i;
          sudoku(row,col+1);
        
        }
      }
      arr[row][col]=0;
      return;
    }
    sudoku(row,col+1);

  }

  public static boolean check(int row, int col, int val){
    for(int i=0;i<9;i++){
      if(arr[row][i]==val) return false;
    }
    for(int i=0;i<9;i++){
      if(arr[i][col]==val) return false;
    }
    int box_row = (row/3)*3;
    int box_col = (col/3)*3;

    for(int i=box_row;i<box_row+3;i++){
      for(int j=box_col;j<box_col+3;j++){
        if(arr[i][j]==val)  return false;
      }
      
    }
    return true;
  }

}