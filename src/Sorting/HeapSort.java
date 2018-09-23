package Sorting;

import java.util.Arrays;
import java.util.Calendar;
// 分类 -------------- 内部比较排序
// 数据结构 ---------- 数组
// 最差时间复杂度 ---- O(nlogn)
// 最优时间复杂度 ---- O(nlogn)
// 平均时间复杂度 ---- O(nlogn)
// 所需辅助空间 ------ O(1)
// 稳定性 ------------ 不稳定
public class HeapSort {
   public static void adjust(int[] arr, int idx, int length){
       int temp;
       while(true) {
           int leftChild = 2 * idx + 1;
           if (leftChild > length - 1) {
               break;
           }

           if (leftChild + 1 < length && arr[leftChild] < arr[leftChild + 1]) {
               leftChild++;
           }

           if (arr[leftChild] > arr[idx]) {
               temp = arr[leftChild];
               arr[leftChild] = arr[idx];
               arr[idx] = temp;
               idx = leftChild;
           } else {
               break;
           }
       }
   }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

   public static void heapSort(int[] arr){
       for(int i=arr.length/2-1;i>=0;i--){
           adjust(arr, i, arr.length);
       }
       //System.out.println(Arrays.toString(arr));

       for (int j = arr.length-1;j>0;j--){
           swap(arr, 0, j);
           adjust(arr, 0, j);
       }
   }

   public static void main(String[] args){
       int[] array = {16, 7, 3, 20, 17, 8};
       heapSort(array);
       System.out.println(Arrays.toString(array));
   }
}
