/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;import java.util.*;
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc;i++){
            int N = Integer.parseInt(br.readLine());


                int[] cnt = new int[12];

                for(int v = 2; v <= 9;v++)
                    cnt[v] = 4;
                cnt[10] = 16;
                cnt[11] = 4;

                int sum = 0;

                for(int l = 0; l < N; l++){
                    int v = Integer.parseInt(br.readLine());
                    sum+=v;
                    cnt[v]--;
                }

                int gazua = 0;
                int stop = 0;

                for(int v = 2; v <= 11; v++){
                    int c = cnt[v];
                    if(c <= 0) continue;;
                    if(sum + v > 21)
                        stop += c;
                    else
                        gazua += c;
                }
                sb.append("#").append(i+1).append(" ").append(stop >= gazua ? "STOP" : "GAZUA").append("\n");
            }
        System.out.print(sb);

    }
}

// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
	   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
