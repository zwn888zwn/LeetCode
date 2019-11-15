import java.util.HashSet;

public class _136SingleNumber {
    //建立一个有序链表,查询如果存在就删除，否则添加 or使用hashset添加 如果存在就删除o(n)
    //mt2:先排序
    //mt3:异或？重要性质：异或2次等于原来的数    java位运算 ^=异或 &=与 <<=*2 >>=/2 >>>=左边补0
    //a = a ^ b;   ab交换
    //b = a ^ b;
    //a = a ^ b;
    public int singleNumber(int[] nums) {
        int xor=0;
        for (int num : nums) {
            xor = xor ^num;//最后等于目标和0异或  = 取反
        }
        return xor^0;
    }
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                set.remove(num);
            }else
                set.add(num);
        }
        return set.iterator().next();
    }
}
