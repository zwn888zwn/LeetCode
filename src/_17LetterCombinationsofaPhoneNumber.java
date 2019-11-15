import java.util.ArrayList;
import java.util.List;

public class _17LetterCombinationsofaPhoneNumber {
    String[] letterArr={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result=new ArrayList<>();
    int[] select=new int[20];
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)
            return result;
        add(digits,0,digits.length());
        return result;
    }
    public void add(String digits,int lvl,int strLen){
        if(lvl==strLen){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<lvl;i++){
                sb.append(letterArr[digits.charAt(i)-'0'-2].charAt(select[i]));
            }
            result.add(sb.toString());
            return;
        }
        for(int i=0;i<letterArr[digits.charAt(lvl)-'0'-2].length();i++){
            select[lvl]=i;
            add(digits,lvl+1,strLen);
        }
    }

    public static void main(String[] args) {
        System.out.println( new _17LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }
}
