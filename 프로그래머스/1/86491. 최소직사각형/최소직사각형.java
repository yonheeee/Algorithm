class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        
        for(int i = 0; i < sizes.length; i++){
           int large = Math.max(sizes[i][0],sizes[i][1]);
         int small = Math.min(sizes[i][0],sizes[i][1]);
            
            if(large > max){
                max = large;
            }
            
            if(min < small)  {
                min = small;
            }
 
        }
        return max * min;
    }
}