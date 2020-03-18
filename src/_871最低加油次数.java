import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _871最低加油次数 {
    //fixme,思路错的 一桶油出现加好几次的情况
    //plan1 DP[i]到距离i位置最少加几桶油 只要超过了加油站 尽可能的让他往前走.
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,999999999);
        //init
        for (int i=0;i<dp.length && i<=startFuel;i++)
            dp[i]=0;

        for(int i=0;i<stations.length;i++){
            for(int j=stations[i][0];j<=target;j++){
                if (j-stations[i][1]>=stations[i][0]){//超远加油
                    dp[j]=Math.min(dp[j],dp[j-stations[i][1]]+1);
                }
            }
            for(int j=0;j<=stations[i][1];j++){
                if (j+stations[i][0]<=target){//对加油站后，加油范围内的所有更新 100 50 [40 50] -1 不行
                    dp[j+stations[i][0]]=Math.min(dp[j+stations[i][0]],dp[stations[i][0]]+1);
                }
            }
        }
        if (dp[target]>=999999998)
            return -1;
        else
            return dp[target];
    }

    //plan2 dfs加油就相当于一个更新startFuel的过程,每次尽可能的不加油,如果startFuel>target返回,能保证返回最优解吗？
    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        return 0;
    }

    //官方答案1 dp[i]=加i次油能开的最大距离
    public int minRefuelStops3(int target, int startFuel, int[][] stations) {
        int N=stations.length;
        long dp[]=new long[N+1];
        dp[0]=startFuel;
        for(int i=0;i<N;i++){//对于第i个加油站
            for(int j=i;j>=0;j--){//为什么从大到小，如果从小到大，那么这个加油站可能会被加多次
                if (dp[j]>=stations[i][0]){//j次加油能开到加油站
                    dp[j+1]=Math.max(dp[j+1],dp[j]+stations[i][1]);
                }
            }
        }
        for (int i=0;i<=N;i++)
            if (dp[i]>=target)
                return i;
        return -1;
    }

    //plan4 优先队列 贪心，尽可能的往前走，到不了就加油，如果没油可加而且还到不了-1
    public int minRefuelStops4(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(((o1, o2) -> o2-o1));//待加油
        int ans=0;
        for (int[] station : stations) {
           if (startFuel>=target)
               return ans;
           if (startFuel>=station[0]){ //满足直接加油
               pq.offer(station[1]);
           }else {
               while (!pq.isEmpty()){
                   startFuel+=pq.poll();
                   ans++;
                   if (startFuel>=station[0])
                       break;
               }
               if (startFuel<station[0])//加了以后终于到了，放在备用油箱里
                   return -1;
               else
                   pq.offer(station[1]);
           }

        }
        //可以到最后加油站了，但是不一定能到终点，继续加油
        while ((!pq.isEmpty()) && startFuel<target){
            startFuel+=pq.poll();
            ans++;
        }

        return startFuel>=target?ans:-1;
    }
    public static void main(String[] args) {
        _871最低加油次数 obj=new _871最低加油次数();
        obj.minRefuelStops3(100,50,new int[][]{{40,50}});
    }
}
