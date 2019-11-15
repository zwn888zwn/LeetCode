import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    HashMap<Integer,LRUNode> map=new HashMap<>();
    LRUNode head=new LRUNode(-1);
    LRUNode tail=new LRUNode(-1);
    int capacity;
    int now=0;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            LRUNode temp=map.get(key);
            adjustNode(temp);
            return temp.val;
        }else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            LRUNode temp=map.get(key);
            adjustNode(temp);
            temp.val=value;
        }else {
            LRUNode p=new LRUNode(key,value);
            if (head.right!=null)
             head.right.left=p;
            p.right=head.right;
            head.right=p;
            p.left=head;

            if (now<capacity){
                if (now==0)
                    tail=p;
                now++;
            }else {
                map.remove(tail.key);
                if (tail.left!=head)
                    tail=tail.left;
                else
                    tail=p;
                tail.right=null;
            }

            map.put(key,p);
        }
    }
    private LRUNode adjustNode(LRUNode p){
        //LRUNode p=map.get(key);
        if (tail==p && tail.left!=head){
            tail=tail.left;
        }
        p.left.right=p.right;
        if(p.right!=null && p.left!=head){
            p.right.left=p.left;
        }
        p.right=head.right;
        if (head.right!=null)
            head.right.left=p;
        p.left=head;
        head.right=p;
        return p;
    }
    class LRUNode{
        LRUNode(int key,int val){
            this.val=val;
            this.key=key;
        }
        LRUNode(int val){
            this.val=val;
        }
        int key;
        int val;
        LRUNode left;
        LRUNode right;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 1 /* capacity */ );
        cache.get(1);
        cache.put(2,1);
        cache.get(2);

/*        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4*/
    }
}
