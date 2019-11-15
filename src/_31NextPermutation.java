public class _31NextPermutation {

    public void nextPermutation(int[] nums) {
        //1 find a< a+1
        int a,b;
        for(a=nums.length-2;a>=0;a--){
            if (nums[a]<nums[a+1]){
                break;
            }
        }
        if(a<0)
            a=0;
        // 2 find smallest b>a
        for(b=nums.length-1;b>a;b--){
            if(nums[b]>nums[a]){
                break;
            }
        }

        //3 change a b
        int temp;
        if (b<=a){
            b=nums.length-1;
        }
        else {
            temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
        }

        //4 reverse a+1 - n
        b=nums.length-1;
        while (a<=b){
            temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
        }

    }
    public void print(int[] nums){
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={3,2,1};
        int[] arr3={2,3,1};
        _31NextPermutation obj=new _31NextPermutation();
        obj.nextPermutation(arr1);
        obj.nextPermutation(arr2);
        obj.nextPermutation(arr3);

        obj.print(arr1);
        obj.print(arr2);
        obj.print(arr3);
    }

}
