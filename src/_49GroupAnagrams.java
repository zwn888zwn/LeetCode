import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long,List<String>> hashMap=new HashMap<>();
        for (String str : strs) {
            int[] arr=new int[26];
            long  key=0;
            int length=str.length();
            for(int i=0;i<length;i++){
                arr[str.charAt(i)-'a']++;
            }
            for (int i : arr) {
                key = (key+i)*10;
            }


            if(hashMap.containsKey(key)){
                List<String> list=hashMap.get(key);
                list.add(str);
            }else{
                List<String> list=new ArrayList<>();
                list.add(str);
                hashMap.put(key,list);
            }
        }

        List<List<String>> ans=new ArrayList<>();
        for (Long integer : hashMap.keySet()) {
            ans.add(hashMap.get(integer));
        }
        return ans;
    }
}
