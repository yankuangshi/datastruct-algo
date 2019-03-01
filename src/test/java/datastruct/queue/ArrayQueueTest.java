package datastruct.queue;

import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {

    @Test
    public void testEnqueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(10);
        arrayQueue.enqueue("aa");
        arrayQueue.enqueue("bb");
        arrayQueue.enqueue("cc");
        arrayQueue.enqueue("dd");
        arrayQueue.enqueue("ee");
        Assert.assertEquals(5, arrayQueue.size());
        Assert.assertEquals("aa:bb:cc:dd:ee", arrayQueue.list());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testEnqueueOutOfBounds() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enqueue("aa");
        arrayQueue.enqueue("bb");
        arrayQueue.enqueue("cc");
        arrayQueue.enqueue("dd");
        arrayQueue.enqueue("ee");
        Assert.assertEquals(5, arrayQueue.size());
        arrayQueue.enqueue("ff");
    }

    @Test
    public void testDequeue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue("aa");
        arrayQueue.enqueue("bb");
        arrayQueue.enqueue("cc");
        arrayQueue.enqueue("dd");
        arrayQueue.enqueue("ee");
        Assert.assertEquals(5, arrayQueue.size());
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        Assert.assertEquals(3, arrayQueue.size());
        Assert.assertEquals("cc:dd:ee", arrayQueue.list());
    }

    @Test
    public void testMovingDataWhenEnqueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enqueue("aa");
        arrayQueue.enqueue("bb");
        arrayQueue.enqueue("cc");
        arrayQueue.enqueue("dd");
        arrayQueue.enqueue("ee");
        Assert.assertEquals(5, arrayQueue.size());
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue("ff");
        Assert.assertEquals(4, arrayQueue.size());
        Assert.assertEquals("cc:dd:ee:ff", arrayQueue.list());
    }
}
