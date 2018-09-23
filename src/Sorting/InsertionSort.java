package Sorting;

import java.util.Arrays;
/**
 * // 分类 ------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
 * // 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 稳定*/
public class InsertionSort {
    public static int[] insertionSort(int[] array){
        int temp;
        for (int i=1;i<array.length;i++){
            temp=array[i];
            for (int j=i-1;j>=0;j--){
                if (temp>array[j]){
                    for (int h=i-1;h>j;h--){
                        array[h+1]=array[h];
                    }
                    array[j+1]=temp;
                    break;
                }
                if (j==0){
                    for (int h=i-1;h>=j;h--){
                        array[h+1]=array[h];
                    }
                    array[j]=temp;
                    break;
                }
            }
        }
        return array;
    }


    public void insertionSortEz(int[] A, int n){
        for (int i = 1; i < n; i++)         // 类似抓扑克牌排序
        {
            int get = A[i];                 // 右手抓到一张扑克牌
            int j = i - 1;                  // 拿在左手上的牌总是排序好的
            while (j >= 0 && A[j] > get)    // 将抓到的牌与手牌从右向左进行比较
            {
                A[j + 1] = A[j];            // 如果该手牌比抓到的牌大，就将其右移
                j--;
            }
            A[j + 1] = get; // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
        }
    }
    public static void main(String[] args){
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(insertionSort(arr)));

    }
}
