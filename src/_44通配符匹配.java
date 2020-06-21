import javafx.beans.binding.MapExpression;

import java.util.HashMap;

public class _44通配符匹配 {
    //1000ms 超出时间限制 带状态记录的递归
    public static HashMap<String,Boolean> save=new HashMap<>();
    public static boolean isMatch(String s, String p) {
        String key = s.length() + "l" + p.length();
        if (save.containsKey(key)){
            return save.get(key);
        }
        if (s.equals(p)){
            return true;
        }else if (p.length()==0){
            return false;
        }else if (s.length()==0){
            for(int i=0;i<p.length();i++){
                if (p.charAt(i)!='*')
                    return false;
            }
            return true;
        }
        if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?' ){
            return isMatch(s.substring(1),p.substring(1));
        }
        if (p.charAt(0)=='*'){
            boolean result=false;
            int star=0;
            for (;star+1<p.length();star++){//last *
                if (p.charAt(star+1)!='*'){
                    break;
                }
            }
            for(int i=0;i<=s.length();i++){
                result= result||isMatch(s.substring(i),p.substring(star+1));
            }
            save.put(key,result);
            return result;
        }
        save.put(key,false);
        return false;
    }
    //dp
    public static boolean isMatch1(String s, String p) {
        boolean[][] dp=new boolean[p.length()+1][s.length()+1];
        dp[0][0]=true;

        for(int i=1;i<=p.length();i++){
            char pChar=p.charAt(i-1);
            if (pChar=='*') dp[i][0]=dp[i-1][0];//针对*，匹配0个直接从上取值
            for (int j=1;j<=s.length();j++){
                char sChar=s.charAt(j-1);
                if (pChar==sChar || pChar=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (pChar=='*'){
                    //匹配0个 、多个、 1个
                    dp[i][j] = dp[i][j] ||dp[i-1][j]||dp[i][j-1] || dp[i-1][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch1("adceb","*a*b"));
    }
}
