package 模拟题;

import java.util.Arrays;
import java.util.Scanner;

public class al1高昂的旋律 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        String[] arr=new String[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.next();
        }
        Arrays.sort(arr);
        int[] dp=new int[256];

        for (int i=0;i<n;i++){
            String str=arr[i];
            int begin=str.charAt(0)-'a';
            int end=str.charAt(str.length()-1)-'a';
            for (int j=0;j<dp.length;j++){
                if (j<=begin){
                    dp[end]=Math.max(dp[end],dp[j]+str.length());
                }
            }
        }

        //初始化，让自己和自己接
        for (int i=0;i<n;i++){
            String str=arr[i];
            int begin=str.charAt(0)-'a';
            int end=str.charAt(str.length()-1)-'a';
            if (begin==end){
                dp[begin]-=str.length();
            }
        }

        int max=0;
        for (int i : dp) {
            max=Math.max(max,i);
        }
        System.out.println(max);

    }
}
