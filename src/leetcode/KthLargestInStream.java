package leetcode;

import java.util.*;

public class KthLargestInStream {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for(int n: nums){
            minHeap.offer(n);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestInStream ob = new KthLargestInStream(3, new int[]{4, 5, 8 ,2});
        System.out.println(ob.add(3));
    }
}
