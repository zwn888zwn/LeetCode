public class _11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxVolume=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                maxVolume=Math.max(maxVolume,(j-i)*Math.min(height[i],height[j]));
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(new _11ContainerWithMostWater().maxArea(arr));
    }
}
