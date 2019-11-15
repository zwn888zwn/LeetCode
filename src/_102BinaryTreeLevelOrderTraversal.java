import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102BinaryTreeLevelOrderTraversal {
    /*  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> arr=new ArrayList<>();
            Queue<TreeNode> tempQueue=new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode!=null){
                    arr.add(treeNode.val);
                    if (treeNode.left!=null)
                        tempQueue.offer(treeNode.left);
                    if (treeNode.right!=null)
                        tempQueue.offer(treeNode.right);
                }

            }
            res.add(arr);
            queue=tempQueue;
        }
        return res;
    }
}
