public class _33SearchinRotatedSortedArray {
    int index=-1;
    boolean notFind=true;

    public int search(int[] nums, int target) {
        recursion(nums,target,0,nums.length-1);
        return index;
    }

    public void recursion(int[] nums, int target,int left,int right){
        if (notFind && left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                notFind=false;
                index=mid;
            }else if(nums[left]>nums[right]){//存在断层  nums[left]>nums[right] 两边搜索
                recursion(nums, target, left, mid-1);
                recursion(nums, target, mid+1, right);
            }else {//不存在断层直接二分
                if (target<nums[mid]){
                    recursion(nums, target, left, mid-1);
                }else {
                    recursion(nums, target, mid+1, right);
                }
            }
        }

    }

    public static void main(String[] args) {
        _33SearchinRotatedSortedArray obj=new _33SearchinRotatedSortedArray();
        System.out.println(obj.search(new int[]{3,4,5,6,1,2},2));
    }


    /*            // bound  && tend && 确实小
            if(mid-1>=left && nums[mid-1]<nums[mid] && target<nums[mid] ){
                recursion(nums,target,left,mid-1);
            }
            if(mid+1<=right && nums[mid+1]<nums[mid] && target<nums[mid]){
                recursion(nums,target,mid+1,right);
            }
            if(mid-1>=left && nums[mid-1]>nums[mid] && target>nums[mid] ){
                recursion(nums,target,left,mid-1);
            }
            if(mid+1<=right && nums[mid+1]>nums[mid] && target>nums[mid]){
                recursion(nums,target,mid+1,right);
            }*/
}
