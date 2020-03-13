package 模拟题;
//https://exercise.acmcoder.com/online/online_judge_ques?ques_id=1656&konwledgeId=134

import java.util.Scanner;

public class 翻转数组 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr=new int[n+2];
        for (int i=1;i<=n;i++)
            arr[i]=scan.nextInt();
        arr[0]=Integer.MIN_VALUE;
        arr[n+1]=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if (arr[i]>arr[i+1]){
                int begin=i;
                while (arr[i]>arr[i+1])
                    i++;
                int end=i;
                if (arr[begin]<arr[end+1] && arr[end]>arr[begin-1]){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                return;
            }
        }

    }
}
