package datastruct.linkedlist.sll;

import datastruct.stack.Stack;

/**
 * Implement of singly linked list
 * @param <T>
 */
public class SLinkedList<T> {
    
    /**
     * size of linked list
     */
    private int size = 0;
    /**
     * pointer to head node
     */
    private SNode<T> head = null;

    /**
     * construct an empty list
     */
    public SLinkedList() {
    }

    /**
     * insert a new node at the end
     * @param data
     */
    public void insert(T data) {
        if (head == null) {
            head = new SNode<T>(data);
            size++;
        } else {
            SNode temp = head;
            //find the last node
            while (temp.next != null) {
                temp = temp.next;
            }
            SNode<T> newSNode = new SNode<T>(data);
            temp.next = newSNode;
            newSNode.next = null;
            size++;
        }

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
        SNode<T> newSNode = new SNode<T>(data);
        if (pos == 0) {
            //add as the head node
            newSNode.next = head;
            head = newSNode;
            size++;
        } else {
            if (pos >= size) {
                //position is after the end of the list, insert at the end
                insert(data);
            } else {
                SNode temp = head;
                for (int i = 1; i < pos; i++) {
                    temp = temp.next;
                }
                newSNode.next = temp.next;
                temp.next = newSNode;
                size++;
            }
        }
    }

    /**
     * search the element at the specified position in the list
     * @param index
     * @return
     */
    public SNode<T> search(int index) {
        if (index < 0 || index >= size) return null;
        SNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * search the 1st element by the given value
     * @param data
     * @return
     */
    public SNode<T> searchByValue(T data) {
        if (size == 0) return null;
        SNode temp = head;
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * remove the element at the specified position in the list
     * e.g: If list is 10->6->5->9->8 remove(1) then result is 10->5->9->8
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= size || size == 0) return;
        if (index == 0) {
            //remove the head element
            SNode nextSNode = head.next;
            head = nextSNode;
            size--;
        } else {
            SNode prevSNode = head;
            SNode currSNode = head.next;
            for (int i = 1; i < index; i++) {
                prevSNode = currSNode;
                currSNode = prevSNode.next;
            }
            //delete currSNode
            prevSNode.next = currSNode.next;
            size--;
        }
    }

    /**
     * remove the 1st element by the given value
     * @param data
     */
    public void removeByValue(T data) {
        if (size == 0) return;
        if (head != null && head.data.equals(data)) {
            head = head.next;
            size--;
        } else {
            SNode prevSNode = head;
            SNode currSNode = head.next;
            while (currSNode != null) {
                if (currSNode.data.equals(data)) {
                    prevSNode.next = currSNode.next;
                    size--;
                    return;
                } else {
                    prevSNode = currSNode;
                    currSNode = prevSNode.next;
                }
            }
        }
    }

    /**
     * reverse the list with the iterative approach
     * e.g: If list is 10->6->5-9, after reverse the list, the result is 9->5->6->10
     * ref: LeetCode 206 https://leetcode.com/problems/reverse-linked-list/description/
     * see: src/main/resources/img/sll-reverse.png
     */
    public void reverse() {
        SNode<T> prevSNode= null;
        SNode<T> nextSNode = null;
        SNode<T> currSNode = head;
        while (currSNode != null) {
            nextSNode = currSNode.next;
            currSNode.next = prevSNode;
            prevSNode = currSNode;
            currSNode = nextSNode;
        }
        head = prevSNode;
    }

    /**
     * reverse the list with the recursive approach
     */
    public void reverseRecursive() {

    }

    /**
     * reverse the list with the stack approach
     */
    public void reverseWithStack() {
        Stack<T> stack = new Stack<T>();
        SNode<T> temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        SLinkedList<T> newSLList = new SLinkedList<T>();
        while (stack.size() > 0) {
            T item = stack.pop();
            newSLList.insert(item);
        }
        head = newSLList.head;
    }

    public String list() {
        StringBuilder sb = new StringBuilder();
        SNode temp = head;
        while (temp.next != null) {
            sb.append(temp.data).append("->");
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
