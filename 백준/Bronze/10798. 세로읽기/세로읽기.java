import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                arr[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int col = 0; col < 15; col++){
            for(int row = 0; row < 5; row++){
                if(arr[row][col] != '\0'){
                    sb.append(arr[row][col]);
                }
            }
        }
        System.out.print(sb);
    }
}
