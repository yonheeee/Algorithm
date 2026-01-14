import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int need = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N;i++){
           int student = Integer.parseInt(st.nextToken());

           if(student == need){
               need++;
           }else{
               stack.push(student);
           }

           while(!stack.isEmpty() && stack.peek() == need){
               stack.pop();
               need++;
           }
        }
          if(need == N+1)
               System.out.println("Nice");
           else
               System.out.println("Sad");
    }
}
