public class _647回文子串 {
    public int countSubstrings(String s) {
        char[] chars=s.toCharArray();
        int cLength=s.length();
        //abc  baab
        int res=0;
        for(int i=0;i<chars.length;i++){
            int p=i-1,q=i+1;
            //i为中心
            while (p>=0 && q<cLength){
                if (chars[p]==chars[q])
                    res++;
                else
                    break;
                p--;
                q++;
            }
            p=i;q=i+1;
            while (p>=0 && q<cLength){
                if (chars[p]==chars[q])
                    res++;
                else
                    break;
                p--;
                q++;
            }
        }
        return res+cLength;
    }

    public static void main(String[] args) {
        _647回文子串 obj=new _647回文子串();
        obj.countSubstrings("fdsklf");
    }
}
