package Sorting;


import java.util.Arrays;
/**
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(nlogn)
 * // 最优时间复杂度 ---- O(nlogn)
 * // 平均时间复杂度 ---- O(nlogn)
 * // 所需辅助空间 ------ O(n)
 * // 稳定性 ------------ 稳定*/

public class MergeSort {
    public static int[] mergeSort(int[] array){
        int length= array.length;
        if (length<2){
            return array;
        }
        int middle=length/2;
        int[] left= Arrays.copyOfRange(array, 0,middle);
        int[] right= Arrays.copyOfRange(array, middle, array.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] a, int[] b){
        int[]  arr=new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<a.length && j<b.length){
            if (a[i]<b[j]){
                arr[k]=a[i];
                i++;
                k++;
            }else {
                arr[k]=b[j];
                j++;
                k++;
            }
        }

        while (i<a.length){
            arr[k]=a[i];
            i++;
            k++;
        }

        while (j<b.length){
            arr[k]=b[j];
            j++;
            k++;
        }


        return arr;
    }

    public static void main(String[] args){
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(mergeSort(arr)));

    }
}
