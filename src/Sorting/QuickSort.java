package Sorting;


import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] array){
        quickSortHelper(array, 0, array.length-1);
        return array;
    }

    public static void quickSortHelper(int[] array, int lo, int hi){
        if (lo>hi){
            return ;
        }
        int index=partition(array, lo, hi);
        quickSortHelper(array, lo, index-1);
        quickSortHelper(array, index+1, hi);
    }

    public static int partition(int[] array, int left, int right){
        int pivotValue=array[left];
        int lp=left;
        int rp=right;
        int temp;
        while(rp>lp){
            while(array[rp]>=pivotValue&&rp>lp){
                rp--;
            }
            while(array[lp]<=pivotValue&&rp>lp){
                lp++;
            }
            if (rp!=lp){
                temp=array[lp];
                array[lp]=array[rp];
                array[rp]=temp;
            }else {
                array[left]=array[rp];
                array[rp]=pivotValue;
            }
        }


        return rp;
    }

    public static void main(String[] args){
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(quickSort(arr)));

    }
}
