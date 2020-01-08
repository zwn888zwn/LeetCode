public class _240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0)
            return false;
        return recursiveSearch(matrix,target,0,0,matrix.length-1,matrix[0].length-1);
    }
    public boolean recursiveSearch(int[][] matrix, int target,int beginM,int beginN,int endM,int endN){
        int i;
        boolean hasIn=false;
        for (i=0;(beginM+i)<=endM && (beginN+i)<=endN ;i++){
            hasIn=true;
            if (matrix[beginM+i][beginN+i]==target){
                return true;
            }
            if (matrix[i][i]>target){//只需要在行列上找，找不到直接false
                //find in  row
                for (int j=beginN;j<endN;j++)
                    if (matrix[beginM+i][j]==target)
                        return true;
                //find in column
                for (int j=beginM;j<endM;j++)
                    if (matrix[j][beginN+i]==target)
                        return true;
                return false;
            }

        }
        if (!hasIn)
         return false;
        if (beginN+i<endN){//m<n
            return recursiveSearch(matrix,target,beginM,beginN+i,endM,endN);
        }else {
            return recursiveSearch(matrix,target,beginM+1,beginN,endM,endN);
        }

    }
}
