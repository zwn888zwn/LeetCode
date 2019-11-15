public class _72EditDistance {
    //    h o r s e     j行i列
    //  r 1 2 2 4 5
    //  o 2 1 3 3 4
    //  s 3 3 2 2 4

    public int minDistance(String word1, String word2) {
        if(word2.length()>word1.length()){
            String temp=word1;
            word1=word2;
            word2=temp;
        }

        int l1=word1.length(),l2=word2.length();
        if(l1==0||l2==0)
            return Math.max(l1,l2);

        //dp ij 表示 j对应i需要的代价
        int[][] dp=new int[l2+1][l1+1];
        //init 计算第一个字母对应代价
        for(int i=1;i<=l1;i++)
            dp[1][i]=(word1.charAt(i-1)==word2.charAt(0)?0:1)+i-1;
        //init 边界0值
        for(int j=1;j<=l2;j++)
            dp[j][0]=j;
        //计算dp ij ij相等？ MIN（dp【t，j-1】+ i-t  t《=i）只管左边对应
        //最后右边再加上需要删除的距离 求max（dp【t，j】 t《=l1）
        for(int i=2;i<=l2;i++){
            for(int j=1;j<=l1;j++){
                int min=9999999;
                int eq=(word1.charAt(j-1)==word2.charAt(i-1)?0:1);
                for(int t=j-1;t>=0;t--){
                    min=Math.min(min,dp[i-1][t]+j-t-1+eq);//删除或者替换的情况
                }                               // sea eat   =>seat
                min=Math.min(min,dp[i-1][j]+1);//* 最后才补充的，对应添加字符的情况
                dp[i][j]=min;
            }
        }
        //adjust
        for(int i=0;i<dp[0].length;i++)
            dp[word2.length()][word1.length()-i]+=i;
        //findMin
        int min=9999999;
        for(int i=0;i<dp[0].length;i++)
            min=Math.min(min,dp[word2.length()][i]);
        return min;
    }

    public static void main(String[] args) {
        _72EditDistance obj=new _72EditDistance();
        obj.minDistance("prosperity","properties");
    }
}

