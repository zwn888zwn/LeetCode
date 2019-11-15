import java.util.*;

public class _56MergeIntervals {
    public int[][] merge(int[][] intervals) {
/*        PriorityQueue<List<Integer>> pq=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });*/
        List<List<Integer>> lists=new ArrayList<>();
        for (int[] interval : intervals) {
            List<Integer> list=new ArrayList<>();
            list.add(interval[0]);
            list.add(interval[1]);
            lists.add(list);
        }
        boolean hasChange=true;
        while(hasChange){
            hasChange=false;
            for(int i=0;i<lists.size()-1;i++){
                if(hasChange)
                    break;
                for(int j=i+1;j<lists.size();j++){
                    List<Integer> list1=lists.get(i);
                    List<Integer> list2=lists.get(j);
                    if((list2.get(0)>=list1.get(0) && list1.get(1)>=list2.get(0))||(list1.get(0)>=list2.get(0)&& list1.get(0)<=list2.get(1))){
                        hasChange=true;
                        int beginIndex=Math.min(list1.get(0),list2.get(0)),endIndex;
                        if(list1.get(1)<list2.get(1)){
                            endIndex=list2.get(1);
                        }else
                            endIndex=list1.get(1);
                        lists.remove(j);
                        lists.remove(i);
                        List<Integer> list=new ArrayList<>();
                        list.add(beginIndex);
                        list.add(endIndex);
                        lists.add(list);
                        break;
                    }
                }
            }
        }

        int[][] ans=new int[lists.size()][2];
        for(int i=0;i<lists.size();i++){
            ans[i]=new int[]{lists.get(i).get(0),lists.get(i).get(1)};
        }
        return ans;
    }


}
