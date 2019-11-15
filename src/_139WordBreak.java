import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class _139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }



    /*List<SearchNode> list=new ArrayList<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String sub : wordDict) {
            search(s,sub);
        }
        Collections.sort(list);
        return recursive(0,s.length(),0);
    }
    //TM
    public void search(String main,String sub){
        boolean isTrue;
        for(int i=0;i<=main.length()-sub.length();i++){
            int mainP=i;
            isTrue=true;
            for(int j=0;j<sub.length();j++){
                if (main.charAt(mainP)==sub.charAt(j))
                    mainP++;
                else {
                    isTrue=false;
                    break;
                }

            }
            if (isTrue)
                list.add(new SearchNode(i,i+sub.length()-1));
        }

    }

    public boolean recursive(int nowIndex,int sSize,int needIndex){
        if (sSize==needIndex)
            return true;
        for (int i=nowIndex;i<list.size();i++){
            if(list.get(i).begin==needIndex){
                if (recursive(i+1,sSize,list.get(i).end+1))
                    return true;
            }else if (list.get(i).begin>needIndex){
                return false;
            }
        }
        return false;
    }




    class SearchNode implements Comparable<SearchNode>{
        int begin;
        int end;
        public SearchNode(int begin,int end){
            this.begin=begin;
            this.end=end;
        }

        @Override
        public int compareTo(SearchNode o) {
            if (this.begin!=o.begin)
                return this.begin-o.begin;
            else
                return this.end-o.end;
        }
    }
*/
    public static void main(String[] args) {
        _139WordBreak obj=new _139WordBreak();
        List<String> sub= Arrays.asList(new String[]{"leet","code"});
        System.out.println(obj.wordBreak("leetcode",sub));
    }
}
