import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> queue = new LinkedList<>();
        //53분
    
        //progress에 speeds를 더함(연속적으로)
        //100이 될 때까지 더함
        //100이 되는 날짜 저장
    
        int[] count = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++){
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                count[i]++; 
            }
        }
        
        //앞의 숫자가 뒷 숫자 비교
        //만약에 ++이 끝나면 기준을 다음날로
        //다음날로 옮기면 기본적으로 1
        int day = count[0];
        int sum = 1;
        for(int i = 1; i < count.length; i++){
            if(day >= count[i]){
                sum++;
            }else{
                queue.add(sum);
                day = count[i]; 
                sum = 1;  //새 묶음 시작
            }
        }
        queue.add(sum);
       
        int size = queue.size();
        int[] answer= new int[size];
        
        for(int i = 0; i < size;i++){
            answer[i] = queue.poll();
        }
        
        return answer;
        
        
    }
}