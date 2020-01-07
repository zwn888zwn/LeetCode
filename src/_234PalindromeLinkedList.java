public class _234PalindromeLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //1 2 3 4 3 2 1
    public boolean isPalindrome(ListNode head) {
        //1计算长度
        int length=0;
        ListNode p=head;
        while (p!=null){
            p=p.next;
            length++;
        }
        //2 后半部分逆转
        ListNode mid=head;
        p=head;//快慢指针
        while (p!=null && p.next!=null){
            mid=mid.next;
            p=p.next.next;
        }
        if (length%2!=0) mid=mid.next;

        ListNode newMid=new ListNode(-1);
        for (int i=0;i<length/2;i++){//头插法逆转后半部分
            p=mid.next;
            mid.next=newMid.next;
            newMid.next=mid;
            mid=p;
        }
        //3 头和中间同时遍历
        newMid=newMid.next;
        while(newMid!=null){
            if (newMid.val!=head.val)
                return false;
            newMid=newMid.next;
            head=head.next;
        }
        return true;
    }
}
