package RBTree;

import AvlTree.SonType;

public class TreeNode <T extends Comparable<T>>{
    private T value;
    private TreeNode<T> leftSon;
    private TreeNode<T> rightSon;
    private TreeNode<T> father;
    private Color color;
    private RBTree.SonType type;
    public TreeNode(){ }
    public TreeNode(T value, Color color){
        this.value=value;
        this.color=color;
    }
    public TreeNode(T value, TreeNode<T> leftSon, TreeNode<T> rightSon, TreeNode<T> father, Color color){
        this.value=value;
        this.leftSon=leftSon;
        this.rightSon=rightSon;
        this.father=father;
        this.color=color;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setLeftSon(TreeNode<T> leftSon) {
        this.leftSon = leftSon;
        if (leftSon!=null) {
            leftSon.setType(RBTree.SonType.LEFT);
            leftSon.setFather(this);
        }
    }

    public TreeNode getLeftSon() {
        return leftSon;
    }

    public void setRightSon(TreeNode<T> rightSon) {
        this.rightSon = rightSon;
        if (rightSon!=null){
            rightSon.setType(RBTree.SonType.RIGHT);
            rightSon.setFather(this);
        }
    }

    public TreeNode getRightSon() {
        return rightSon;
    }

    private void setFather(TreeNode<T> father){
        this.father=father;
    }

    public TreeNode getFather(){
        return this.father;
    }

    public void setColor(Color color){
        this.color=color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setType(RBTree.SonType type) {
        this.type = type;
    }

    public RBTree.SonType getType() {
        return this.type;
    }
}
