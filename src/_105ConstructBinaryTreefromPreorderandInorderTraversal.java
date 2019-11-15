import java.util.HashMap;
import java.util.HashSet;

public class _105ConstructBinaryTreefromPreorderandInorderTraversal {
/*    public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0)
            return null;
        NodeState node[]=new NodeState[inorder.length];
        TreeNode root=new TreeNode(preorder[0]);
        HashMap<Integer,TreeNode> map=new HashMap<>();
        map.put(preorder[0],root);
        int midIndex=0;
        for (int i=0;i<inorder.length;i++){
            node[i]=new NodeState(inorder[i]);
            if (preorder[0]==inorder[i])
                midIndex=i;
        }
        setState(midIndex,-1,node);
        for(int i=1;i<preorder.length;i++){
            midIndex=findIndex(preorder[i],inorder);
            addNode(midIndex,node,map);
            setState(midIndex,preorder[i],node);
        }

        return root;
    }

    private void addNode(int midIndex, NodeState[] node, HashMap<Integer,TreeNode> map) {
        TreeNode temp=new TreeNode(node[midIndex].val);
        if (node[midIndex].direction==1){
            map.get(node[midIndex].parentVal).left=temp;
        }else if (node[midIndex].direction==2){
            map.get(node[midIndex].parentVal).right=temp;
        }
        //node[midIndex].isAllocate=true;
        map.put(node[midIndex].val,temp);
    }

    private int findIndex(int i, int[] inorder) {
        for(int j=0;j<inorder.length;j++){
            if (inorder[j]==i)
                return j;
        }
        return -1;
    }


    private void setState(int midIndex,int parentVal,NodeState node[]) {
        int pointer=midIndex-1;
        while(pointer>=0 && node[midIndex].parentVal==node[pointer].parentVal){
            node[pointer].parentVal=node[midIndex].val;
            node[pointer].direction=1;
            pointer--;
        }
        pointer=midIndex+1;
        while(pointer<=node.length-1 && node[midIndex].parentVal==node[pointer].parentVal){
            node[pointer].parentVal=node[midIndex].val;
            node[pointer].direction=2;
            pointer++;
        }
    }

    private class NodeState{
        int val;
        //boolean isAllocate;
        int parentVal=-1;
        int direction;//0not  1left 2right

        public NodeState(int val) {
            this.val = val;
        }
    }




    public static void main(String[] args) {
        _105ConstructBinaryTreefromPreorderandInorderTraversal obj=new _105ConstructBinaryTreefromPreorderandInorderTraversal();
        obj.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
