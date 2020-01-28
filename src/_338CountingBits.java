import java.util.Arrays;

public class _338CountingBits {
    public int[] countBits(int num) {
        if (num==0)
            return new int[]{0};
        if (num==1)
            return new int[]{0,1};
        int[] res=new int[num+1];
        int count=2;
        res[0]=0;
        res[1]=1;
        while (count<=num){
            copyAndFill(res,count);
            count*=2;
        }
        copyAndFill(res,count);
        return res;
    }
    public void copyAndFill(int[] arr,int num){
        int halfNum=num/2;
        int length=arr.length;
        for (int i=num/2;i<num && i<length;i++){
            arr[i]=arr[i-halfNum]+1;
        }
    }
}
