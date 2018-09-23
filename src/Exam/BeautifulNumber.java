package Exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 两个变量，转化成1111....1后的位数，以及进制数。
 * 分别固定变量。
 */
public class BeautifulNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i<=cases; ++i){
            long n = in.nextLong();
            System.out.println("Case #" + i + ":" + beautiful(n));
        }
    }
    /*
    固定进制数，算法复杂度N*logN，只能算小数据，对于10^18这种大数据，需要很多年。。。。。
     */
    private static long beautiful(long n) {
        for (int radix = 2; radix<n; radix++){
            if (isBeautiful(n, radix)){
                return radix;
            }
        }
        return n-1;
    }

    private static boolean isBeautiful(long n, long radix) {
        while (n > 0){
            if (n % radix != 1){
                return false;
            }
            n /=radix;
        }
        return true;
    }
    /*
    固定位数。LogN * LogN * LogN
     */
    private static long beautifulLarge(long n) {
        for (int bits = 64; bits > 1; bits--){
            long radix = getRadix(n, bits);
            if (radix != -1){
                return radix;
            }
        }
        //should not reach here.
        return n-1;
    }

    private static long getRadix(long n, int bits) {
        long minRadix = 2;
        long maxRadix = n;
        while (minRadix < maxRadix){
            long m = minRadix + (maxRadix - minRadix) / 2;
            long t = convert(m, bits);
            if (t == m){
                return m;
            }else if (t < n){
                minRadix = m + 1;
            }else {
                maxRadix = m;
            }
        }
        return -1;
    }
    /*
    返回指定进制和1的个数的十进制数
     */
    private static long convert(long radix, int bits) {
        long sum = 0;
        long component = 1;
        for (int i = 0; i < bits; i++){
            //防止溢出
            if (Long.MAX_VALUE - sum < component){
                sum = Long.MAX_VALUE;
            }else {
                sum += component;
            }

            //防止最后一轮component溢出，毕竟无关紧要
            if (Long.MAX_VALUE / component < radix){
                component = Long.MAX_VALUE;
            }else {
                component = component * radix;
            }
        }
        return sum;
    }
}
