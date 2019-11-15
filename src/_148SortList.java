public class _148SortList {
    //归并排序
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null)//单个节点停止递归
            return head;
        ListNode mid=getMid(head);
        head=sortList(head);
        mid=sortList(mid);
        return merge(head,mid);
    }

    private ListNode merge(ListNode head, ListNode mid) {
        ListNode headNode = new ListNode(-1);
        ListNode p=headNode;
        while (head!=null && mid!=null){
            if (head.val<mid.val){
                p.next=head;
                p=p.next;
                head=head.next;
            }else {
                p.next=mid;
                p=p.next;
                mid=mid.next;
            }
        }
        while (head!=null){
            p.next=head;
            p=p.next;
            head=head.next;
        }
        while (mid!=null){
            p.next=mid;
            p=p.next;
            mid=mid.next;
        }
        return headNode.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow=head;
        ListNode fast=null;
        if (head!=null) //如果为null 单节点
            fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;//断开
        return fast;
    }

    public static void main(String[] args) {
        _148SortList obj=new _148SortList();
        ListNode n1=new ListNode(4);
        ListNode n2=new ListNode(2);n1.next=n2;
        ListNode n3=new ListNode(1);n2.next=n3;
        ListNode n4=new ListNode(3);n3.next=n4;
        obj.sortList(n1);
        System.out.println("1");
    }
}
