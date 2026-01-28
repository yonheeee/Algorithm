import java.util.Scanner;
//소문자 97 ~ 122
//대문자 65 ~ 90
//소문자 -32 = 대문자
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char b;
        String answer = "";
        
        for(int i = 0; i<a.length(); i++){
            b = a.charAt(i);
            //charAt은 문자열에서 문자 하나만 가져오는 함수
            if(Character.isUpperCase(b)){
                answer += Character.toLowerCase(b);
            } else{
                answer += Character.toUpperCase(b);
            }
        }
        System.out.print(answer);
        
    }
}