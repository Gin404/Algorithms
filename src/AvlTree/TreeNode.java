package AvlTree;

public class TreeNode {
    private int value;
    private TreeNode leftSon;
    private TreeNode rightSon;
    private TreeNode father;
    private SonType type;
    public TreeNode(){ }
    public TreeNode(int value){
        this.value=value;
    }
    public TreeNode(int value, TreeNode leftSon, TreeNode rightSon){
        this.value=value;
        this.leftSon=leftSon;
        this.rightSon=rightSon;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setLeftSon(TreeNode leftSon) {
        this.leftSon = leftSon;
        if (leftSon!=null) {
            leftSon.setFather(this);
            leftSon.setType(SonType.LEFT);
        }
    }

    public TreeNode getLeftSon() {
        return leftSon;
    }

    public void setRightSon(TreeNode rightSon) {
        this.rightSon = rightSon;
        if (rightSon!=null) {
            rightSon.setFather(this);
            rightSon.setType(SonType.RIGHT);
        }
    }

    public TreeNode getRightSon() {
        return rightSon;
    }

    private void setFather(TreeNode father){
        this.father=father;
    }

    public TreeNode getFather(){
        return this.father;
    }

    private void setType(SonType type){
        this.type=type;
    }

    public SonType getType() {
        return type;
    }

}
