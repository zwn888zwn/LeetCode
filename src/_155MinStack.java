public class _155MinStack {
}
class MinStack{
    private class StackNode{
        int val;
        int min;
        StackNode next;
    }
    private StackNode head;

    /** initialize your data structure here. */
    public MinStack() {
        head=new StackNode();
    }

    public void push(int x) {
        StackNode temp=new StackNode();
        temp.val=x;
        if (head.next==null){
            temp.min=x;
        }else {
            temp.min=Math.min(head.next.min,x);
        }
        //add node
        temp.next=head.next;
        head.next=temp;
    }

    public void pop() {
        head.next=head.next.next;
    }

    public int top() {
        return head.next.val;
    }

    public int getMin() {
        return head.next.min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */