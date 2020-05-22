public class _461汉明距离 {
    //easy直接位运算
    public int hammingDistance(int x, int y) {
        int val=x ^ y;
        int res=0;
        while (val>0){
            if ((val & 1) == 1){
                res++;
            }
            val=val >> 1;
        }
        return res;
    }
}
