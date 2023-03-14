class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper[0].length();
        int luy = wallpaper.length;
        int rdx = 0;
        int rdy = 0;
    
        for(int i=0;i<wallpaper.length;i++){
            // "#" 있을 시
            if(wallpaper[i].contains("#")){
                if(i<luy)
                    luy = i;
                if(i>rdy)
                    rdy = i;
                if(wallpaper[i].indexOf("#")<lux)
                    lux = wallpaper[i].indexOf("#");
                if(wallpaper[i].lastIndexOf("#")>rdx){
                    rdx = wallpaper[i].lastIndexOf("#");
                }
            }


                
        }
        
        int[] answer = new int[4];
        answer[0] = luy;
        answer[1] = lux;
        answer[2] = rdy+1;
        answer[3] = rdx+1;
        return answer;
    }
}