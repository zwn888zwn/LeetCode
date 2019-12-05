public class _215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return recursive(0,nums.length-1,nums,k);
    }
    public int recursive(int low,int high,int[] nums,int k){
        int mid=getIndex(nums,low,high);
        int result=high-mid+1;
        if (result == k)
            return nums[mid];
        else if(result>k){
            return recursive(mid+1,high,nums,k);
        }else {
            return recursive(low,mid-1,nums,k-result);
        }

    }

    private  int getIndex(int[] arr, int low, int high) {//o(n)
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }


}
