package 模拟题;

import java.util.Scanner;
import java.util.Stack;

public class _04263两个栈实现队列 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        Stack<Integer> stackA=new Stack<>();
        Stack<Integer> stackB=new Stack<>();
        for (int i=0;i<t;i++){
            String opt=scan.next();
            if (opt.startsWith("add")){
                int val=scan.nextInt();
                stackA.push(val);
            }else if (opt.equals("peek")){
                if (stackB.isEmpty()){
                    while (!stackA.isEmpty()){
                        stackB.push(stackA.pop());
                    }
                }
                System.out.println(stackB.peek());
            }else if (opt.equals("poll")){
                if (stackB.isEmpty()){
                    while (!stackA.isEmpty()){
                        stackB.push(stackA.pop());
                    }
                }
                stackB.pop();
            }
        }


    }
}
