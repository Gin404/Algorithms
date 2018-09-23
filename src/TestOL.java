import java.util.Scanner;

public class TestOL {
    public static void main(String[] args) {
        System.out.println(minM(6));
    }

    public static int minM(int n){
        for (int i = n+1; ;i++){
            if (lcmT(1, i) == lcmT(n+1, i)){
                return i;
            }
        }
    }

    public static int lcmT(int s, int e){
        if (s == e){
            return s;
        }
        if (s - e == 1){
            return s*e;
        }
        int res = lcm(s, s+1);
        for (int i = 2; i <= e - s; i++){
            res = lcm(res, s+i);
        }
        return res;
    }

    public static int mcd(int a, int b){
        if (a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        if (a%b == 0){
            return b;
        }else {
            return mcd(b, a%b);
        }
    }

    public static int lcm(int a, int b){
        if (a == b){
            return a;
        }
        else {return a*b/mcd(a, b);}
    }

}
