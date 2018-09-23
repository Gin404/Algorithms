package AvlTree;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(41);
        Tree tree=new Tree(root);
        tree.addNode(20);
        tree.addNode(65);
        tree.addNode(11);
        tree.addNode(29);
        tree.addNode(50);
        tree.addNode(91);
        tree.addNode(32);
        tree.addNode(72);
        tree.addNode(99);
        tree.addNode(38);
        tree.addNode(49);
        tree.addNode(88);
        tree.addNode(27);

        tree.deletNode(32);
        tree.deletNode(65);
        tree.deletNode(99);
        tree.addNode(19);
        tree.print();

    }
}
