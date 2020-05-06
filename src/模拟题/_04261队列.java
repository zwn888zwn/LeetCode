package 模拟题;

import java.util.LinkedList;
import java.util.Scanner;

public class _04261队列 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++){
            LinkedList<Integer> linkedList=new LinkedList<>();
            int q=scan.nextInt();
            for(int j=0;j<q;j++){
                String opt=scan.next();
                if (opt.startsWith("PUSH")){
                    int val=scan.nextInt();
                    linkedList.add(val);
                }else if (opt.equals("TOP")){
                    if (linkedList.size()>0){
                        System.out.println(linkedList.get(0));
                    }else
                        System.out.println(-1);
                }else if (opt.equals("POP")){
                    if (linkedList.size()>0){
                        linkedList.remove(0);
                    }else
                        System.out.println(-1);
                }else if (opt.equals("SIZE")){
                    System.out.println(linkedList.size());
                }else if (opt.equals("CLEAR")){
                    linkedList.clear();
                }

            }

        }
    }
}
