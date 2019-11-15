public class _19RemoveNthNodeFromEndofList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode=new ListNode(-1);
        headNode.next=head;
        recursion(headNode,n,0);
        return headNode.next;
    }
    //1->2->3->4->5, and n = 2.
    //1->2->3->5.
    public int recursion(ListNode head, int n,int lvl){
        int position=0;
        if(head.next==null){
            return lvl-n;
        }else {
            //3 connect 5
            position=recursion(head.next,n,lvl+1);
            if(position== lvl){
                if (head.next.next!=null){// 5-2=3
                    head.next=head.next.next;
                }else {//5-1=4
                    head.next=null;
                }

            }
        }

        return position;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        new _19RemoveNthNodeFromEndofList().removeNthFromEnd(node1,2);

        System.out.println("11");


    }
}
