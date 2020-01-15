import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeandDeserializeBinaryTree {

    static class Codec {
        // Encodes a tree to a single string.
        //bfs          //节点间用&隔开，属性之间用,隔开  id,val,parent,lorR
        public String serialize(TreeNode root) {
            if (root==null)
                return "";
            StringBuffer res=new StringBuffer();
            Queue<TreeNode>  queue= new LinkedList<>();
            res.append(root.hashCode()+",");
            res.append(root.val+",");
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                if (node.left!=null){//add string and queue
                    res.append("&");
                    res.append(node.left.hashCode()+",");
                    res.append(node.left.val+",");
                    res.append(node.hashCode()+",");
                    res.append("l");
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    res.append("&");
                    res.append(node.right.hashCode()+",");
                    res.append(node.right.val+",");
                    res.append(node.hashCode()+",");
                    res.append("r");
                    queue.offer(node.right);
                }
            }
            return res.toString();
        }

        // Decodes your encoded data to tree.
        //根据hashmap构建树
        public TreeNode deserialize(String data) {
            if ("".equals(data))
                return null;
            HashMap<String,TreeNode> map=new HashMap<>();
            String[] arr=data.split("&");
            String[] rootArr=arr[0].split(",");
            TreeNode root=new TreeNode(Integer.parseInt(rootArr[1]));
            map.put(rootArr[0],root);
            for (int i=1;i<arr.length;i++){
                String[] nodeArr=arr[i].split(",");
                TreeNode tempNode=new TreeNode(Integer.parseInt(nodeArr[1]));
                TreeNode parent=map.get(nodeArr[2]);
                if ( "l".equals(nodeArr[3]))
                    parent.left=tempNode;
                else
                    parent.right=tempNode;
                map.put(nodeArr[0],tempNode);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;

        Codec obj=new Codec();
        String str=obj.serialize(node1);
        System.out.println(str);
        obj.deserialize(str);




    }

}
