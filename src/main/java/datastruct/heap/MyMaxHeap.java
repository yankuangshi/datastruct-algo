package datastruct.heap;


/**
 * @author kyan
 *
 * My Implement of MaxHeap using Array data structure
 * Begins from index 0
 *
 * example:
 *
 *       20(0)
 *      /      \
 *     16(1)     19(2)
 *    /    \    /    \
 *   13(3) 4(4) 1(5) 7(6)
 *  /   \
 * 5(7) 8(8)
 *
 * consider index i element of the array, the
 *
 *  - its parent is located at (i-1)/2 index
 *  - its left child is located at 2*i+1 index
 *  - its right child is located at 2*i+2 index
 */
public class MyMaxHeap {

    private int[] heap;
    private int heapSize;

    public MyMaxHeap(int capacity) {
        heap = new int[capacity];
        heapSize = 0;
    }

    public MyMaxHeap(int[] data, int capacity) {
        heap = new int[capacity];
        for (int i = 0, len = data.length; i < len; i++) {
            heap[i] = data[i];
        }
        heapSize = data.length;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    public void buildHeap() {
        for (int i = parentIndex(heapSize-1); i >= 0; i--) {
            heapifyDown(i, heapSize-1);
        }
    }

    public void insert(int data) {
        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }
        heap[heapSize++] = data;//heap[heapSize]=data then heapSize++
        heapifyUp(heapSize-1);
    }

    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    public void removeTop() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        heap[0] = heap[heapSize-1]; //move the last heap element to top
        --heapSize;
        heapifyDown(0, heapSize-1);
    }

    public void sort() {
        int i = heapSize - 1;
        while (i > 0) {
            swap(0, i);
            --i;
            heapifyDown(0, i);
        }
    }

    public void printHeap() {
        String ret = "";
        for (int i = 0; i < heapSize; i++) {
            ret += heap[i] + " ";
        }
        System.out.println(ret);
    }

    public int[] getData() {
        int[] tmp = new int[heapSize];
        for (int i = 0; i < heapSize; i++) {
            tmp[i] = heap[i];
        }
        return tmp;
    }

    private int parentIndex(int i) {
        return (i-1)/2;
    }

    private int leftChildIndex(int i) {
        return 2*i+1;
    }

    private int rightChildIndex(int i) {
        return 2*i+2;
    }

    /**
     * bottom-top heapify for maintaining max-heap
     */
    private void heapifyUp(int i) {
        while (i > 0 && heap[i] > heap[parentIndex(i)]) {
            swap(i, parentIndex(i));
            i = parentIndex(i);
        }
    }

    /**
     * top-bottom heapify for maintaining max-heap
     */
    private void heapifyDown(int i, int tailIndex) {
        while (true) {
            int maxPos = i;
            if (leftChildIndex(i) <= tailIndex && heap[i] < heap[leftChildIndex(i)]) {
                maxPos = leftChildIndex(i);
            }
            if (rightChildIndex(i) <= tailIndex && heap[maxPos] < heap[rightChildIndex(i)]) {
                maxPos = rightChildIndex(i);
            }
            if (maxPos == i) break;
            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {7,5,19,8,4,1,20,13,16};
        System.out.println("--- before build a heap ---");
        MyMaxHeap maxHeap = new MyMaxHeap(data, 100);
        maxHeap.printHeap();
        System.out.println("--- after build a heap ---");
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
