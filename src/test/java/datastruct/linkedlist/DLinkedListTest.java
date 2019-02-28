package datastruct.linkedlist;

import datastruct.linkedlist.dll.DLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class DLinkedListTest {

    @Test
    public void testAddFirst() {
        DLinkedList<Integer> list = new DLinkedList<Integer>();
        list.addFirst(1);
        list.addFirst(5);
        list.addFirst(2);
        list.addFirst(9);
        list.addFirst(10);
        Assert.assertEquals(5, list.size());
        Assert.assertEquals("10:9:2:5:1", list.list());
        Assert.assertEquals(10, (int) list.getFirst());
    }

    @Test
    public void testAddLast() {
        DLinkedList<Integer> list = new DLinkedList<Integer>();
        list.addLast(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(9);
        list.addLast(10);
        Assert.assertEquals(5, list.size());
        Assert.assertEquals("1:5:2:9:10", list.list());
        Assert.assertEquals(10, (int) list.getLast());
    }

    @Test
    public void testInsert() {
        DLinkedList<Integer> list = new DLinkedList<Integer>();
        list.addLast(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(9);
        list.addLast(10);
        list.list();
        System.out.println("--- insert 6 at pos 0 ---");
        list.insert(6, 0);
        Assert.assertEquals("6:1:5:2:9:10", list.list());
        System.out.println("--- insert 7 at pos 6 (at the end) ---");
        list.insert(7, 6);
        Assert.assertEquals("6:1:5:2:9:10:7", list.list());
        System.out.println("--- insert 12 at pos 3 ---");
        list.insert(12, 3);
        Assert.assertEquals("6:1:5:12:2:9:10:7", list.list());
    }

    @Test
    public void testRemove() {
        DLinkedList<Integer> list = new DLinkedList<Integer>();
        list.remove(0);
        Assert.assertEquals(0, list.size());
        list.addLast(1);
        list.addLast(5);
        list.addLast(2);
        list.addLast(9);
        list.addLast(10);
        list.list();
        System.out.println("--- remove the head ---");
        list.remove(0);
        Assert.assertEquals("5:2:9:10", list.list());
        System.out.println("--- remove the tail ---");
        list.remove(3);
        Assert.assertEquals("5:2:9", list.list());
        System.out.println("--- remove at position 1");
        list.remove(1);
        Assert.assertEquals("5:9", list.list());
    }
}
