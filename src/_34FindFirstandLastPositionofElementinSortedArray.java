public class _34FindFirstandLastPositionofElementinSortedArray {
    int leftIndex=-1,rightIndex=-1;
    boolean leftfind=true,rightfind=true;
    public int[] searchRange(int[] nums, int target) {
        //二分查找
        //找到目标后 左边和目标不想等 返回 否则继续在左边搜索
        //。。。     右边和目标不相等 返回  。。右边。。
        binarySerach(nums,target,0,nums.length-1);
        return new int[]{leftIndex,rightIndex};
    }
    public void binarySerach(int[] nums, int target,int left,int right){
        int mid=(left+right)/2;
        if(left<=right && (leftfind || rightfind)){
            if(nums[mid]==target){
                if (leftfind){
                    if ( mid-1>=0 && target==nums[mid-1]   ){
                        binarySerach(nums, target, left, mid-1);
                    }else {
                        leftIndex=mid;
                        leftfind=false;
                    }
                }
                if (rightfind){
                    if(mid+1<=nums.length-1 && target==nums[mid+1]){
                        binarySerach(nums, target, mid+1, right);
                    }else{
                        rightIndex=mid;
                        rightfind=false;
                    }
                }

            }else if(target<nums[mid]){
                binarySerach(nums, target, left, mid-1);
            }else {
                binarySerach(nums, target, mid+1, right);
            }

        }
    }

    public static void main(String[] args) {
        _34FindFirstandLastPositionofElementinSortedArray obj=new _34FindFirstandLastPositionofElementinSortedArray();
        int[] arr=obj.searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println(arr[0]+","+arr[1]);
    }
}
