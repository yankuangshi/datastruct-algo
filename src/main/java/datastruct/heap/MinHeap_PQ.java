package datastruct.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Implement MinHeap using java's priority queue
 */
public class MinHeap_PQ {

    PriorityQueue<Integer> pq;

    public MinHeap_PQ() {
        pq = new PriorityQueue<>();
    }

    public void insert(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            pq.offer(nums[i]);
        }
    }

    public void insert(int num) {
        pq.offer(num);
    }

    public Integer removeTop() {
        return pq.poll();
    }

    public Integer getTop() {
        return pq.peek();
    }

    public void printHeap() {
        System.out.println(pq);
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public Integer getSize() {
        return pq.size();
    }

    public static void main(String[] args) {
        int[] data = {7,5,19,8,4,1,20,13,16};
        System.out.println("--- original array ---");
        System.out.println(Arrays.toString(data));
        System.out.println("--- build max heap ---");
        MinHeap_PQ minHeap = new MinHeap_PQ();
        minHeap.insert(data);
        minHeap.printHeap();
        System.out.println("--- insert ---");
        minHeap.insert(14);
        minHeap.printHeap();
        System.out.println("--- remove top ---");
        minHeap.removeTop();
        minHeap.printHeap();
    }
}
