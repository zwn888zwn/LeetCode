
import java.util.*;

public class _22GenerateParentheses {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recursion(n,"",new Stack<>());
        return result;
    }
    public void recursion(int n,String s,Stack<Character> stacks){
        if(n>0){
            for(int i=0;i<2;i++){
                if(i%2==0){
                    String temp=s;
                    Stack<Character> stack=new Stack<>();
                    for(int j=0;j<stacks.size();j++){
                        stack.push(stacks.get(j));
                    }
                    temp=temp+"(";
                    stack.push(')');
                    recursion(n-1,temp,stack);
                }else {
                    if (!stacks.empty()){

                        String temp=s;
                        Stack<Character> stack=new Stack<>();
                        for(int j=0;j<stacks.size();j++){
                            stack.push(stacks.get(j));
                        }
                        stack.pop();
                        temp = temp+")";
                        recursion(n,temp,stack);
                    }
                }

            }

        }else {
            while(!stacks.empty()){
                stacks.pop();
                s=s+")";
            }
            result.add(s);
        }
    }


    public static void main(String[] args) {
        _22GenerateParentheses obj=new _22GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));

    }
}
