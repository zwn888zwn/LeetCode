import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _76MinimumWindowSubstring {

    //q1左指针右移时怎么在o（n）时间内判断是否满足条件？使用formed记录字符的种类个数，使用map记录已经在窗口中字符的个数，当和T中相等时formed++
    public String minWindow(String s, String t) {
        if (s.length()==0 || t.length()==0)
            return "";

        Map<Character,Integer> tCount=new HashMap<>();
        Map<Character,Integer> sCount=new HashMap<>();
        for(int i=0;i<t.length();i++){
            int count=tCount.getOrDefault(t.charAt(i),0);
            tCount.put(t.charAt(i),count+1);
        }
        int[] ans={-1,0,-1};//minValue left right
        int left=0,right=0,uniqueChar=0,requireChar=tCount.size();
        while(left<=right&& right<=s.length()-1){
            char c=s.charAt(right);
            int count=sCount.getOrDefault(c,0);
            sCount.put(s.charAt(right),count+1);
            if(tCount.containsKey(c) && sCount.get(c).intValue()==tCount.get(c).intValue()){//没有intvalue就报错
                uniqueChar++;
            }
            while (left<=right && uniqueChar==requireChar){
                c=s.charAt(left);
                if(ans[0]==-1 || right-left+1<ans[0]){
                    ans[1]=left;
                    ans[2]=right;
                    ans[0]=ans[2]-ans[1]+1;
                }
                sCount.put(c,sCount.get(c)-1);
                if (tCount.containsKey(c) && sCount.get(c).intValue()<tCount.get(c).intValue())
                    uniqueChar--;
                left++;
            }


            right++;
        }

        return s.substring(ans[1],ans[2]+1);
    }
    public static void main(String[] args) {
        _76MinimumWindowSubstring obj=new _76MinimumWindowSubstring();
        System.out.println(obj.minWindow( "ADOBECODEBANC", "ABC"));
    }


/*   public String minWindow(String s, String t) {
        ArrayList<Word> list=new ArrayList<>();
        int lengthS=s.length(),lengthT=t.length();
        int minLen=lengthS+1;
        int left=-1,right=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(t.indexOf(Character.valueOf(c))>-1){
                if(list.size()<=lengthT){
                    Iterator<Word> iterator=list.iterator();
                    //太慢 应该用map
                    for (;iterator.hasNext();) {
                        Word word=iterator.next();
                        if(word.s==c){
                            iterator.remove();
                        }
                    }
                    list.add(new Word(i,s.charAt(i)));
                    //fixme 需要记录每个字符出现的次数
                    if(list.size()==lengthT){//滑动窗口求MIN
                        if(list.get(lengthT-1).index-list.get(0).index<=minLen){
                            left=list.get(0).index;
                            right=list.get(lengthT-1).index;
                            minLen=Math.max(minLen,right-left+1);
                        }
                    }
                }
            }
        }
        if(right==-1)
            return "";
        else
            return s.substring(left,right+1);
    }
    class Word{
        int index;
        char s;
        Word(int index,char s){
            this.index=index;
            this.s=s;
        }
    }*/
}
