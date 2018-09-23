package AvlTree;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree {
    private TreeNode root;
    public Tree(TreeNode root){
        this.root=root;
    }
    public void setRoot(TreeNode root){
        this.root=root;
    }

    public TreeNode getRoot() {
        return root;
    }


    //打印树
    public void print() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(this.root, 1, list);
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
}

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.getValue());

        depth(root.getLeftSon(),depth + 1, list);
        depth(root.getRightSon(), depth + 1, list);
    }

    //查找
    public boolean search(int value){
        TreeNode current=root;
        while(true) {
            if (current == null) {
                return false;
            } else {
                if (current.getValue() == value) {
                    return true;
                } else if (current.getValue() < value) {
                    current = current.getRightSon();
                } else if (current.getValue() > value) {
                    current = current.getLeftSon();
                }
            }
        }
    }

    //计算树的高度
    private int getTreeHeight(TreeNode rootNode) {
        if(rootNode==null){
            return 0;
        }
        int nLeft = getTreeHeight(rootNode.getLeftSon());
        int nRight = getTreeHeight(rootNode.getRightSon());
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }

    //计算平衡因子
    private int getBalVal(TreeNode node){
        if(node==null){
            return 0;
        }
        return getTreeHeight(node.getLeftSon())-getTreeHeight(node.getRightSon());
    }

    //调整平衡，回溯检查平衡因子
    private void rebalance(TreeNode node){
        while (node.getFather()!=null){
            TreeNode father=node.getFather();
            int bvfather=getBalVal(node.getFather());
            int bvnode=getBalVal(node);
            if (bvfather==2){
                //父2子1，左左==》父右旋
                if (bvnode==1){
                    rightRotate(father);
                }
                //父2子-1，左右==》current左旋，父右旋
                else if (bvnode==-1){
                    leftRotate(node);
                    //node旋转后会改变，getfather不再是father，所以不能在这里取父节点，要用father
                    rightRotate(father);
                }
            }else if(bvfather==-2){
                //父-2子-1，右右==》父左旋
                if (bvnode==-1){
                    leftRotate(father);
                }
                //父-2子1，右左==》当前右旋，父左旋
                else if(bvnode==1){
                    rightRotate(node);
                    leftRotate(father);
                }
            }
            node=father;
        }
    }

    //插入节点
    public boolean addNode(int value){
        //检查节点是否存在
        if(!search(value)) {
            TreeNode current = root;
            TreeNode newnode = new TreeNode(value);
            while (true) {
                if (value <= current.getValue()) {
                    if (current.getLeftSon() == null) {
                        current.setLeftSon(newnode);
                        break;
                    } else {
                        current = current.getLeftSon();
                    }
                } else {
                    if (current.getRightSon() == null) {
                        current.setRightSon(newnode);
                        break;
                    } else {
                        current = current.getRightSon();
                    }
                }
            }
            //调整平衡,回溯检查平衡因子
            rebalance(current);
            return true;
        }else {
            System.out.println("Existed");
            return false;
        }

    }

    //删除节点
    public boolean deletNode(int val){
        TreeNode current=root;
        while(true) {
            //找到要删除的节点
            if (current == null) {
                System.out.println("Doesn't exist.");
                return false;
            } else {
                if (current.getValue() == val) {
                    break;
                } else if (current.getValue() < val) {
                    current = current.getRightSon();
                } else if (current.getValue() > val) {
                    current = current.getLeftSon();
                }
            }
        }
        TreeNode father=current.getFather();
        //三种情况
        //情况1：current是叶节点。
        if (current.getLeftSon()==null&&current.getRightSon()==null){
            if (father==null){
                this.root=null;
                return true;
            }
            if(current.getType()== SonType.LEFT){
                father.setLeftSon(null);
            }else if(current.getType()==SonType.RIGHT){
                father.setRightSon(null);
            }
            current=null;
            //从父节点开始，平衡受影响
            rebalance(father);
        }
        //情况2：current有一个子节点。将current父节点和current子节点相连。有2种分支情况。
        //1：有右子节点
        else if (current.getLeftSon()==null&&current.getRightSon()!=null){
            if (father==null){
                this.root=current.getRightSon();
                return true;
            }

            if(current.getType()==SonType.LEFT){
                father.setLeftSon(current.getRightSon());
            }else if(current.getType()==SonType.RIGHT){
                father.setRightSon(current.getRightSon());
            }
            current=null;
            //从父节点开始，平衡受影响
            rebalance(father);
        }
        //2：有左子节点
        else if (current.getLeftSon()!=null&&current.getRightSon()==null){
            if (father==null){
                this.root=current.getLeftSon();
                return true;
            }

            if(current.getType()==SonType.LEFT){
                father.setLeftSon(current.getLeftSon());
            }else if(current.getType()==SonType.RIGHT){
                father.setRightSon(current.getLeftSon());
            }
            current=null;
            //从父节点开始，平衡受影响
            rebalance(father);
        }
        //情况3：左右子节点都有。用current右子树的最小值替换current。
        else if (current.getLeftSon()!=null&&current.getRightSon()!=null){
            //找右子树最小值sub
            TreeNode sub=current.getRightSon();
            while (sub.getLeftSon()!=null){
                sub=sub.getLeftSon();
            }
            //保留sub的父节点信息
            TreeNode subfather=sub.getFather();
            //替换过程
            current.setValue(sub.getValue());
            if (sub.getType()==SonType.RIGHT){
                subfather.setRightSon(sub.getRightSon());
            }else {
                subfather.setLeftSon(sub.getRightSon());
            }
            sub=null;
            //右子树的平衡先受影响
            rebalance(current.getRightSon());
        }
        return true;

    }


    public void leftRotate(TreeNode rotroot){
        if(rotroot!=null&&rotroot.getRightSon()!=null){
            //保留原始rotroot必要信息
            TreeNode temper=rotroot.getRightSon();
            SonType roottype=rotroot.getType();
            TreeNode rootfather=rotroot.getFather();
            //变更rotroot，并将原始信息赋给新rotroot
            rotroot.setRightSon(temper.getLeftSon());
            temper.setLeftSon(rotroot);
            if(roottype==SonType.RIGHT){
                rootfather.setRightSon(temper);
            }else if(roottype==SonType.LEFT){
                rootfather.setLeftSon(temper);
            }

        }

    }

    public void rightRotate(TreeNode rotroot){
        if(rotroot!=null&&rotroot.getLeftSon()!=null){

            TreeNode temper=rotroot.getLeftSon();
            SonType roottype=rotroot.getType();
            TreeNode rootfather=rotroot.getFather();

            rotroot.setLeftSon(temper.getRightSon());
            temper.setRightSon(rotroot);
            if(roottype==SonType.RIGHT){
                rootfather.setRightSon(temper);
            }else if(roottype==SonType.LEFT){
                rootfather.setLeftSon(temper);
            }
        }
    }

    //先序遍历：根左右
    public void preOrder(TreeNode root){
        if (root!=null) {
            System.out.println(root.getValue());
            preOrder(root.getLeftSon());
            preOrder(root.getRightSon());
        }
    }

    //中序遍历
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.getLeftSon());
            System.out.println(root.getValue());
            inOrder(root.getRightSon());
        }
    }

    //后序遍历
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.getLeftSon());
            postOrder(root.getRightSon());
            System.out.println(root.getValue());
        }
    }

}
