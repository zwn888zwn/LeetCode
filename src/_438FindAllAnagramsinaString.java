import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438FindAllAnagramsinaString {
    //Runtime: 8 ms, faster than 75.91%
    //搞个数组，里面统计26个字母还需匹配次数 再搞个计数器，记录还需匹配数
    //滑动数组，如果第一个是匹配过的+1 如果不是拉倒
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if (p.length()>s.length())
            return res;

        int[] left=new int[26];
        for (int i=0;i<p.length();i++)
            left[p.charAt(i)-'a']++;
        int[] copyOfLeft=Arrays.copyOf(left,left.length);
        //1初始化
        int index=0;
        int count=p.length();
        char first=s.charAt(0);
        for (;index<p.length();index++){
            if (copyOfLeft[s.charAt(index)-'a']>0){
                left[s.charAt(index)-'a']--;
                count--;
            }
        }
        if (count==0&&checkLeft(left))
            res.add(0);

        //2循环滑动数组
        index=1;
        for (;index+p.length()-1<s.length();index++){
            if (copyOfLeft[first-'a']>0){
                left[first-'a']++;
                count++;
            }
            if (copyOfLeft[s.charAt(index+p.length()-1)-'a']>0){
                left[s.charAt(index+p.length()-1)-'a']--;
                count--;
            }
            if (count==0&&checkLeft(left))
                res.add(index);

            first=s.charAt(index);
        }

        return res;
    }

    private boolean checkLeft(int[] left) {
        for (int i : left) {
            if (i!=0)
                return false;
        }
        return true;
    }

    //别人的代码4ms,思路基本相同，但是优雅一些
    public List<Integer> findAnagrams1(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int[] count = new int[26];

        for (int i = 0; i < p.length(); ++i) {
            count[p.charAt(i) - 'a'] ++; //nice想法 简洁
            count[s.charAt(i) - 'a'] --;
        }

        for (int i = 0, j = i + p.length(); ; i++, j++) {
            boolean isValid = true;
            for (int value: count) {
                if (value != 0) {
                    isValid = false;
                }
            }

            if (isValid) {
                result.add(i);
            }

            if (j >= s.length()) {
                break;
            }

            count[s.charAt(i) - 'a']++;
            count[s.charAt(j) - 'a']--;
        }

        return result;
    }
    public static void main(String[] args) {
        _438FindAllAnagramsinaString obj=new _438FindAllAnagramsinaString();
        System.out.println(obj.findAnagrams("abacbabc","abc"));
    }
}
