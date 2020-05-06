package 模拟题;

import java.util.Scanner;

public class _04265第K层祖先 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for (int i=0;i<t;i++){
            long x=scan.nextLong();
            int k=scan.nextInt();
            int xLvl= (int) (Math.ceil(Math.log(x)/Math.log(2)));
            if (k>=xLvl){
                System.out.println(-1);
                continue;
            }
            for (int j=0;j<xLvl-k;j++)
                x=x/2;
            System.out.println(x>0?x:-1);
        }
    }
}
