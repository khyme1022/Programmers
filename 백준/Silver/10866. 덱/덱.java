
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[20001];

        int front = 10001; // 현재 숫자가 있는 위치
        int back = 10001; // 다음에 추가할 위치

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.countTokens()==2){
                switch(st.nextToken()){
                    case "push_front": // front는 앞으로 가서 추가
                        arr[--front] = Integer.parseInt(st.nextToken());
                        break;
                    case "push_back": // back은 현재에서 추가하고 뒤로 이동
                        arr[back++] = Integer.parseInt(st.nextToken());
                        break;
                }
            }
            else{
                switch(st.nextToken()){
                    case "pop_front": // 덱에 가장 앞에 있는 정수를 빼고 출력 / 없으면 -1
                        if(front==back) sb.append(-1).append("\n");
                        else sb.append(arr[front++]).append("\n");
                        break;
                    case "pop_back": // 덱에 가장 앞에 있는 정수를 빼고 출력 / 없으면 -1
                        if(front==back) sb.append(-1).append("\n");
                        else {
                            sb.append(arr[(back--)-1]).append("\n");
                        }

                        break;
                    case "size": // 덱에 들어있는 정수의 개수 출력
                        sb.append(back-front).append("\n");
                        break;
                    case "empty": // 덱이 비어있으면 1 아니면 0 출력
                        if(front== back) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "front": // 덱의 가장 앞에 있는 정수 출력 / 없으면 -1
                        if(front==back) sb.append(-1).append("\n");
                        else sb.append(arr[front]).append("\n");
                        break;
                    case "back": // 덱의 가장 뒤에 있는 정수 출력 / 없으면 -1
                        if(front==back) sb.append(-1).append("\n");
                        else sb.append(arr[back-1]).append("\n");
                        break;

                }
            }
        }
        System.out.println(sb);
    }
}

//        push_front X: 정수 X를 덱의 앞에 넣는다.
//        push_back X: 정수 X를 덱의 뒤에 넣는다.
//        pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        size: 덱에 들어있는 정수의 개수를 출력한다.
//        empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//        front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

