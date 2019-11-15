public class _4MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m=A.length,n= B.length;
        if(n<m){
            int[] temp=A;
            A=B;m=A.length;
            B=temp;n=B.length;
        }
        int iMin=0,iMax=m;
        while(iMin<=iMax){
            int i=(iMin+iMax)/2;
            int j=(m+n+1)/2-i;
            if(i > iMin && A[i-1]>B[j]){//i is too big
                iMax=i-1;
            }else if(i < iMax && B[j-1]>A[i]){//i is too small
                iMin=i+1;
            }else{// i is ok
                double maxLeft=0;
                if(i==0){
                    maxLeft=B[j-1];
                }else if( j==0){
                    maxLeft=A[i-1];
                }else {
                    maxLeft=Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2==1){
                    return maxLeft;
                }

                double minRight=0;
                if(i==m){
                    minRight=B[j];
                }else if( j==n){
                    minRight=A[i];
                }else {
                    minRight=Math.min(B[j],A[i]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr1={1,3};
        int[] arr2={2};
        System.out.println(new _4MedianOfTwoSortedArrays().findMedianSortedArrays(arr1,arr2));

    }

}
