package 模拟题;

import java.util.*;

//66%  字节笔试第一题，为啥不行呢
public class zj1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        HashMap<String, TreeSet<String>> map=new HashMap();
        for (int i=0;i<n;i++){
            String key=scan.next();
            String val=scan.next();
            TreeSet<String> set=map.getOrDefault(val,new TreeSet<>());
            set.add(key);
            map.put(val,set);
        }
        Set<String> keys=map.keySet();
        TreeSet<String> ts=new TreeSet<>();
        for (String key : keys) {
            ts.add(key);
        }

        for (String key : ts) {
            TreeSet<String> set=map.get(key);
            System.out.print(key+" ");
            for (String s : set) {
                System.out.print(s+" ");
            }
            System.out.println();
        }

    }
}
