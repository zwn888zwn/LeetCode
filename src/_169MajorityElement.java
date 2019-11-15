public class _169MajorityElement {
    public int majorityElement(int[] nums) {
        ElementNode ans=getMajor(nums,0,nums.length-1);
        return ans.val;
    }
    public ElementNode getMajor(int[] nums,int begin,int end){
        if (end-begin<=1){
            ElementNode temp=new ElementNode();
            if(nums[begin]==nums[end]){
                temp.val=nums[begin];
                temp.count=1;
            }
            return temp;
        }
        int mid=(begin+end)/2;
        ElementNode left=getMajor(nums,begin,mid);
        ElementNode right=getMajor(nums,mid+1,end);
        if (left.val==right.val){
            left.count=left.count+right.count;
            return left;
        }else {
            if (left.count>right.count){
                return left;
            }else if (left.count<right.count){
                return right;
            }else {
                left.count=0;
                return left;
            }
        }

    }
    private class ElementNode{
        int val;
        int count;
    }
}
