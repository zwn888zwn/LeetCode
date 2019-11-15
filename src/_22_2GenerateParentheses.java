import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22_2GenerateParentheses {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recursion(n,n,"");
        return result;
    }
    public void recursion(int left,int right,String s){
        if(left>0){
            for(int i=0;i<2;i++){
                if(i%2==0){
                    recursion(left-1,right,s+"(");
                }else {
                    if (left<right && right>0){
                        recursion(left,right-1,s+")");
                    }
                }
            }
        }else {
            while(right>0){
                s=s+")";
                right--;
            }
            result.add(s);
        }
    }


    public static void main(String[] args) {
        _22_2GenerateParentheses obj=new _22_2GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));

    }
}
