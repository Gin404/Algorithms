package Sorting;

import java.util.Arrays;
/**
 * 冒泡排序，交换排序的一种。
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(n^2)
 * // 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 稳定*/
public class BubbleSort {
    private static int[] bubbleSort(int[] array){
        int temper;
        for (int j=array.length-1;j>1;j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    temper = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temper;
                }
            }
        }
        return array;
    }
    public static void main(String[] args){
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(bubbleSort(arr)));

    }
}
