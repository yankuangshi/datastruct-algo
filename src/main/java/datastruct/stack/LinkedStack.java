package datastruct.stack;

/**
 * 基于链表实现的栈：链式栈
 */
public class LinkedStack<T> {

    private class Node<T> {
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size = 0;
    private Node<T> top = null;

    /**
     * 压栈
     *
     * node1 <- node2
     *            ^
     *           top
     *
     * node3压入栈
     *
     * node3->next = top(node2)
     * top = node3
     *
     * node1 <- node2 <- node3
     *                     ^
     *                    top
     *
     * @param data
     */
    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if (top != null) {
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
        return null;
    }

    /**
     * 返回栈顶数据但不出栈
     */
    public T peek() {
        if (top != null) {
            return top.data;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
