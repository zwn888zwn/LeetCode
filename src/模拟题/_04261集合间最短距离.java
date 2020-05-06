package 模拟题;

import java.util.LinkedList;
import java.util.Scanner;

public class _04261集合间最短距离 { //两点最短欧氏距离
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++){
            int q=scan.nextInt();
            int[][] arrA=new int[q][2];
            int[][] arrB=new int[q][2];
            for(int j=0;j<q;j++){
                arrA[j][0]=scan.nextInt();
                arrA[j][1]=scan.nextInt();
            }
            for(int j=0;j<q;j++){
                arrB[j][0]=scan.nextInt();
                arrB[j][1]=scan.nextInt();
            }
            double minLen=Double.MAX_VALUE;
            for (int a=0;a<q;a++){
                for(int b=0;b<q;b++){
                    minLen=Math.min(minLen,Math.sqrt((arrA[a][0]-arrB[b][0])*(arrA[a][0]-arrB[b][0])+(arrA[a][1]-arrB[b][1])*(arrA[a][1]-arrB[b][1])));
                }
            }
            System.out.format("%.3f",minLen);
            System.out.println();
        }
    }
}
