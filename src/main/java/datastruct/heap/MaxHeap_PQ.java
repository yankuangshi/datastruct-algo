package datastruct.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implement MaxHeap using java's priority queue
 */
public class MaxHeap_PQ {

    PriorityQueue<Integer> pq;

    public MaxHeap_PQ() {
        pq = new PriorityQueue<>(Comparator.reverseOrder());
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
        MaxHeap_PQ maxHeap = new MaxHeap_PQ();
        maxHeap.insert(data);
        maxHeap.printHeap();
        System.out.println("--- insert ---");
        maxHeap.insert(14);
        maxHeap.printHeap();
        System.out.println("--- remove top ---");
        maxHeap.removeTop();
        maxHeap.printHeap();
    }

}
