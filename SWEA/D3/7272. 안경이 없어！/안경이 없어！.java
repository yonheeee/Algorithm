import java.util.*;
import java.io.*;

public class Solution {

    static Character[] hole = {'A','D','O','P','Q','R'};
    static Set<Character> hole_set= new HashSet<>(Arrays.asList(hole));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            String result = "SAME";

            if(s1.length() != s2.length()){
                result = "DIFF";
            }
            else{
                for(int i = 0;i < s1. length();i++){
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);

                    if(getGroup(c1) != getGroup(c2)){
                        result = "DIFF";
                        break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");

        }
        System.out.println(sb.toString());
    }

    static int getGroup(char c){
        if(c == 'B') return 2;
        if(hole_set.contains(c)) return 1;
        else return 0;
    }



}
