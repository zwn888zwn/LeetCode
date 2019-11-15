public class _75SortColors {
    public void sortColors(int[] nums) {
        int redIndex=0, blueIndex=nums.length-1;
        int left1=0,right1=0;
        boolean leftMark=false,rightMark=false;
        while(redIndex<=blueIndex){
            while(redIndex<=blueIndex){
                if (nums[redIndex]==2){
                    swap(nums,redIndex,blueIndex);
                    break;
                }else if (nums[redIndex]==0){
                    if (leftMark){
                        swap(nums,redIndex,left1);
                        leftMark=false;
                        redIndex=left1;
                        break;
                    }
                    redIndex++;
                }else{
                    if (!leftMark){
                        leftMark=true;
                        left1=redIndex;
                    }
                    redIndex++;
                }
            }
            while(redIndex<=blueIndex){
                if (nums[blueIndex]==0){
                    swap(nums,redIndex,blueIndex);
                    break;
                }else if (nums[blueIndex]==2){
                    if (rightMark){
                        swap(nums,blueIndex,right1);
                        rightMark=false;
                        blueIndex=right1;
                        break;
                    }
                    blueIndex--;
                }else{
                    if (!rightMark){
                        rightMark=true;
                        right1=blueIndex;
                    }
                    blueIndex--;
                }
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        _75SortColors obj=new _75SortColors();
        obj.sortColors(new int[]{1,0});
    }
}
