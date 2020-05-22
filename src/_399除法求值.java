import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _399除法求值 {
    //构造树 ，计算时分别求得a b到根节点路径积，然后相除

    class Node{
        double pathLength=1;
        Node parent;
    }
    Map<String,Node> nodes=new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build map
        for (int i=0;i<equations.size();i++){
            List<String> equa=equations.get(i);
            String key1=equa.get(0);
            String key2=equa.get(1);
            Node node1=nodes.getOrDefault(key1,new Node());
            Node node2=nodes.getOrDefault(key2,new Node());
            if (node2.parent==null){
                node2.parent=node1;
                node2.pathLength=values[i];
            }else {//防止node有多个father 颠倒下
                node1.parent=node2;
                node1.pathLength=1/values[i];
            }
            nodes.put(key1,node1);
            nodes.put(key2,node2);

        }
        //cal
        double[] res=new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> equa=queries.get(i);
            String key1=equa.get(0);
            String key2=equa.get(1);
            Node node1=nodes.getOrDefault(key1,new Node());
            Node node2=nodes.getOrDefault(key2,new Node());
            double cal1=1,cal2=1;
            while (node1.parent != null){
                cal1*=node1.pathLength;
                node1=node1.parent;
            }
            while (node2.parent != null){
                cal2*=node2.pathLength;
                node2=node2.parent;
            }
            if (node1==node2)
                res[i]=cal2/cal1;
            else
                res[i]=-1.0;
        }

        return res;
    }
}
