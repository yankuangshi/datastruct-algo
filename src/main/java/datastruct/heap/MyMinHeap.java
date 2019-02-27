package datastruct.heap;

/**
 * @author kyan
 *
 * My implement of MinHeap
 *
 * example:
 *     15(0)
 *    /   \
 *  20(1)  21(2)
 *  /   \
 * 30(3) 31(4)
 *
 */
public class MyMinHeap extends AbstractHeap {

    public MyMinHeap(int capacity) {
       super(capacity);
    }

    public MyMinHeap(int[] data, int capacity) {
        super(data, capacity);
    }

    /**
     * bottom-top heapify for maintaining min-heap
     */
    public void heapifyUp(int i) {
        while (i > 0 && getHeap()[i] < getHeap()[parentIndex(i)]) {
            swap(i, parentIndex(i));
            i = parentIndex(i);
        }
    }

    /**
     * top-bottom heapify for maintaining min-heap
     */
    public void heapifyDown(int i, int tailIndex) {
        while (true) {
            int minPos = i;
            if (leftChildIndex(i) <= tailIndex && getHeap()[leftChildIndex(i)] < getHeap()[i]) {
                minPos = leftChildIndex(i);
            }
            if (rightChildIndex(i) <= tailIndex && getHeap()[rightChildIndex(i)] < getHeap()[minPos]) {
                minPos = rightChildIndex(i);
            }
            if (minPos == i) break;
            swap(i, minPos);
            i = minPos;
        }
    }

    public static void main(String[] args) {
        int[] data = {7,5,19,8,4,1,20,13,16};
        System.out.println("--- before build a min heap ---");
        MyMinHeap minHeap = new MyMinHeap(data, 100);
        //should print
        //7
        //5 19
        //8 4 1 20
        //13 16
        minHeap.printHeap();
        System.out.println("--- after build a min heap ---");
        minHeap.buildHeap();
        //1
        //4 7
        //8 5 19 20
        //13 16
        minHeap.printHeap();
        System.out.println("--- insert ---");
        minHeap.insert(14);
        //1
        //4 7
        //8 5 19 20
        //13 16 14
        minHeap.printHeap();
        System.out.println("--- remove max ---");
        minHeap.removeTop();
        //4
        //5 7
        //8 14 19 20
        //13 16
        minHeap.printHeap();
        System.out.println("--- sort ---");
        minHeap.sort();
        //20
        //19 16
        //14 13 8 7
        //5 4
        minHeap.printHeap();
    }
}
