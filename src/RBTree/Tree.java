package RBTree;

/*
红黑树性质：
1. 任何一个节点非红即黑；
2. 树的根为黑色；
3. 叶子节点为黑色(注意：红黑树的所有叶子节点都指的是Nil节点)；
4. 红色节点的子节点必是黑色；
5. 任何节点到其所有分枝叶子的简单路径上的黑节点个数相同；
 */



public class Tree <T extends Comparable<T>>{
    private TreeNode<T> root;
    public Tree(TreeNode root){
        this.root=root;
    }
    public void setRoot(TreeNode root){
        this.root=root;
    }

    public TreeNode getRoot() {
        return root;
    }

    //查找
    public boolean search(T value){
        TreeNode<T> current=root;
        while(true) {
            if (current == null) {
                return false;
            } else {
                if (current.getValue().compareTo(value) == 0) {
                    return true;
                } else if (current.getValue().compareTo(value) < 0) {
                    current = current.getRightSon();
                } else if (current.getValue().compareTo(value) > 0) {
                    current = current.getLeftSon();
                }
            }
        }
    }


    //插入节点
    public boolean insert(T value){
        //检查节点是否存在
        if(!search(value)) {
            TreeNode<T> current = root;
            TreeNode<T> newnode = new TreeNode<T>(value, Color.RED);
            while (true) {
                if (current.getValue().compareTo(value)>=0) {
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
            rbFix(current);
            return true;
        }else {
            System.out.println("Existed");
            return false;
        }

    }

    private void rbFix(TreeNode<T> node){
        TreeNode<T> father;
        TreeNode<T> gfather;
        //修整条件:父节点不为空且父节点为红色
        while((father=node.getFather())!=null&&father.getColor()==Color.RED){
            gfather=father.getFather();
            //若父节点是左子节点，else相反
            if (father==gfather.getLeftSon()){
                TreeNode<T> uncle=gfather.getRightSon();
                //case 1:如果叔叔也是红色
                if(uncle!=null&&uncle.getColor()==Color.RED){
                    father.setColor(Color.BLACK);
                    uncle.setColor(Color.BLACK);
                    gfather.setColor(Color.RED);
                    node=gfather;//节点指向祖父
                }
                //case 2:如果叔叔为黑，且当前节点为右子节点
                if(uncle!=null&&uncle.getColor()==Color.BLACK&&node.getType()==SonType.RIGHT){
                    rightRotate(father);
                    TreeNode<T> temp=father;//替换父子，为后面case 3做准备
                    father=node;
                    node=temp;
                }

                //case 3:叔叔为黑，当前为左子节点
                father.setColor(Color.BLACK);
                gfather.setColor(Color.RED);
                rightRotate(gfather);
            }else{
                TreeNode<T> uncle=gfather.getLeftSon();
                //case 1:如果叔叔也是红色
                if(uncle!=null&&uncle.getColor()==Color.RED){
                    father.setColor(Color.BLACK);
                    uncle.setColor(Color.BLACK);
                    gfather.setColor(Color.RED);
                    node=gfather;//节点指向祖父
                }
                //case 2:如果叔叔为黑，且当前节点为右子节点
                if(uncle!=null&&uncle.getColor()==Color.BLACK&&node.getType()==SonType.RIGHT){
                    leftRotate(father);
                    TreeNode<T> temp=father;//替换父子，为后面case 3做准备
                    father=node;
                    node=temp;
                }

                //case 3:叔叔为黑，当前为左子节点
                father.setColor(Color.BLACK);
                gfather.setColor(Color.RED);
                leftRotate(gfather);
            }
        }
        //将根节点设置为黑色
        this.root.setColor(Color.BLACK);

    }

    public boolean remove(T value){
        TreeNode current=root;
        while(true) {
            //找到要删除的节点
            if (current == null) {
                System.out.println("Doesn't exist.");
                return false;
            } else {
                if (current.getValue().compareTo(value)==0 ) {
                    break;
                } else if (current.getValue().compareTo(value) < 0) {
                    current = current.getRightSon();
                } else if (current.getValue().compareTo(value) > 0) {
                    current = current.getLeftSon();
                }
            }
        }
        //四种情况
        //case 1:删除的节点左右子树都非空
        //case 2:删除的节点左子树为空，右子树非空
        //case 3:删除的节点右子树为空，左子树非空
        //case 4:删除的节点左右子树都为空
        //case 1按照二叉搜索树处理后会变成后三种的一种。
        //case 1
        if(current.getRightSon()!=null&&current.getLeftSon()!=null){
            //找右子树最小值sub
            TreeNode<T> sub=current.getRightSon();
            while (sub.getLeftSon()!=null){
                sub=sub.getLeftSon();
            }
            //将current值替换为sub值，此时需要删除的节点即为sub，且sub的左子节点必为nil。
            current.setValue(sub.getValue());
            TreeNode<T> subfather=sub.getFather();
            /*
            sub case 1:sub为红色。
            因为sub为红色，sub.father必为黑色(性质4)。sub.right必为nil(性质5)。
            又分两种情况：sub是右子节点，sub是左子节点。
            此时只需删除sub，并将sub.father的左子节点设为null。
             */
            if (sub.getColor()==Color.RED){
                /*
                sub sub case 1:sub为右子节点，即sub.father就是current。
                只需删除sub即可。
                sub sub case 2:sub为左子节点。
                 */
                if(sub.getType()==SonType.RIGHT){
                    subfather.setRightSon(null);
                }else {
                    subfather.setLeftSon(null);
                }
            }
            /*
            sub case 2:sub为黑色。
            又分为两种情况:sub.right为nil或不为nil。
             */
            if (sub.getColor()==Color.BLACK){
                /*
                sub sub case 1: sub.right不为空。sub.right必为红色，且两个孙子节点为nil。
                直接将sub.value设为sub.right.value。sub.right设为null。
                 */
                if (sub.getRightSon()!=null){
                    sub.setValue((T) sub.getRightSon().getValue());
                    sub.setRightSon(null);
                }
                /*
                sub sub case 2:sub.right为空。那么删除sub后，只能通过sub.parent的另一个子树调整。
                sub可能是左子节点也可能是右子节点但本质一样+按照兄弟节点的颜色分类，又又又四种情况。
                 */
                else {
                    if (sub.getType()==SonType.LEFT) {
                        /*sub sub sub case 1:sub.brother是红的，sub为左节点。此时sub.parent肯定是黑的，su.brother肯定有两个黑子节点。*/
                        TreeNode<T> brother = subfather.getRightSon();
                        if (brother.getColor()==Color.RED) {
                            subfather.setLeftSon(null);
                            //删除之后，subfather右子树黑节点多1，需要调整。
                            leftRotate(subfather);
                            subfather.setColor(Color.RED);
                            subfather.getFather().setColor(Color.BLACK);
                            //此时subfather的father是subfather.right。将subfather视作sub。情况变为sub.brother也是黑的中的一种。
                            sub = subfather;
                            subfather = sub.getFather();
                            brother=subfather.getRightSon();
                        }
                        /*sub sub sub case 2:sub.brother是黑的，sub为左节点。又四种。。。。*/
                        if (brother.getColor()==Color.BLACK){
                            /*1. b.left为红，b.right任意（nil或者红），subfather任意颜色。*/
                            if (brother.getLeftSon()!=null&&brother.getLeftSon().getColor()==Color.RED) {
                                subfather.setLeftSon(null);
                                rightRotate(brother);
                                //把原来的b.left即现在的b.father设为subfather的颜色
                                brother.getFather().setColor(subfather.getColor());
                                subfather.setColor(Color.BLACK);
                                leftRotate(subfather);
                            }
                            /*2. b.right为红，b.left任意（nil或红），和第一种相似。*/
                            else if (brother.getRightSon()!=null&&brother.getRightSon().getColor()==Color.RED){
                                subfather.setLeftSon(null);
                                brother.setColor(subfather.getColor());
                                brother.getRightSon().setColor(Color.BLACK);
                                subfather.setColor(Color.BLACK);
                                leftRotate(subfather);
                            }
                            /*3. b.right和b.left均为null。subfather是红。*/
                            else if (brother.getLeftSon()==null&&brother.getRightSon()==null&&subfather.getColor()==Color.RED){
                                subfather.setColor(Color.BLACK);
                                brother.setColor(Color.RED);
                            }
                            /*4. b.right和b.left均为null。subfather是黑。
                            * 这种情况，把sub.brother染红，把subfather当成新的删除sub之后的情况，回溯到sub case 2。*/
                        }
                    }else {

                    }

                }
            }
        }
        return false;
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
}
