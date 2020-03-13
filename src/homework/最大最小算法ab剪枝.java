package homework;

import java.util.Scanner;

public class 最大最小算法ab剪枝 {
    //3子棋
    final int maxDepth=2;
    final int SIZE=3;
    int[][] arr=new int[SIZE][SIZE];
    int count=0;
    final int MAX_VAL=100,MIN_VAL=-100;


    private class TempNode{
        int val;
        int x;
        int y;
        public TempNode(int val){
            this.val=val;
        }
        public TempNode(){
        }
    }

    public TempNode  dfs(int dp,int alpha,int beta){
        if (dp==maxDepth || count==SIZE*SIZE){
            TempNode node=new TempNode(getValue(arr,dp));
            return node;
        }
        int x=-1,y=-1;
        for (int i=0;i<SIZE;i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j]==0){
                    arr[i][j]=dp%2==0?1:2;
                    count++;
                    TempNode node=dfs(dp+1,alpha,beta);
                    //返回时更新ab？
                    if (dp%2==0){//max a 同时记录最值坐标点
                        if (alpha<node.val){
                            alpha=node.val;
                            x=i;
                            y=j;
                        }
                        if (node.val>=beta){ //ab剪枝
                            arr[i][j]=0;
                            return new TempNode(node.val);
                        }


                    }else {//min b
                        if (beta>node.val){
                            beta=node.val;
                            x=i;
                            y=j;
                        }
                        if (node.val<=alpha){
                            arr[i][j]=0;
                            return new TempNode(node.val);
                        }

                    }
                    arr[i][j]=0;
                    count--;

                }
            }
        }
        TempNode node=new TempNode();
        node.x=x;
        node.y=y;
        node.val=dp%2==0?alpha:beta;
        return node;

    }

    /**
     *
     * @param arr
     * @return 把空格全部填上Mark后 满足3个连一起的个数
     */
    private int getValue(int[][] arr,int dp) {
        int mark=dp%2==0?2:1,count=0;

        for (int i=0;i<SIZE;i++){
            if ((arr[i][0]==0 || arr[i][0]==mark ) &&(arr[i][1]==0 || arr[i][1]==mark )&&(arr[i][2]==0 || arr[i][2]==mark )){
                count++;
            }
            if ((arr[0][i]==0 || arr[0][i]==mark ) &&(arr[1][i]==0 || arr[1][i]==mark )&&(arr[2][i]==0 || arr[2][i]==mark )){
                count++;
            }
            if ((arr[i][0]==1 ) &&(arr[i][1]==1 )&&(arr[i][2]==1 ) || (arr[0][i]==1 ) &&(arr[1][i]==1 )&&( arr[2][i]==1 )){
                return 50;//win
            }
            if ((arr[i][0]==2 ) &&(arr[i][1]==2 )&&(arr[i][2]==2 ) || (arr[0][i]==2 ) &&(arr[1][i]==2 )&&( arr[2][i]==2 )){
                return -50;
            }
        }
        //斜
        if (((arr[0][0]==1 ) &&(arr[1][1]==1)&&(arr[2][2]==1))||((arr[0][2]==1) &&(arr[1][1]==1  )&&(arr[2][0]==1))){
            return 50;
        }
        if (((arr[0][0]==1 ) &&(arr[1][1]==1)&&(arr[2][2]==1))||((arr[0][2]==1) &&(arr[1][1]==1  )&&(arr[2][0]==1))){
            return -50;
        }
        if ((arr[0][0]==0 || arr[0][0]==mark ) &&(arr[1][1]==0 || arr[1][1]==mark )&&(arr[2][2]==0 || arr[2][2]==mark )){
            count++;
        }
        if ((arr[0][2]==0 || arr[0][2]==mark ) &&(arr[1][1]==0 || arr[1][1]==mark )&&(arr[2][0]==0 || arr[2][0]==mark )){
            count++;
        }

        return mark==1?count:-count;

    }


    public void print(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print("|");
                if (arr[i][j]==0)
                    System.out.print(" ");
                else if (arr[i][j]==1)
                    System.out.print("O");
                else
                    System.out.print("X");
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        最大最小算法ab剪枝 obj=new 最大最小算法ab剪枝();
        obj.arr[1][1]=1;
/*        obj.arr[0][0]=2;
        obj.arr[0][1]=1;
        obj.arr[0][2]=1;
        obj.arr[2][0]=2;
        obj.arr[2][1]=2;*/
        obj.count=1;
        obj.print();
     //   TempNode node=obj.dfs(0,obj.MIN_VAL,obj.MAX_VAL);

        Scanner scan=new Scanner(System.in);
        while (obj.count<9){
            System.out.println("请输入坐标");
            int x=scan.nextInt();
            int y=scan.nextInt();
            obj.count++;
            if (obj.arr[x][y]==0){
                obj.arr[x][y]=2;
                TempNode node=obj.dfs(0,obj.MIN_VAL,obj.MAX_VAL);
                if (obj.arr[node.x][node.y]==0){
                    obj.arr[node.x][node.y]=1;
                    obj.count++;
                    if(obj.getValue(obj.arr,0)>=50){
                        System.out.println("you lose");
                        obj.print();
                        return;
                    }
                }
                else{
                    if (obj.getValue(obj.arr,0)<=-50)
                        System.out.println("you win!");
                    else
                        System.out.println("平局");
                }

                obj.print();
            }else {
                System.out.println("非法输入");
            }


        }

    }

}
