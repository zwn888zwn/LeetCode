
public class _206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode p1=new ListNode(-1);
        ListNode p2=head;
        while(head!=null){
            head=head.next;
            p2.next=p1.next;
            p1.next=p2;
            p2=head;
        }
        return p1.next;
    }
}
