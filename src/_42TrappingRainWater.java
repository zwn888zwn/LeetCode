import java.util.ArrayList;

public class _42TrappingRainWater {

    public int trap(int[] height) {
        //木桶效应：以短的木板为准
        int sum=0;
        int temp=0,leftIndex=0;
        boolean hasLeft=false;
        for(int i=0;i<height.length;i++){
            //如果是短的，只有碰到>=的木板才能装下水
            if(!hasLeft && height[i]>0){
                hasLeft=true;
                leftIndex=i;
            }
            if (hasLeft && leftIndex<height.length){
                //找到可以装睡的木板
                int tempSum=0;
                boolean findRight=false;
                int j;
                int secondMax=-1;
                for(j=i+1;j<height.length;j++){
                    secondMax=Math.max(secondMax,height[j]);
                    if(height[j]>=height[leftIndex]){
                        findRight=true;
                        break;
                    }else {
                        tempSum+=height[leftIndex]-height[j];
                    }
                }
                if (findRight){
                    sum+=tempSum;
                    leftIndex=j;
                    i=j-1;
                }else {//考虑423的情况 找到第二大的木板secondMax 把前面的木板砍了 323
                    //hasLeft=false;
                    height[i]=secondMax;
                    if(i!=height.length-1)//最后就停止
                        i--;
                }
            }

        }
        return sum;
    }
    //Time Limit Exceeded n^2太慢了
    public int trap1(int[] height) {
        int maxHeight=-1;
        for (int i : height) {
            maxHeight=Math.max(maxHeight,i);
        }
        //一层层计算容量 时间复杂度n*maxHeight
        int sum=0;
        for(int i=1;i<=maxHeight;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<height.length;j++){
                 if (height[j]>=i){
                     arr.add(j);
                 }
                 if(arr.size()>=2){
                     sum+=(arr.get(1)-arr.get(0)-1);
                     arr.remove(0);
                 }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _42TrappingRainWater obj=new _42TrappingRainWater();
        System.out.println( obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }
}
