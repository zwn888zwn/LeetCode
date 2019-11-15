import java.util.HashSet;

public class _141LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet<>();
        while(head!=null){
            if (set.contains(head))
                return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }
    //快慢指针法
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            if (fast.next!=null)
                fast=fast.next.next;
            else
                return false;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
