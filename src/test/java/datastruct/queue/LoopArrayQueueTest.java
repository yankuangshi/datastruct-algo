package datastruct.queue;

import org.junit.Assert;
import org.junit.Test;

public class LoopArrayQueueTest {

    @Test
    public void testEnqueue() {
        LoopArrayQueue<String> loopArrayQueue = new LoopArrayQueue<>(10);
        loopArrayQueue.enqueue("aa");
        loopArrayQueue.enqueue("bb");
        loopArrayQueue.enqueue("cc");
        loopArrayQueue.enqueue("dd");
        loopArrayQueue.enqueue("ee");
        Assert.assertEquals(5, loopArrayQueue.size());
        Assert.assertEquals("aa:bb:cc:dd:ee", loopArrayQueue.list());
    }

    //测试循环队列会浪费一个数组空间
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testEnqueueOutOfBounds() {
        LoopArrayQueue<String> loopArrayQueue = new LoopArrayQueue<>(5);
        loopArrayQueue.enqueue("aa");
        loopArrayQueue.enqueue("bb");
        loopArrayQueue.enqueue("cc");
        loopArrayQueue.enqueue("dd");
        loopArrayQueue.enqueue("ee");
    }

    @Test
    public void testDequeue() {
        LoopArrayQueue<String> loopArrayQueue = new LoopArrayQueue<>(5);
        loopArrayQueue.enqueue("aa");
        loopArrayQueue.enqueue("bb");
        loopArrayQueue.dequeue();
        loopArrayQueue.dequeue();
        Assert.assertEquals(null, loopArrayQueue.dequeue());
        loopArrayQueue.enqueue("cc");
        loopArrayQueue.enqueue("dd");
        loopArrayQueue.enqueue("ee");
        loopArrayQueue.enqueue("ff");
        Assert.assertEquals(4, loopArrayQueue.size());
        Assert.assertEquals("cc:dd:ee:ff", loopArrayQueue.list());
    }
}
