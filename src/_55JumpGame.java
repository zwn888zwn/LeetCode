public class _55JumpGame {

    public boolean canJump(int[] nums) {
        boolean[] canArrive=new boolean[nums.length];
        boolean[] hasVisted=new boolean[nums.length];
        canArrive[nums.length-1]=true;
        return tryJump(nums.length-1,nums,canArrive,hasVisted);
    }
    //递归从后往前，如果能从第一个跳过去那就OK
    public boolean tryJump(int nowPosition,int[] nums,boolean[] canArrive,boolean[] hasVisted){

        if(nowPosition==0){
            return true;
        }else if(nowPosition>0){
            if(canArrive[nowPosition]){
                for(int i=nowPosition-1;i>=0;i--){
                    if(nowPosition-i<=nums[i]&& !hasVisted[i]){//can jump
                        canArrive[i]=true;
                        hasVisted[i]=true;
                        if(tryJump(i,nums,canArrive,hasVisted)){
                            return true;
                        }

                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        _55JumpGame obj=new _55JumpGame();
        obj.canJump(new int[]{2,3,1,1,4});
    }

}
