public class KMPStringSearch {
    public int search(String str,String sub){
        int[] next=getNext(sub);
        int mainPointer=0,subPointer=0;
        while (mainPointer<str.length()){
            if(str.charAt(mainPointer)==sub.charAt(subPointer)){
                if (subPointer==sub.length()-1)
                    return mainPointer-sub.length()+1;
                mainPointer++;
                subPointer++;
            }else {
                if (subPointer==0){
                    mainPointer++;
                    continue;
                }
                subPointer=next[subPointer-1];
            }
        }
        return -1;
    }

    private int[] getNext(String sub) {
        int[] arr=new int[sub.length()];
        int j=0;
        for(int i=1;i<sub.length();i++){
            if(sub.charAt(i)==sub.charAt(j)){
                arr[i]=j+1;
                j++;
            }else if (j>0){//如果不等j就跳到arr【j-1】继续比较
                j=arr[j-1];
                while(j>0){
                    if(sub.charAt(i)==sub.charAt(j)){
                        arr[i]=j+1;
                        break;
                    }else {
                        j=arr[j-1];
                    }
                }
            }
        }
        return arr;
    }
//https://www.bilibili.com/video/av3246487/?from=search&seid=17173603269940723925
    public static void main(String[] args) {
        KMPStringSearch obj=new KMPStringSearch();
        System.out.println(obj.search("abxabcabcaby","abcaby"));

    }
}
