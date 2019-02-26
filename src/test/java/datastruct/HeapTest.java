package datastruct;

import datastruct.heap.MyMaxHeap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapTest {

    @Test
    public void testBuildHeapWithHeapifyUp() {
        int[] data = {7,5,19,8,4,1,20,13,16};
        MyMaxHeap heap = new MyMaxHeap(100);
        for (int i = 0, len = data.length; i < len; i++) {
            heap.insert(data[i]);
        }
        Assert.assertEquals("[20, 16, 19, 13, 4, 1, 7, 5, 8]", Arrays.toString(heap.getData()));
    }

    @Test
    public void testBuildWithHeapifyDown() {
        int[] data = {7,5,19,8,4,1,20,13,16};
        MyMaxHeap heap = new MyMaxHeap(data, 100);
        heap.buildHeap();
        Assert.assertEquals("[20, 16, 19, 13, 4, 1, 7, 5, 8]", Arrays.toString(heap.getData()));
    }
}
