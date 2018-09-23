package Sorting;

import java.util.Arrays;
/**简单选择排序
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(n^2)
 * // 最优时间复杂度 ---- O(n^2)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 不稳定
 *
 * 选择排序是不稳定的排序算法，不稳定发生在最小元素与A[i]交换的时刻。
 *
 * 　　比如序列：{ 5, 8, 5, 2, 9 }，一次选择的最小元素是2，然后把2和第一个5进行交换，从而改变了两个元素5的相对次序。
* */

public class SelectionSort {
    private static int[] selectionSort(int[] array){
        int smallest;
        int smallestIndex;
        int temp;
        for(int i=0;i<array.length;i++){
            smallest=array[i];
            smallestIndex=i;
            for (int j=i;j<array.length;j++){
                if (array[j]<smallest){
                    smallest=array[j];
                    smallestIndex=j;
                }
            }
            temp=array[i];
            array[i]=smallest;
            array[smallestIndex]=temp;
        }
        return array;
    }
    public static void main(String[] args){
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }
}
