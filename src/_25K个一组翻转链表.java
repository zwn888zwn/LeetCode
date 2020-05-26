public class _25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode p=head;
        int count=0;
        while(p!=null && count<k){
            count++;
            p=p.next;
        }
        ListNode res=headInsert(head,k);
        if(p!=null)
            head.next=reverseKGroup(p,k);
        return res;

    }
    //1 2 3  执行完  3 2 1 返回3
    public ListNode headInsert(ListNode head, int k){
        ListNode temp=new ListNode(-1);
        ListNode p=head,nextNode=null;
        int count=0;
        while(p!=null && count<k){
            count++;
            p=p.next;
        }
        if(count==k){
            p=head;
            count=0;
            while(p!=null && count<k){
                nextNode=p.next;
                p.next=temp.next;
                temp.next=p;

                count++;
                p=nextNode;
            }
            head.next=nextNode;
            return temp.next;

        }else{//不足k个
            return head;
        }



    }
}
