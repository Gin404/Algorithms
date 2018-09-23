package Leetcode.LeafSimilarTrees;


import java.util.ArrayList;
import java.util.List;
/**
 * 叶子相似序列。判断两个二叉树叶子节点组成的序列是否相同。*/
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void getLeaves(TreeNode root, List<Integer> list){
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }

            getLeaves(root.left, list);
            getLeaves(root.right, list);
        }
    }
}
