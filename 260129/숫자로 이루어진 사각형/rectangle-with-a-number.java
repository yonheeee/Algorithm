import java.util.Scanner;
public class Main {

    private static void Count(int n){
        int count = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(count);
                System.out.print(" ");
                
                if(count == 9){
                    count -=9;
                }

                count++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Count(n);

    }
}