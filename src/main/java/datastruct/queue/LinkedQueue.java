package datastruct.queue;

/**
 * 链式队列（基于链表）的简单实现
 * @param <T>
 */
public class LinkedQueue<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * 尾部入队
     * @param data
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);
        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 头部出队
     * @return
     */
    public T dequeue() {
        if (head != null) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
        return null;
    }

    public String list() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            sb.append(temp.data).append(":");
            System.out.println("Print node: " + temp.data);
            temp = temp.next;
        }
        sb.append(temp.data);
        System.out.println("Print node: " + temp.data);
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
