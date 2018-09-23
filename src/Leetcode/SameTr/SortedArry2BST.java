package Leetcode.SameTr;

import java.util.Arrays;

public class SortedArry2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //排序数组，取中心点为根
        if (nums.length == 0){
            return null;
        }

        if (nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int centre = nums.length/2;
        TreeNode root = new TreeNode(nums[centre]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, centre));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, centre+1, nums.length));
        return root;

    }
}
