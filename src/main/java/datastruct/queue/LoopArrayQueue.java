package datastruct.queue;

/**
 * 循环队列（基于数组）的简单实现
 */
public class LoopArrayQueue<T> {

    private T[] a;
    private int size;
    private int n;
    private int head = 0;
    private int tail = 0;

    public LoopArrayQueue(int capacity) {
        a = (T[])new Object[capacity];
        size = 0;
        n = capacity;
    }

    public LoopArrayQueue() {
        this(10);
    }

    public void enqueue(T e) {
        if ((tail+1)%n==head) {
            //队满
            throw new ArrayIndexOutOfBoundsException("Enqueue failed! Queue is full");
        }
        a[tail] = e;
        tail = (tail+1)%n;
        ++size;
    }

    public T dequeue() {
        if (head == tail) return null;
        T temp = a[head];
        head = (head+1)%n;
        --size;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;   //head=tail
    }

    public String list() {
        StringBuilder sb = new StringBuilder();
        if (tail == head) {
            return "";
        } else if (tail > head) {
            for (int i = head; i < tail-1; i++) {
                System.out.println("Print node: " + a[i]);
                sb.append(a[i]).append(':');
            }
            sb.append(a[tail-1]);
            System.out.println("Print node: " + a[tail-1]);
        } else {
            //head > tail
            for (int i = head; i < n; i++) {
                System.out.println("Print node: " + a[i]);
                sb.append(a[i]);
                if (tail == 0 && i == n-1) {
                    return sb.toString();
                }
                sb.append(':');
            }
            for (int i = 0; i < tail; i++) {
                System.out.println("Print node: " + a[i]);
                sb.append(a[i]);
                if (i == tail-1) {
                    return sb.toString();
                }
                sb.append(':');
            }
        }
        return sb.toString();
    }
}
