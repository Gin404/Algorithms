package Leetcode;
/**
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 *
 * 如果没有两个连续的 1，返回 0 。
 *
 * 例：
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。*/

public class BinaryGap {
    public int binaryGap(int N) {
        int remainder = 0, max = 0, temp = 0;
        boolean trigger = false;
        while (N != 0){
            remainder = N % 2;

            if (remainder == 1){
                trigger = true;
                max = Math.max(max, temp);
                temp = 1;
            }else if (remainder == 0 && trigger == true){
                temp ++ ;
            }

            N = N / 2;
        }

        return max;
    }
}
