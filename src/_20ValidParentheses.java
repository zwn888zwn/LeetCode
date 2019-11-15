import java.util.ArrayList;
import java.util.Stack;

public class _20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' ||c=='[' ){
                stack.push(c);
            }else if(c==')'){
                if(stack.empty() || stack.pop()!='('){
                    return false;
                }
            }else if(c=='}'){
                if(stack.empty() ||stack.pop()!='{'){
                    return false;
                }
            }else if(c==']'){
                if(stack.empty() ||stack.pop()!='['){
                    return false;
                }
            }

        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        new _20ValidParentheses().isValid("[");
    }
}
