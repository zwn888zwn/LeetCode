public class _48RotateImage {
    //先行交换，在对角交换数字
    public void rotate(int[][] matrix) {
        int length=matrix.length;
        for(int i=0;i<=length/2-1;i++){
            int[] temp=matrix[i];
            matrix[i]=matrix[length-i-1];
            matrix[length-i-1]=temp;
        }
        //上三角矩阵
        for(int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
}
