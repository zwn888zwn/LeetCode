public class _8字符串转换整数atoi {
    //有限状态机
    // 0start 1sign 2 num 3 other
    int[][] dfa=new int[][]{
            {0,1,2,3},
            {3,3,2,3},
            {3,3,2,3},
            {3,3,3,3}};
    int state=0;
    long res=0;
    int sign=0; //0 positive 1neg
    public void changeState(char c){
        if(c==' '){
            state=dfa[state][0];
        }else if(c=='-' || c=='+'){
            state=dfa[state][1];
        }else if(c>='0' && c<='9'){
            state=dfa[state][2];
        }else{
            state=dfa[state][3];
        }
    }
    public void doCal(char c){
        changeState(c);
        if(state==1){
            sign= c=='+'?0:1;
        }
        if(state==2){
            res=res*10 + (c-'0');
            if(sign==0){
                res=Math.min(res,Integer.MAX_VALUE);
            }else{
                res=Math.min(res,Integer.MAX_VALUE+1l);
            }
        }
    }
    public int myAtoi(String str) {
        char[] cc = str.toCharArray();
        for(char c : cc){
            doCal(c);
        }
        return (int) (sign==0?res:-res);
    }
}
