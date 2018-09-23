package Leetcode;
/**
 * Reverse Integer. Range [-2^31, 2^31-1].
 * Example:
 * input: 123
 * output: 321
 * */
public class ReverseInt {
    /*我的答案*/
    public int reverse(int x){
        //123 = 10^2 * 1 + 10 * 2 + 3;
        //3 = 123%10
        //2 = 123/10 % 10
        //1 = 123/10^2 % 10
        //321 = 10^2 * 3 + 10 * 2 + 1;
        long order = 1;
        int bits = 0;
        long abs = Math.abs(Long.valueOf(x));
        StringBuffer reversedStr = new StringBuffer();
        while ((abs / order) != 0){
            reversedStr.append((abs/order) % 10);
            order *= 10;
        }

        if (reversedStr.length() != 0) {
            long reversed = Long.parseLong(reversedStr.toString());
            if (x < 0) {
                reversed = reversed * -1;
            }

            if (reversed <= (long)Math.pow(2, 31) - 1 && reversed > (long)-Math.pow(2, 31)) {
                return (int) reversed;
            } else {
                return 0;
            }
        }else {
            return 0;
        }


    }
    /*标准答案。。。。*/
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
