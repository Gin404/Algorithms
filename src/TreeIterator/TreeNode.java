package TreeIterator;

public class TreeNode {
    private final char value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode (char value){
        this.value = value;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (this.left != null) {
            this.left.setParent(this);
        }
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (this.left != null){
            this.right.setParent(this);
        }
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
