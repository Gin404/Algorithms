package Sorting;

import java.util.Arrays;

/**简单插入排序的改进版**/
public class ShellSort {
    public static int[] shellSort(int[] array){

        for(int gap=array.length/2;gap>0;gap/=2){
            for(int i=gap;i<array.length;i++){
                int j = i;
                while(j-gap>=0 && array[j]<array[j-gap]){
                    swap(array,j,j-gap);
                    j-=gap;
                }
            }
        }
        return array;
    }
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }


    public static void main(String[] args){
        int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(shellSort(arr)));

    }
}
