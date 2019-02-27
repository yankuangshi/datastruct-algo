package datastruct.heap;

public abstract class AbstractHeap {

    private int[] heap;
    private int heapSize;

    public AbstractHeap(int capacity) {
        heap = new int[capacity];
        heapSize = 0;
    }

    public AbstractHeap(int[] data, int capacity) {
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

    public int parentIndex(int i) {
        return (i-1)/2;
    }

    public int leftChildIndex(int i) {
        return 2*i+1;
    }

    public int rightChildIndex(int i) {
        return 2*i+2;
    }

    /**
     * bottom-top heapify for maintaining max-heap
     */
    public abstract void heapifyUp(int i);

    /**
     * top-bottom heapify for maintaining max-heap
     */
    public abstract void heapifyDown(int i, int tailIndex);

    public void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}
