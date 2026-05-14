class Solution {
    public int solution(int n, int w, int num) {

        int row = (n / w) + 1; //런타임 초과떠서 ai 도움
        int[][] map = new int[row][w];
        int box = 1;
        
        //1. 지그재그 배열 만듬
        for(int r = 0 ; r < row ; r++){
            if(box > n) break;
        
            //짝수일 경우
            if(r % 2 == 0){
                for(int c = 0; c < w ; c++){
                    if(box <= n) map[r][c] = box++;
                }
            }
            //홀수일 경우 
            else{
                for(int c = w-1; c >= 0 ; c--){
                 if(box <= n) map[r][c] = box++;
                }
            }
        }
        
        // 2. num의 위치를 찾음
        int x = -1;
        int y = -1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < w; j++){
                if(map[i][j] == num){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1) break;
        }
        
        // 3. 위로 올라가면서 열 count
        int count = 0;
        for(int i = x; i < row; i++){
            if(map[i][y] != 0){
                count++;
            }
            else{
                break;
            }
        }
        
        return count;
        
        
        
        
        
    }
}