
import java.util.ArrayList;
import java.util.List;

public class _94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        while(root!=null){
            if(root.left!=null){
                TreeNode temp=root.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=root;
                root=temp.right.left;
                temp.right.left=null;

            }else {
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}