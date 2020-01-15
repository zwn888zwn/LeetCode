import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MedianFinder {
    int count=0;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((o1,o2)->{return o2-o1;});
    }

    public void addNum(Integer num) {
        count++;
        maxHeap.offer(num);
        if (count%2==0)
            minHeap.offer(maxHeap.poll());
        else{
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(minHeap.poll());
        }


    }

    public double findMedian() {
        if (count%2==0){
            return (minHeap.peek()+maxHeap.peek())*0.5;
        }else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();
    }
}


class MedianFinder1 {
    /**  99%数字都在 0-100的时候可能比较快
    /** initialize your data structure here. */
    TreeMap<Integer,Integer> map;
    int count=0;
    public MedianFinder1() {
        map=new TreeMap();
    }

    public void addNum(Integer num) {
        int temp= map.getOrDefault(num,0);
        map.put(num,++temp);
        count++;
    }

    public double findMedian() {
        int localCount=0;
        int temp1=-9999,temp2=-9999;

        for (Integer key : map.keySet()) {
            localCount=localCount+map.get(key);

            if (count%2==1){
                if (localCount>= count/2+1)
                    return Double.parseDouble(key.toString());
            }else {
                if (localCount>=count/2+1){
                    temp2=key;
                    if (temp1==-9999){
                        return key;
                    }else
                        return (temp1+temp2)/2.0;
                }
                if (localCount>= count/2){
                    temp1=key;
                }


            }
        }
        return -1;
    }

}
