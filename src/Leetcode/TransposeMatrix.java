package Leetcode;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int[][] T = new int[A[0].length][A.length];

        for (int r = 0; r < A.length; ++r)
            for (int c = 0; c < A[0].length; ++c) {
                T[c][r] = A[r][c];
            }

        return T;
    }
}
