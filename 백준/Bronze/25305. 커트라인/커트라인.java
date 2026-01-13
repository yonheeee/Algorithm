import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        StringTokenizer a = new StringTokenizer(br.readLine());
        for(int i = 0;i < N;i++) {
            arr[i] = Integer.parseInt(a.nextToken());

        }

        Arrays.sort(arr);
        System.out.println(arr[N-k]);

    }
}
