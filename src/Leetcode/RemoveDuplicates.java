package Leetcode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。*/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int p1 = 0;
        int p2 = 1;

        while (p2 < nums.length){
            if (nums[p2] == nums[p1]){
                p2 ++;
            }else {
                p1 ++;
                nums[p1] = nums[p2];
            }
        }

        return p1+1;
    }
}
