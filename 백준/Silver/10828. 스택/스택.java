import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            String cmd = br.readLine();
            StringTokenizer st = new StringTokenizer(cmd);

            String op = st.nextToken();

            if(op.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }

            else if(op.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1).append('\n');
                } else{
                    sb.append(stack.pop()).append('\n');
                }

            }
            else if(op.equals("size")){
                sb.append(stack.size()).append('\n');
            }
            else if(op.equals("empty")){
                sb.append(stack.empty() ? 1: 0).append('\n');
            }
            else if(op.equals("top")){
                if (stack.isEmpty()){
                    sb.append(-1).append('\n');
                }
                else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }
        System.out.print(sb);

    }
}