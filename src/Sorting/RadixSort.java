package Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] array, int d){
        int[][] buckets = new int[10][array.length];
        int digit = 1;
        int[] order=new int[10];//用于保存每个桶里有多少个数字
        while(digit<d){
            for (int num : array){
                int base = num/digit%10;
                buckets[base][order[base]] = num;
                order[base]++;
            }
            int k = 0;
            for (int i=0;i<10;i++){
                if (order[i] != 0) {
                    for (int j=0;j<order[i]; j++){
                        array[k] = buckets[i][j];
                        k++;
                    }

                }
                order[i] = 0;
            }
            digit*=10;
        }
    }

    public static void main(String[] args)
    {
        int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
        radixSort(A, 100);
            System.out.println(Arrays.toString(A));

    }
}
