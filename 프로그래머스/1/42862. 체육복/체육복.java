class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //여벌 체육복 학생이 도난당했을 경우 제외
        //양 옆 탐색, 작은쪽부터
        int[] clothes = new int[n];
        
        for(int i = 0; i < reserve.length; i++){
            clothes[reserve[i] - 1]++;
        }
        
        for(int i = 0; i < lost.length; i++){
            clothes[lost[i] -1]--;
        }
        
        for(int i = 0; i < n; i++){
            if(clothes[i] == -1){ //체육복 없는 학생
                
                if(i > 0 && clothes[i-1] == 1){
                    clothes[i - 1] = 0; 
                    clothes[i] = 0; 
                }
                else if (i < n - 1 && clothes[i + 1] == 1) { //뒤에 확인
                    clothes[i + 1] = 0;  
                    clothes[i] = 0;       // 빌린 학생
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (clothes[i] >= 0) {  
                answer++;
            }
        }
        return answer;
    }
}