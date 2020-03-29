import java.util.Stack;

public class _739每日温度 {
    //kmp思想 利用已经保存的
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        for(int i=T.length-2;i>=0;i--){
            int point=i+1;
            while (T[i]>=T[point] && res[point]>0){
                point+=res[point];
            }
            if (T[i]<T[point])
                res[i]=point-i;
        }
        return res;
    }

    //stack 单调栈 处理单调增
    public int[] dailyTemperatures2(int[] T) {
        int[] res=new int[T.length];
        class Node{//不需要创建对象，只保存下标，也能知道值
            int p;
            int val;
            public Node(int p,int val){
                this.p=p;
                this.val=val;
            }
        }
        Stack<Node> stack=new Stack();
        stack.push(new Node(-1,999));//init
        for(int i=0;i<T.length;i++){
            while (stack.peek().val<T[i]){
                Node temp=stack.pop();
                res[temp.p]=i-temp.p;
            }
            stack.push(new Node(i,T[i]));
        }
        return res;
    }
}
