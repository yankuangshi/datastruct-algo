package datastruct.queue;

/**
 * 顺序队列（基于数组）的简单实现
 */
public class ArrayQueue<T> {

    private T[] a;
    private int size;
    private int n;
    private int head = 0;   //队首下标
    private int tail = 0;   //队尾下标，队尾下标是数组最末元素的后一个下标，最大是tail=n

    //初始化队列内数组
    public ArrayQueue(int capacity) {
        a = (T[])new Object[capacity];
        n = capacity;
    }

    //无参构造 默认数组大小10
    public ArrayQueue() {
        this(10);
    }

    //入队
    //队满的真实条件是 head=0 && tail=n
    public void enqueue(T e) {
        if (tail == n) {
            if (head == 0) //队满
                throw new ArrayIndexOutOfBoundsException("Enqueue failed! Queue is full");
            //集中触发数据搬移
            for (int i = head; i < tail; i++) {
                a[i-head] = a[i];
            }
            //搬移完成后重新更新head和tail
            tail = tail - head;
            head = 0;
        }
        a[tail++] = e;
        ++size;
    }

    public T dequeue() {
        if (head == tail) return null; //队空
        T temp = a[head++];
        --size;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return  head == tail;
    }

    public String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i < tail-1; i++) {
            System.out.println("Print node: " + a[i]);
            sb.append(a[i]).append(':');
        }
        sb.append(a[tail-1]);
        System.out.println("Print node: " + a[tail-1]);
        return sb.toString();
    }

}
