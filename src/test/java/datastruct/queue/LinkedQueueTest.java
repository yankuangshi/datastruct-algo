package datastruct.queue;

import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {

    @Test
    public void testEnqueue() {
        LinkedQueue<String> q = new LinkedQueue<String>();
        q.enqueue("aa");
        q.enqueue("bb");
        q.enqueue("cc");
        q.enqueue("dd");
        Assert.assertEquals(4, q.size());
        Assert.assertEquals("aa:bb:cc:dd", q.list());
    }

    @Test
    public void testDequeue() {
        LinkedQueue<String> q = new LinkedQueue<String>();
        q.enqueue("aa");
        q.enqueue("bb");
        q.enqueue("cc");
        q.enqueue("dd");
        Assert.assertEquals("aa", q.dequeue());
        Assert.assertEquals(3, q.size());
        Assert.assertEquals("bb:cc:dd", q.list());
    }
}
