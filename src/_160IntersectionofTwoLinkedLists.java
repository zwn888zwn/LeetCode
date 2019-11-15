public class _160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=getLength(headA);
        int lenB=getLength(headB);
        int temp;
        if (lenA>lenB){
            temp=lenA-lenB;
            while (temp>0){
                headA=headA.next;
                temp--;
            }
        }else {
            temp=lenB-lenA;
            while (temp>0){
                headB=headB.next;
                temp--;
            }

        }
        ListNode ans=null;
        int lastVal1=-1,lastVal2=-1;
        while (headA!=null && headB!=null ){
            if (headA.val!=headB.val){//为0不可以为头
                ans=null;
            }else if (ans==null&&headA.val==headB.val && !(lastVal1==0 || lastVal2==0)) {
                ans=headA;
            }
            lastVal1=headA.val;
            lastVal2=headB.val;
            headA=headA.next;
            headB=headB.next;
        }
        return ans;
    }
    public int getLength(ListNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
}
