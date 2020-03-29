import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

//这类问题思想  分别对每个栏杆，求他的最大的左右范围 可以暴力求 也可以DP
public class _84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] bars) {
        if(bars == null || bars.length == 0) {
            return 0;
        }
        int n=bars.length;
        int[] lefts=new int[n];
        int[] rights=new int[n];
        int result=0;

        //build left
        lefts[0]=0;
        for (int i=1;i<n;i++){
            int left=i-1;
            while (left>=0&&bars[left]>=bars[i]){
                //left--; 改为下方
                left=lefts[left]-1;//DP思想 一下可以跳过好多
            }
            lefts[i]=left+1;
        }
        //build right
        rights[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            int right=i+1;
            while (right<n &&bars[right]>=bars[i]){
                //right++;
                right=rights[right]+1;
            }
            rights[i]=right-1;
        }

        for(int i = 0; i < n; i++) {
            result = Math.max(result, (rights[i]-lefts[i]+1)*bars[i]);
        }

        return result;

    }

    //暴力枚举
    public int largestRectangleArea2(int[] bars) {
        //对于每个方格求出他最大面积
        int max=0;
        for (int i=0;i<bars.length;i++){
            int left=i,right=i;
            while (left-1>=0&&bars[left-1]>=bars[i]) left--;
            while (right+1<=bars.length-1&&bars[right+1]>=bars[i]) right++;
            max=Math.max(max,(right+1-left)*bars[i]);
        }
        return max;
    }
    public int largestRectangleArea1(int[] bars) {
        if (bars == null || bars.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();//存放比我矮的栈
        int n = bars.length;
        int front = 0;
        int max = 0;
        while (front < n) {
            if (stack.isEmpty() || bars[stack.peek()] < bars[front]) {//上升就入栈
                stack.push(front);
                front++;
            } else {//比我高就出栈
                int last = stack.pop();
                int width = stack.isEmpty() ? front : front - (stack.peek() + 1);//距离栈前元素距离
                max = Math.max(max, bars[last] * width);
            }
        }
        while (!stack.isEmpty()) {
            int last = stack.pop();
            int width = stack.isEmpty() ? front : front - (stack.peek() + 1);
            max = Math.max(max, bars[last] * width);
        }
        return max;
    }

    //单调栈
    public int largestRectangleArea3(int[] bars) {
        if(bars == null || bars.length == 0) {
            return 0;
        }
        int n=bars.length;
        int result=0;

        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        stack.push(0);
        for (int i=1;i<n;i++){
            int peekIndex=stack.peek();
            if (peekIndex!=-1){
                if (bars[peekIndex]<=bars[i])
                    stack.push(i);
                else {
                    while (stack.peek()!=-1 && bars[stack.peek()]>bars[i]){
                        peekIndex=stack.pop();
                        result= Math.max(result,(i-1-stack.peek())*bars[peekIndex]);
                    }
                    stack.push(i);
                }
            }
        }
        while (stack.peek()!=-1){
            int peekIndex=stack.pop();
            result= Math.max(result,(n-1-stack.peek())*bars[peekIndex]);
        }

        return result;

    }

    public static void main(String[] args) {
        _84LargestRectangleinHistogram obj=new _84LargestRectangleinHistogram();
        //obj.largestRectangleArea(new int[]{4,2,0,3,2,4,3,4});
        obj.largestRectangleArea3(new int[]{2,1,5,6,2,3});
    }
}
