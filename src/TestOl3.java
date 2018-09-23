import java.util.Arrays;
import java.util.Scanner;

public class TestOl3 {
    public static int[] alphAndNum(String s){
        if (s == null){
            return null;
        }
        int a = 0; //number of characters
        int b = 0; //number of numbers
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c <= 90 && c >= 65 || c <= 122 && c >= 97){
                a ++;
            }

            if (c <= 57 && c >= 48){
                b ++;
            }
        }

        res[0] = b;
        res[1] = a;
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] res = alphAndNum(s);
        System.out.println(res[0]+","+res[1]);

    }
}
