package datastruct.linkedlist.dll;

/**
 * Implement of doubly linked list
 * @param <T>
 */
public class DLinkedList<T> {
    
    private int size = 0;
    private DNode<T> head = null;
    private DNode<T> tail = null;

    /**
     * insert a new element in the front of list
     * @param data
     */
    public void addFirst(T data) {
        DNode<T> newNode = new DNode<T>(data);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            DNode<T> oldHead = head;
            newNode.next = oldHead;
            oldHead.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * insert a new element at the end of list
     * @param data
     */
    public void addLast(T data) {
        DNode<T> newNode = new DNode<T>(data);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            DNode<T> oldTail = tail;
            oldTail.next = newNode;
            newNode.prev = oldTail;
            tail = newNode;
        }
        size++;
    }

    /**
     * insert a new node at the given position.
     * If the position is after the end of the list, insert the new node at the end.
     * e.g, if the list is 5->6->2, insert(10, 1), then result is 5->10->6->2
     * @param data
     * @param pos
     */
    public void insert(T data, int pos) {
        if (pos < 0) return;
        DNode<T> newNode = new DNode<T>(data);
        if (pos == 0) {
            //add as the head node
            addFirst(data);
        } else {
            if (pos >= size) {
                addLast(data);
            } else {
                DNode prevTemp = head;
                for (int i = 1; i < pos; i++) {
                    prevTemp = prevTemp.next;
                }
                DNode nextTemp = prevTemp.next;
                newNode.next = nextTemp;
                newNode.prev = prevTemp;
                prevTemp.next = newNode;
                nextTemp.prev = newNode;
                size++;
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size || size == 0) return;
        if (index == 0) {
            //remove the head element
            DNode nextNode = head.next;
            head = nextNode;
            nextNode.prev = null;
            size--;
        } else {
            DNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            DNode prevDNode = temp.prev;
            if (temp == tail) {
                prevDNode.next = null;
                tail = prevDNode;
                size--;
                return;
            }
            DNode nextDNode = temp.next;
            prevDNode.next = nextDNode;
            nextDNode.prev = prevDNode;
            size--;
        }
    }

    public void removeByValue(T data) {
        //TODO
    }


    public String list() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        DNode temp = head;
        while (temp.next != null) {
            sb.append(temp.data).append(":");
            System.out.println("Print node: " + temp.data);
            temp = temp.next;
        }
        sb.append(temp.data);
        System.out.println("Print node: " + temp.data);
        return sb.toString();
    }

    /**
     * get the first element
     * @return
     */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * get the last element
     * @return
     */
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
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
