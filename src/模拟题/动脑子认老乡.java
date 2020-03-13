package 模拟题;
//https://exercise.acmcoder.com/online/online_judge_ques?ques_id=9579&konwledgeId=137
import java.util.*;

public class 动脑子认老乡 {
    static int res=0;

    private static class Node{
        int id;
        Node next;
        public Node(int id){
            this.id=id;
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            int m=scan.nextInt();

            int[] visit=new int[n+1];
            Node[] head=new Node[n+1];
            res=-1;
            //init
            for (int i=1;i<=n;i++){
                Node temp=new Node(i);
                head[i]=temp;
            }
            //readData
            for(int i=0;i<m;i++){
                int a=scan.nextInt();
                int b=scan.nextInt();
                int c=scan.nextInt();
                if (c==1){
                    //add b to a
                    Node temp=new Node(b);
                    temp.next=head[a].next;
                    head[a].next=temp;
                    //add a to b
                    temp=new Node(a);
                    temp.next=head[b].next;
                    head[b].next=temp;
                }
            }

            dfs(1,head,visit);
            System.out.println(res);
            //end while
        }
    }
    public static void dfs(int begin,Node[] head , int[] visit){
        Node p=head[begin];
        if (visit[p.id]==0){
            res++;
            visit[p.id]=1;
            p=p.next;
            while (p!=null){
                if (visit[p.id]==0){
                    dfs(p.id,head,visit);
                }
                p=p.next;
            }
        }else {
            return;
        }


    }

}
