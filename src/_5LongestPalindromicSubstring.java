import java.util.Arrays;

public class _5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0)
            return "";
        boolean[][] isPalindromic=new boolean[n+1][n+1];//[begin][end]
        for(int i=0;i<n+1;i++){
            isPalindromic[i][i]=true;
            isPalindromic[i][1]=true;
            isPalindromic[i][0]=true;
            if (i<n)
                isPalindromic[i+1][i]=true;
        }
        int record1=0,record2=1;
        for(int subStrLen=1;subStrLen<=n;subStrLen++){
            for(int beginIndex=0;beginIndex+subStrLen<=n;beginIndex++){
                if(beginIndex+subStrLen-2>=0 && (  isPalindromic[beginIndex+1][beginIndex+subStrLen-2] )&& (s.charAt(beginIndex)==s.charAt(beginIndex+subStrLen-1))){
                    isPalindromic[beginIndex][beginIndex+subStrLen-1]=true;
                    record1=beginIndex;
                    record2=subStrLen;
                }
            }
        }
        return s.substring(record1,record1+record2);
    }

    public static void main(String[] args) {
        System.out.println( new _5LongestPalindromicSubstring().longestPalindrome("dddddddd"));
    }
}
