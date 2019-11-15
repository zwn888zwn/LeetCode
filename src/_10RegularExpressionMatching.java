import java.util.ArrayList;
import java.util.List;

public class _10RegularExpressionMatching {
    /*s = "aab"
    p = "c*a*b" */
    public boolean isMatch(String s, String p) {
        if(  s.length()==0 && p.length()==0){
            return true;
        }
        if(p.length()==0)
            return false;

        return check(s,findPattern(p),0);
    }
    public boolean check(String s,List<String> pattern,int now){

        if(now>=pattern.size() ){
            if ( s.length()>0)
                return false;
            return true;
        }
        if(s.length()==0){
            //when s is "" but pattern only have  X* return true

            if(now == pattern.size()-1 && pattern.get(now).length()==2 &&pattern.get(now).charAt(1)=='*'){
                return true;
            }

                boolean checkSNull=true;
                for(int i=now;i<pattern.size();i++){
                    String temp=pattern.get(i);
                    if(temp.length()==2 &&temp.charAt(1)=='*')
                        continue;
                    else {
                        checkSNull=false;
                        break;
                    }
                }
                if (checkSNull)
                    return true;



            return false;
        }

        String pat=pattern.get(now);
        //checkHead
        //case  X*
        if(pat.charAt(pat.length()-1)=='*'){
            if(pat.charAt(0)=='.'){
                for(int i=0;i<s.length();i++){
                    if (check(s.substring(i+1),pattern,now+1))
                        return true;
                }
                //or all
                if (check("",pattern,now+1))
                    return true;
                //or .* 0次
                if (check(s,pattern,now+1))
                    return true;
            }else{
                char repChar=pat.charAt(0);
                boolean isPass=true;
                int sameLength=0;
                for(int i=0;i<s.length();i++){
                    //todo 多次的前提是相同
                    if(s.charAt(i)==repChar && isPass){
                        if(check(s.substring(i),pattern,now+1))
                            return true;
                        sameLength++;
                    }
                    if(s.charAt(i)!=repChar){
                        isPass=false;
                        // 考虑0次和多次
                    }
                    //多次
                    //aaaX
                    //a*X

                }
                //最长多次相同
                if(check(s.substring(sameLength),pattern,now+1))
                    return true;
                //0次
                if( check(s,pattern,now+1))
                    return true;
                //字符串全通过
                //fixed 有问题
/*                if(isPass)
                    return true;*/
            }

        }else{
            //case normal str
            //ba    .c
            boolean isPass=true;
            if(s.length()>=pat.length())
                for(int i=0;i<pat.length();i++){
                    if ((pat.charAt(i)=='.'))
                        continue;
                    if( s.charAt(i)!=pat.charAt(i)){
                        isPass=false;
                    }
                }
            if(isPass && s.length()>=pat.length())
                if(check(s.substring(pat.length()),pattern,now+1))
                    return true;
        }

        return false;
    }


    public List<String> findPattern(String p){
        List<Integer> starIndex=new ArrayList<>();
        List<String> pattern=new ArrayList<>();
        int start=0;
        while(true){
            int find=p.indexOf("*",start);
            if(find==-1){
                break;
            }
            starIndex.add(find);
            start=find+1;
        }

        //System.out.println(starIndex.size());

        for(int i=0;i<starIndex.size();i++){
            if (starIndex.get(i)==1){
                pattern.add(p.substring(0,2));
            }else{
                if(i==0){
                    pattern.add(p.substring(0,starIndex.get(i)-1));
                    pattern.add(p.substring(starIndex.get(i)-1,starIndex.get(i)+1));
                }else {
                    int lastStarIndex=starIndex.get(i-1);
                    int currStarIndex=starIndex.get(i);
                    if(currStarIndex-lastStarIndex<=2){
                        pattern.add(p.substring(currStarIndex-1,currStarIndex+1));
                    }else{
                        pattern.add(p.substring(lastStarIndex+1,currStarIndex-1));
                        pattern.add(p.substring(currStarIndex-1,currStarIndex+1));
                    }
                }
            }
        }
        //最后*部分
        if(starIndex.size()>=1 && starIndex.get(starIndex.size()-1)< p.length()-1){
            pattern.add(p.substring(starIndex.get(starIndex.size()-1)+1));
        }

        if(pattern.size()==0){
            pattern.add(p);
        }
        //System.out.println(pattern.size());
        return pattern;
    }

    //答案1 递归

    public boolean isMatch2(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||  //*-  0次匹配
                    (first_match && isMatch(text.substring(1), pattern))); //*-多次匹配
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));//普通字符串匹配
        }
    }

    //答案二 DP 自顶向下   有最优子结构
    // 与上面基本相同使用memo数组缓存了结果，避免重复执行
    enum Result {
        TRUE, FALSE
    }
    Result[][] memo;
    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    //答案3 DP自底向上
    public boolean isMatch3(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));  //第一个字符是否相等
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){//第二个是*
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];// case 1忽视  case2 继续匹配
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];//继续匹配
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        _10RegularExpressionMatching obj=new _10RegularExpressionMatching();
/*        System.out.println(obj.isMatch("aa","a"));
        System.out.println(obj.isMatch("aa","a*"));
        System.out.println(obj.isMatch("ab",".*"));
        System.out.println(obj.isMatch("aab","c*a*b"));
        System.out.println(obj.isMatch("mississippi","mis*is*p*."));*/
        System.out.println(obj.isMatch("abcaaaaaaabaabcabac",".*ab.a.*a*a*.*b*b*"));

        //obj.findPattern("");
    }

}
