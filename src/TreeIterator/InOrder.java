package TreeIterator;

public class InOrder {
    public TreeNode next(TreeNode node){
        if (node == null){
            return null;
        }

        if (node.getRight() != null){
            return first(node.getRight());
        } else {
            while (node.getParent() != null && node.getParent().getLeft() != node){
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    public TreeNode first(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode curNode = node;
        while (curNode.getLeft() != null){
            curNode = curNode.getLeft();
        }

        return curNode;
    }

    public void traversal(TreeNode root){
        for (TreeNode node = first(root) ;
                node != null;
                node = next(node)){
            System.out.print(node.getValue());
        }
        System.out.println();
    }


    public static void main(String[] args){
        TreeCreater creater = new TreeCreater();
        InOrder inOrder = new InOrder();

        TreeNode sampleTree = creater.createSampleTree();
        inOrder.traversal(sampleTree);
    }
}
