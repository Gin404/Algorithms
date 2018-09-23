package Leetcode.SameTr;


public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode p, TreeNode q){
        if (p == null && q != null || p != null && q == null){
            return false;
        }
        if (p == null && q == null){
            return true;
        }

        return p.val == q.val && symmetric(p.left, q.right) && symmetric(p.right, q.left);
    }
}
