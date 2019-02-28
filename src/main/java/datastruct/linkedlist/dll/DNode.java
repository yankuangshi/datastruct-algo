package datastruct.linkedlist.dll;

/**
 * doubly linked list node
 * @param <T>
 */
public class DNode<T> {

    public T data;
    public DNode<T> next;
    public DNode<T> prev;

    public DNode(T data) {
        this.data = data;
    }
}
