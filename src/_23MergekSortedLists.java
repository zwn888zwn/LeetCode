import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node!=null)
                pq.offer(node);
        }
        ListNode head=new ListNode(-1);
        ListNode now=head;
        while (!pq.isEmpty()){
            ListNode temp=pq.poll();
            now.next=temp;
            now=now.next;
            if (temp.next!=null){
                temp=temp.next;
                pq.offer(temp);
            }

        }


        return head.next;
    }


}
