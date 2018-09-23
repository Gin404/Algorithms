package Leetcode;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。*/
public class ClimbStairs {
    public int climbStairs(int n) {
        //动态规划：S(n) = S(n-1) + S(n-2)
        //S(1) = 1; S(0) = 1;
        int a = 1;
        int b = 1;
        while (n-- != 0){
            b = b + a;
            a = b - a;
        }
        return a;
    }
}
