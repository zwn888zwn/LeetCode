import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _406QueueReconstructionbyHeight {
    int target=-1;
    int[][] res=null;
    //带有保存状态的递归DP，因为我这排好了，前面的人肯定也排好了
    //用map<n,arr> 保存状态
    //fixme Time Limit Exceeded
    //todo 提前排个序是不是能剪枝？
    public int[][] reconstructQueue(int[][] people) {
        target=people.length;
        List<int[]> out =new ArrayList<>();
        for (int i=0;i<people.length;i++)
            out.add(people[i]);
        dfs(new ArrayList(),out,0);
        return res;
    }
    public void dfs(List<int[]> in,List<int[]> out,int level){
        if (level==target){
            int[][] res=new int[target][2];
            for (int i=0;i<in.size();i++){
                res[i]=in.get(i);
            }
            this.res=res;
            return;
        }
        for (int i=0;i<out.size();i++){
            int[] p=out.get(i);
            if (match(in,p)){
                List<int[]> tempIn=new ArrayList<>(in);
                List<int[]> tempOut=new ArrayList<>(out);
                tempIn.add(p);
                tempOut.remove(i);
                dfs(tempIn,tempOut,level+1);
            }
        }

    }

    private boolean match(List<int[]> in, int[] p) {
        int count=0;
        for (int[] ints : in) {
            if (p[0]<=ints[0]){
                count++;
            }
        }
        if (p[1]==count){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        _406QueueReconstructionbyHeight obj=new _406QueueReconstructionbyHeight();
        int[][] in={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        obj.reconstructQueue(in);
    }
}
