public class _32LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int[] dp=new int[s.length()];
        //dp[i]从i往左最大子串长度
        int result=0;
        for(int i=1;i<dp.length;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i-1>0?dp[i-2]:0)+2;
                }
                else if( i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
                    dp[i]=dp[i-1]+2+ ((i-dp[i-1]-2)>=0?dp[i-dp[i-1]-2]:0);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }

    //和穷举差不多 不行
    //227 / 230 test cases passed.
    //Status: Memory Limit Exceeded
    //Time complexity : O(n^3)
    //Space complexity : O(n^2)
    public int longestValidParentheses2(String s) {
        //p[a][b]=max{xx+[a+2][b],[a][b-2]xx, x[a+1][b-1]x }
        int[][] dp=new int[s.length()+1][s.length()+1];
        //init a a+1?2:0
        int result=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
               dp[i][i+1]=2;
               result=2;
            }
        }
        for(int subLen=4;subLen<=s.length();subLen+=2){

            //自己部分
            for(int a=0;a+subLen<=s.length();a++){
                int maxLen=0;
                if(s.charAt(a)=='(' && s.charAt(a+1)==')' && dp[a+2][a+subLen-1]>0)
                    maxLen=Math.max(maxLen,dp[a+2][a+subLen-1]+2);
                if( s.charAt(a+subLen-2)=='(' && s.charAt(a+subLen-1)==')' && dp[a][a+subLen-3]>0)
                    maxLen=Math.max(maxLen,dp[a][a+subLen-3]+2);
                if(s.charAt(a)=='(' && s.charAt(a+subLen-1)==')' && dp[a+1][a+subLen-2]>0)
                    maxLen=Math.max(maxLen,dp[a+1][a+subLen-2]+2);


                //和别人组合部分 a mid  +  mid+1
                for(int mid=a+1;mid+2<a+subLen;mid++){
                    if (dp[a][mid]>0 &&dp[mid+1][a+subLen-1]>0 )
                     maxLen=Math.max(maxLen,dp[a][mid]+dp[mid+1][a+subLen-1]);
                }

                dp[a][a+subLen-1]=maxLen;
                result=Math.max(result,maxLen);
            }


        }

        return result;
    }

    public static void main(String[] args) {
        _32LongestValidParentheses obj=new _32LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(")()())"));

    }
}
