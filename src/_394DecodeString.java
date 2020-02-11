public class _394DecodeString {
    //s = "3[a2[c]]", return "accaccacc".
    //s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c>='a' && c<='z' || c>='A'&&c<='Z'){//是字母
                res.append(c);
                continue;
            }
            //不是字母 获取数字和[]内的东西
            int num=0;
            for (;i<s.length();i++){
                char temp=s.charAt(i);
                if (temp=='[')
                    break;
                num=num*10 + (int)(temp-'0');
            }
            int endBracket=getEndBracket(s,i);
            String subStr=decodeString(s.substring(i+1,endBracket));
            for (int j=0;j<num;j++){
                res.append(subStr);
            }
            i=endBracket;
        }

        return res.toString();
    }

    private int getEndBracket(String s, int i) {
        int left=1;
        for(int j=i+1;j<s.length();j++){
            char c=s.charAt(j);
            if (c=='['){
                left++;
            }
            if (c==']'){
                left--;
            }
            if (left==0)
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        _394DecodeString obj=new _394DecodeString();
        System.out.println(obj.decodeString("3[a]2[b4[F]c]"));
    }

}
