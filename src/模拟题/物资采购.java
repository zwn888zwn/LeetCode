package 模拟题;

        import java.util.*;

public class 物资采购 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int k=scan.nextInt();
        int[] arr=new int[n];
        int[][] path=new int[n][n];
        for (int i=0;i<n;i++)
            arr[i]=scan.nextInt();
        for (int i=0;i<n;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            path[a-1][b-1]=1;
            path[b-1][a-1]=1;

        }
        //bfs
        for(int i=0;i<n;i++){
            System.out.print(bfs(i,n,k,arr,path));
        }


    }
    public static int bfs(int begin,int n,int k,int[] arr,int[][] path){
        int[] yuanliao=new int[k]; //k种原料齐不齐
        int count=0;//原料数统计
        int cost=0;
        int[] visited=new int[n];
        int[] level=new int[n];
        int tempLevel=1;
        Queue<Integer> queue=new LinkedList();
        queue.offer(begin);
        while (!queue.isEmpty()){
            int p=queue.poll();
            visited[begin]=1;
            if (yuanliao[arr[p]-1]==0){
                count++;
                yuanliao[arr[p]-1]=1;
                cost+=level[p];
            }
            if (count==k)
                return cost;

            for (int i=0;i<n;i++){
                if (path[p][i]==1 &&  visited[i]==0 ){
                    queue.offer(i);
                    level[i]=tempLevel;
                }
            }
            tempLevel++;
        }

        return cost;

    }

}

/*
* 物资采购
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
某公司要建厂投产一种产品，已知该产品共需要k种不同的原材料才能生产，而在这个工厂周围有n个可供建厂的地址，同时这n个位置都生产该产品所需k种原材料中的一种，在这n个位置间存在一些通行的道路，我们可以视这些道路的长度都为1，保证这些位置之间两两都是连通的。

很显然工厂面临一个很严峻的问题，就是原料采集，我们定义采集一种原材料的花费为工厂所在位置到最近的一个该材料的采集点的距离，在一个位置建厂的成本为k种原材料的采集花费之和。

请你对每一个位置都求出其建厂的花费。

输入
输入第一行有三个正整数n,m,k，分别代表可供选择的建厂地址数量，编号为从1到n，这些地址之间的道路数量，生产所需的原材料数量，编号为1到k。(1<=n,m,<=50000,1<=k<=100)

输入第二行包含n个正整数，第 i 个正整数a_i表示第i个地址是第a_i种原料的采集点。(1<=a_i<=k)

接下来有m行，每行有两个正整数 u，v，表示u号位置和v号位置之间有一条连接的路径，可能存在重边或自环（如样例所示）。

输出
输出包含 n 行，每行一个正整数，第 i 行表示第个位置的建厂成本。


样例输入
5 5 3
1 1 2 3 1
1 4
2 4
3 4
4 5
4 3
样例输出
3 3 3 2 3
*
*
*
*小仓的射击练习1
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
小仓酷爱射击运动。今天的小仓会进行N轮射击，已知第i次射击，她击中靶心的概率是a[i] -1 。

小仓想知道N轮射击后，偏离靶心次数为 0 ,1 ,2 次的概率分别是多少。

输入
第一行一个数N，代表射击轮数。

第二行 N个数a[i]，第 i个数为a[i]。

1≤N≤100,000

1≤a[i]<998244353

输出
不难证明答案可以表示成一个最简分数 p * q -1。

你需要输出三个p * q -1 对 998244353取模后的结果，以此来表示偏离靶心次数为 0 , 1 , 2时的概率。

其中q-1是q 在模意义下的逆元，满足q-1* q = 1 mod 998244353。

例如1/4, 可以写成748683265，原因是4 * 748683265 % 998244353 = 1,也有且仅有x =  748683265，1 <= x < 998244353满足乘积等于1


样例输入
2
2 2
样例输出
748683265 499122177 748683265
* */
