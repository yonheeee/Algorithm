class Solution {
    public int[] solution(int[] num_list) {
        //마지막 원소 >그 전 원소 :  마지막 원소 - 그 원소
        //마지막 < 그 전 원소 : 마지막 워내소*2
        int size = num_list.length;
        
        int[] answer = new int[size+1];
        
        for(int i = 0; i < size; i++){
            answer[i] = num_list[i];
        }
        
        if(num_list[size-1] > num_list[size-2]){
            answer[size] = num_list[size-1] - num_list[size-2];
        }
        
        else{
            answer[size] = num_list[size-1]*2;
        }
    
        return answer;
        
        
    }
}