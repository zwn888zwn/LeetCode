package 模拟题;

import java.util.Scanner;

public class 双行道1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[][] arr=new int[2][n];
        String s1=scan.next();
        String s2=scan.next();
        for (int i=0;i<n;i++){
            if (s1.charAt(i)=='X')
                arr[0][i]=1;
            if (s2.charAt(i)=='X')
                arr[1][i]=1;
        }
        long[][] dp=new long[2][n];
        dp[0][0]=arr[0][0]==0?1:0;
        dp[1][0]=arr[1][0]==0?1:0;
        for (int i=1;i<n;i++){
            if (arr[0][i]==0){
                dp[0][i]=dp[0][i-1]+dp[0][i];
                dp[0][i]=dp[1][i-1]+dp[0][i];
            }
            if (arr[1][i]==0){
                dp[1][i]=dp[1][i-1]+dp[1][i];  //往右走
                dp[1][i]=dp[0][i-1]+dp[1][i];
            }
        }


        System.out.println(dp[1][n-1]);


    }
}
/*

双行道
        时间限制：C/C++语言 1000MS；其他语言 3000MS
        内存限制：C/C++语言 65536KB；其他语言 589824KB
        题目描述：
        有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：

        1． 向右走一格，即从(x,y)到(x,y+1);

        2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);

        3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);



        问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。

        输入
        输入第一行仅包含一个正整数n，表示网格的长度。(1<=n<=50)

        接下来有2行,每行有n个字符，“X”代表障碍物，“.”代表可以停留。

        输出
        如果没有可以到达的路线则输出-1，否则输出方案数量。


        样例输入
        5
        ..X.X
        XX...
        样例输出
        2*/
