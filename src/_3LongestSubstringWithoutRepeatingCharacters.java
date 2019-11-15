import java.util.LinkedList;
import java.util.Queue;

public class _3LongestSubstringWithoutRepeatingCharacters {
    //优化：[i,j] 如果j+1字符在i-j中重复，i直接跳转到重复位置处
    public static int lengthOfLongestSubstring(String s) {
        int[] repeatChar=new int[128];
        Queue<Character> queue=new LinkedList();//用i，j就能表示滑动窗口，不需要队列
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(repeatChar[c]==0){
                queue.offer(c);
                repeatChar[c]=1;
                max=Math.max(max,queue.size());
            }else{
                while((!queue.isEmpty())&&queue.peek()!=c){
                    repeatChar[queue.peek()]=0;
                    queue.poll();

                }
                queue.poll();
                queue.offer(c);
                repeatChar[c]=1;
            }
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int[] repeatChar=new int[128];//index of character
        int max=0,n=s.length();
        for(int i=0,j=0;j<n;j++){
            i=Math.max(i,repeatChar[s.charAt(j)]);
            max=Math.max(max,j-i+1);
            repeatChar[s.charAt(j)]=j+1;//下次i在重复位置的后面一个位置
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring2("aab"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
