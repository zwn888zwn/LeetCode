import java.util.Stack;

public class _617合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null)
            return t2;
        if (t2==null)
            return t1;
        //只有两边都存在才进行
        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }
    //迭代
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        Stack<TreeNode[]> stack=new Stack<>();
        if (t1!=null && t2!=null)
            stack.push(new TreeNode[]{t1,t2});//栈里只保存T1T2都存在的情况，其他情况直接赋值后丢弃
        while (!stack.isEmpty()){
            TreeNode[] father=stack.pop();
            father[0].val+=father[1].val;
            if (father[0].left!=null && father[1].left!=null)
                stack.push(new TreeNode[]{father[0].left,father[1].left});
            if (father[0].right!=null && father[1].right!=null)
                stack.push(new TreeNode[]{father[0].right,father[1].right});
            if (father[0].left==null){
                father[0].left=father[1].left;
            }
            if (father[0].right==null){
                father[0].right=father[1].right;
            }

        }
        return t1==null?t2:t1;
    }
}
