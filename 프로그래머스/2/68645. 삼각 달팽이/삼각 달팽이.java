class Solution {
    public int[] solution(int n) {
        int[][] trangle = new int[n][n];
        
        int v = 1;
        int x = 0;
        int y = 0;
        
        while(true) {
            while(true) {
                trangle[y][x] = v++;
                if(y + 1 == n || trangle[y + 1][x] != 0) break;
                y += 1;
            }
            if(x + 1 == n || trangle[y][x + 1] != 0) break;
            x += 1;
            
            while(true) {
                trangle[y][x] = v++;
                if(x + 1 == n || trangle[y][x + 1] != 0 ) break;
                x += 1;
            }
            if (trangle[y - 1][x - 1] != 0) break;
            x -= 1;
            y -= 1;
            
            while (true) {
                trangle[y][x] = v++;
                if (trangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1; 
            }
            if(y + 1 == n || trangle[y + 1][x] != 0)break;
            y += 1;
        }
        
        int[] result = new int[v - 1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                result[index++] = trangle[i][j];
            }
        }
        
        return result;
    }
}