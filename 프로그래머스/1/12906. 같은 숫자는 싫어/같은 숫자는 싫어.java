import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        //일단 첫번 째 수 넣음
        //top이랑 다르면 넣음
        stack.push(arr[0]);
        
        for(int i = 1; i < arr.length;i++){
            if(stack.peek() != arr[i])
                stack.push(arr[i]);
        }
        int[] answer = new int[stack.size()];
        
        for(int i = 0; i < stack.size(); i++){
            answer[i] = stack.get(i);
        }
        
        return answer;
        
      

    }
}