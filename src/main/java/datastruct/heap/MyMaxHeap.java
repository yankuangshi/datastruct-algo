package datastruct.heap;


/**
 * @author kyan
 *
 * My Implement of MaxHeap using Array data structure
 * Begins from index 0
 *
 * example:
 *       20(0)
 *      /     \
 *     16(1)  19(2)
 *    /    \
 *   13(3) 4(4)
 *
 * consider ith element of the array, the
 *
 *  - its parent is located at (i-1)/2 index
 *  - its left child is located at 2*i+1 index
 *  - its right child is located at 2*i+2 index
 */
public class MyMaxHeap extends AbstractHeap {

    public MyMaxHeap(int capacity) {
        super(capacity);
    }

    public MyMaxHeap(int[] data, int capacity) {
        super(data, capacity);
    }

    /**
     * bottom-top heapify for maintaining max-heap
     */
    public void heapifyUp(int i) {
        while (i > 0 && getHeap()[i] > getHeap()[parentIndex(i)]) {
            swap(i, parentIndex(i));
            i = parentIndex(i);
        }
    }

    /**
     * top-bottom heapify for maintaining max-heap
     */
    public void heapifyDown(int i, int tailIndex) {
        while (true) {
            int maxPos = i;
            if (leftChildIndex(i) <= tailIndex && getHeap()[i] < getHeap()[leftChildIndex(i)]) {
                maxPos = leftChildIndex(i);
            }
            if (rightChildIndex(i) <= tailIndex && getHeap()[maxPos] < getHeap()[rightChildIndex(i)]) {
                maxPos = rightChildIndex(i);
            }
            if (maxPos == i) break;
            swap(i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        int[] data = {7,5,19,8,4,1,20,13,16};
        System.out.println("--- before build a max heap ---");
        MyMaxHeap maxHeap = new MyMaxHeap(data, 100);
        maxHeap.printHeap();
        System.out.println("--- after build a max heap ---");
        maxHeap.buildHeap();
        maxHeap.printHeap();
        System.out.println("--- insert ---");
        maxHeap.insert(14);
        maxHeap.printHeap();
        System.out.println("--- remove max ---");
        maxHeap.removeTop();
        maxHeap.printHeap();
        System.out.println("--- sort ---");
        maxHeap.sort();
        maxHeap.printHeap();
    }
}
