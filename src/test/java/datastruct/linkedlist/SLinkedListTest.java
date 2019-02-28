package datastruct.linkedlist;

import datastruct.linkedlist.sll.SLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SLinkedListTest {

    @Test
    public void testInsertInteger() {
        SLinkedList<Integer> list = new SLinkedList<Integer>();
        list.insert(10);
        list.insert(6);
        list.insert(22);
        list.insert(45);

        Assert.assertEquals("10->6->22->45", list.list());
        Assert.assertEquals(4, list.size());
    }



    @Test
    public void testInsertString() {
        SLinkedList<String> list = new SLinkedList<String>();
        list.insert("aa");
        list.insert("bb");
        list.insert("ww");
        list.insert("zz");

        Assert.assertEquals("aa->bb->ww->zz", list.list());
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void testInsertAtPosition() {
        SLinkedList<Integer> list = new SLinkedList<Integer>();
        list.insert(10);
        list.insert(6);
        list.insert(22);
        list.insert(45);
        System.out.println("--- insert 4 at position 4 (at the end) ---");
        list.insert(4, 4);
        Assert.assertEquals("10->6->22->45->4", list.list());
        Assert.assertEquals(5, list.size());
        System.out.println("--- insert 18 at position 10 (at the end) ---");
        list.insert(18, 10);
        Assert.assertEquals("10->6->22->45->4->18", list.list());
        Assert.assertEquals(6, list.size());
        System.out.println("--- insert 56 at position 1 ---");
        list.insert(56, 1);
        Assert.assertEquals("10->56->6->22->45->4->18", list.list());
        Assert.assertEquals(7, list.size());
        System.out.println("--- insert 5 at position 0 (at the first) ---");
        list.insert(5, 0);
        Assert.assertEquals("5->10->56->6->22->45->4->18", list.list());
        Assert.assertEquals(8, list.size());
    }

    @Test
    public void testSearch() {
        SLinkedList<Integer> list = new SLinkedList<Integer>();
        list.insert(10);
        list.insert(6);
        list.insert(22);
        list.insert(45);
        Assert.assertEquals(6, (int) list.search(1).data);
        Assert.assertEquals(null, list.search(10));
    }

    @Test
    public void testSearchByValue() {
        SLinkedList<String> list = new SLinkedList<String>();
        list.insert("aa");
        list.insert("bb");
        list.insert("tt");
        list.insert("kk");
        Assert.assertEquals("tt", list.searchByValue("tt").data);
    }

    @Test
    public void testRemove() {
        SLinkedList<String> list = new SLinkedList<String>();
        list.remove(0);
        Assert.assertEquals(0, list.size());
        list.insert("aa");
        list.insert("bb");
        list.insert("tt");
        list.insert("kk");
        list.list();
        System.out.println("--- remove at position 1");
        list.remove(1);
        Assert.assertEquals("aa->tt->kk", list.list());
    }

    @Test
    public void testRemoveByValue() {
        SLinkedList<String> list = new SLinkedList<String>();
        list.removeByValue("aa");
        Assert.assertEquals(0, list.size());
        list.insert("aa");
        list.insert("bb");
        list.insert("tt");
        list.insert("kk");
        list.list();
        System.out.println("--- remove cc ---");
        list.removeByValue("cc");
        Assert.assertEquals("aa->bb->tt->kk", list.list());
        System.out.println("--- remove tt ---");
        list.removeByValue("tt");
        Assert.assertEquals("aa->bb->kk", list.list());
    }

    @Test
    public void testReverse() {
        SLinkedList<String> list = new SLinkedList<String>();
        list.insert("aa");
        list.insert("bb");
        list.insert("tt");
        list.insert("kk");
        Assert.assertEquals("aa->bb->tt->kk", list.list());
        list.reverse();
        System.out.println("--- after reverse ---");
        Assert.assertEquals("kk->tt->bb->aa", list.list());
    }

    @Test
    public void testReverseWithStack() {
        SLinkedList<String> list = new SLinkedList<String>();
        list.insert("aa");
        list.insert("bb");
        list.insert("tt");
        list.insert("kk");
        Assert.assertEquals("aa->bb->tt->kk", list.list());
        list.reverseWithStack();
        System.out.println("--- after reverse ---");
        Assert.assertEquals("kk->tt->bb->aa", list.list());
    }
}
