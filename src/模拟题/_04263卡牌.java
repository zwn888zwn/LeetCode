package 模拟题;

import java.util.Scanner;

public class _04263卡牌 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] cardA=new int[n];
        int[] cardB=new int[n];
        for(int i=0;i<n;i++)
            cardA[i]=scan.nextInt();
        for(int i=0;i<n;i++)
            cardB[i]=scan.nextInt();
        dfs(cardA,cardB,0);

    }
    public static void dfs(int[] cardA, int[] cardB, int optCount){
        boolean notChange=true;
        for(int i=0;i<cardA.length-1;i++){
            if (cardA[i]>cardA[i+1] && cardB[i+1]<=cardB[i]){
                notChange=false;
                int temp=cardA[i];
                cardA[i]=cardB[i+1];
                cardB[i+1]=temp;
                temp=cardA[i+1];
                cardA[i+1]=cardB[i];
                cardB[i]=temp;
                dfs(cardA,cardB,optCount+1);
            }
        }
        if (notChange){
            System.out.println(optCount);
            return;
        }


    }
}
