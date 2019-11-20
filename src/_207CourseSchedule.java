public class _207CourseSchedule {
    int[][] adjMatrix=null;
    int[] visited=null;
    boolean dp[]=null;

    //如果用邻接表还可以更快
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjMatrix=new int[numCourses][numCourses];
        visited=new int[numCourses];
        dp=new boolean[numCourses];
        //init
        for (int[] prerequisite : prerequisites) {
            adjMatrix[prerequisite[0]][prerequisite[1]]=1;
        }
        boolean res=false;
        for (int i=0;i<visited.length;i++){
                res= res || hasCircle(i);
                if (res)
                    break;
        }
        return !res;
    }
    public boolean hasCircle(int index){
        if (dp[index])
            return false;
        for(int i=0;i<adjMatrix.length;i++){//用邻接表的话不用全部遍历了，效率提升 n^2->n
            if(adjMatrix[index][i]==1){
                if (visited[i]==1){
                    return true;//代表有环
                }else {
                    visited[index]=1;
                    if (hasCircle(i)){
                        return true;
                    }

                }
            }
        }
        visited[index]=0;
        dp[index]=true;
        return false;
    }
}
