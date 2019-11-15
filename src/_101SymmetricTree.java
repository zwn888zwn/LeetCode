import java.util.LinkedList;
import java.util.Queue;

public class _101SymmetricTree {
    /*  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/
    public boolean isSymmetric(TreeNode root) {
        /*if (root==null || (root.left==null && root.right==null))
            return true;
        return recursive(root.left,root.right);*/

       //return recursive1(root,root);
        return bfs(root);

    }
    public boolean bfs(TreeNode root){
        if (root==null || (root.left==null && root.right==null))
            return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            if(left==null && right==null ) continue;
            if (left==null || right==null || left.val!=right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    public boolean recursive(TreeNode left,TreeNode right){//不太优雅
        if (left==null || right==null|| left.val!=right.val){//不全为空或者不相等
            return false;
        }else{
            boolean leftb=true,rightb=true;
            if (!(left.left==null &&  right.right==null))//除了全空
                leftb=recursive(left.left, right.right);
            if (!(left.right==null && right.left==null))
                rightb= recursive(left.right, right.left);
            return leftb && rightb;
        }

    }
    public boolean recursive1(TreeNode left,TreeNode right){//答案
        if(left==null && right==null) return true; //全为null
        if (left==null || right==null) return false; //不全为null
        return left.val==right.val && recursive1(left.left, right.right) &&recursive1(left.right, right.left);//全不为null
    }

}
