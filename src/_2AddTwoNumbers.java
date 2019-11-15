import java.math.BigInteger;

public class _2AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result =new ListNode(-1);
        ListNode p=result,q;
        int isCarry=0;
        while(l1!=null && l2!=null){
            if(l1.val+l2.val+isCarry>9){
                p.next=new ListNode(l1.val+l2.val+isCarry-10);
                isCarry=1;
            }else{
                p.next=new ListNode(l1.val+l2.val+isCarry);
                isCarry=0;
            }
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            if(l1.val+isCarry>9){
                p.next=new ListNode(l1.val+isCarry-10);
                isCarry=1;
            }else {
                p.next=new ListNode(l1.val+isCarry);
                isCarry=0;
            }
            p=p.next;
            l1=l1.next;
        }
        while(l2!=null){
            if(l2.val+isCarry>9){
                p.next=new ListNode(l2.val+isCarry-10);
                isCarry=1;
            }else {
                p.next=new ListNode(l2.val+isCarry);
                isCarry=0;
            }
            p=p.next;
            l2=l2.next;
        }
        if(isCarry==1){
            p.next=new ListNode(1);
        }

        return result.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        while(l1!=null){
            sb1.append(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            sb2.append(l2.val);
            l2=l2.next;
        }
        BigInteger num1=new BigInteger(sb1.reverse().toString());
        BigInteger num2=new BigInteger(sb2.reverse().toString());
        BigInteger num3=num1.add(num2);
        StringBuffer result=new StringBuffer(num3.toString());
        ListNode resultNode=new ListNode(-1);
        ListNode p=resultNode;
        for(int i=result.length()-1;i>=0;i--){
            p.next=new ListNode(result.charAt(i)-'0');
            p=p.next;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
/*        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        l2.next.next.next=new ListNode(5);
        ListNode result=addTwoNumbers(l1,l2);*/

        ListNode l1=new ListNode(9);
        l1.next=new ListNode(9);
        l1.next.next=new ListNode(9);
        ListNode l2=new ListNode(1);
        ListNode result=addTwoNumbers2(l1,l2);
        System.out.println("");
    }
}

// * Definition for singly-linked list.
   class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
