package Leetcode.SameTr;

public class BalancedBET {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        if (Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getTreeHeight(TreeNode rootNode) {
        if(rootNode==null){
            return 0;
        }
        int nLeft = getTreeHeight(rootNode.left);
        int nRight = getTreeHeight(rootNode.right);
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }
}
