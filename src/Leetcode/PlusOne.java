package Leetcode;
/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 *
 *         最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 *         你可以假设除了整数 0 之外，这个整数不会以零开头。*/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int a = digits.length - 1;
        while (true){
            if (a < 0){
                digits = new int[digits.length + 1];
                digits[0] = 1;
                return digits;
            }
            if (digits[a] == 9){
                digits[a] = 0;
                a--;
            }else {
                digits[a] = digits[a] + 1;
                break;
            }
        }
        return digits;
    }
}
