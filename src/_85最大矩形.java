public class _85最大矩形 {
    //根据84修改
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] height=new int[matrix[0].length];
        int maxRes=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    height[j]+=1;
                }else
                    height[j]=0;
            }
            //84.
            maxRes=Math.max(maxRes,getMaxRec84(height));

        }

        return maxRes;

    }
    public int getMaxRec84(int[] bars){

        int n=bars.length;
        int[] lefts=new int[n];
        int[] rights=new int[n];
        int result=0;

        //build left
        lefts[0]=0;
        for (int i=1;i<n;i++){
            int left=i-1;
            while (left>=0&&bars[left]>=bars[i]){
                //left--; 改为下方
                left=lefts[left]-1;//DP思想 一下可以跳过好多
            }
            lefts[i]=left+1;
        }
        //build right
        rights[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            int right=i+1;
            while (right<n &&bars[right]>=bars[i]){
                //right++;
                right=rights[right]+1;
            }
            rights[i]=right-1;
        }

        for(int i = 0; i < n; i++) {
            result = Math.max(result, (rights[i]-lefts[i]+1)*bars[i]);
        }

        return result;

    }
}
