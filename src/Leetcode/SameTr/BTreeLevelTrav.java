package Leetcode.SameTr;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BTreeLevelTrav {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (! queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < levelsize; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(0, list);

        }
        return result;
    }
}
