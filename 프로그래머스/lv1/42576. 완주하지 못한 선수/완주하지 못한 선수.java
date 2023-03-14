import java.util.*;


class Solution {
    // participant 참가자 이름
    // completion 완주자 이름
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i=0;
        for(i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                System.out.println(participant[i] + completion[i]);
                return participant[i];
            }
        }
        return participant[i];
    }
}