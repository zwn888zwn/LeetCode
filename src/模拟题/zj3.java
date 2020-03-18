package 模拟题;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//a*搜索 87 字节笔试第三题
public class zj3 {
    static class Node{
        public int x;
        public int y;
        public int val=99999;
        public int allDis=0;
        public Node(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;

        }

    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int col=scan.nextInt();
        int row=scan.nextInt();
        int[][] maps=new int[row][col];
        int[][] vis=new int[row][col];
        int beginx=0,beginy=0;
        int endx=0,endy=0;
        HashMap<Integer,Node> map1=new HashMap();
        HashMap<Integer,Node> map2=new HashMap();

        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int val=scan.nextInt();
                maps[i][j]=val;
                if (val==-2){
                    beginx=i;
                    beginy=j;
                }
                if (val==-3){
                    endx=i;
                    endy=j;
                }
                if (val>0){
                    if (map1.containsKey(val)){
                        map2.put(val,new Node(i,j,0));
                    }
                    if (!map1.containsKey(val)){
                        map1.put(val,new Node(i,j,0));
                    }
                }
            }
        }
        Node node=new Node(beginx,beginy,0);
        PriorityQueue<Node> pq=new PriorityQueue<>(((o1, o2) ->o1.allDis-o2.allDis));
        pq.offer(node);
        while (!pq.isEmpty()){
            Node temp=pq.poll();
            vis[temp.x][temp.y]=1;
            if (temp.x==endx && temp.y==endy){
                System.out.println(temp.val);
                return;
            }
            if (maps[temp.x][temp.y]>0){
                //jump
                Node temp1=map1.get(maps[temp.x][temp.y]);
                if (temp1.x==temp.x && temp1.y==temp.y){
                    temp1=map2.get(maps[temp.x][temp.y]);
                }
                temp1.val=temp.val+1;
                temp1.allDis=temp1.val+ Math.abs(endx-(temp1.x-1))+Math.abs(endy-(temp1.y));
                pq.offer(temp1);
            }

            if (temp.x-1>=0 && vis[temp.x-1][temp.y]==0 && maps[temp.x-1][temp.y]!=-1){
                Node temp1=new Node(temp.x-1,temp.y,temp.val+1);
                temp1.allDis=temp1.val+ Math.abs(endx-(temp.x-1))+Math.abs(endy-(temp.y));
                pq.offer(temp1);

            }
            if (temp.x+1<row && vis[temp.x+1][temp.y]==0 && maps[temp.x+1][temp.y]!=-1){
                Node temp1=new Node(temp.x+1,temp.y,temp.val+1);
                temp1.allDis=temp1.val+ Math.abs(endx-(temp.x+1))+Math.abs(endy-(temp.y));
                pq.offer(temp1);
            }
            if (temp.y-1>=0 && vis[temp.x][temp.y-1]==0 && maps[temp.x][temp.y-1]!=-1){
                Node temp1=new Node(temp.x,temp.y-1,temp.val+1);
                temp1.allDis=temp1.val+ Math.abs(endx-(temp.x))+Math.abs(endy-(temp.y-1));
                pq.offer(temp1);
            }
            if (temp.y+1<col && vis[temp.x][temp.y+1]==0 && maps[temp.x][temp.y+1]!=-1){
                Node temp1=new Node(temp.x,temp.y+1,temp.val+1);
                temp1.allDis=temp1.val+ Math.abs(endx-(temp.x))+Math.abs(endy-(temp.y+1));
                pq.offer(temp1);
            }

        }
        System.out.println(-1);

    }
}
