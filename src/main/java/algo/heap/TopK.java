package algo.heap;

import datastruct.heap.MyMinHeap;

import java.util.Arrays;
import java.util.Random;

/**
 * 利用小顶堆求Top-K问题
 *
 * 思路：维护一个大小为K的小顶堆，先把这组数据的前K个元素插入小顶堆中，之后遍历剩下的数组，
 * 如果比堆顶元素大，就把堆顶元素删除，并且将这个元素放入堆顶，重新堆化；
 * 如果比堆顶元素小，继续遍历数组，直到遍历完成，堆中的数据就是前K大的数据
 */
public class TopK {

    public static int[] getTopK(int[] data, int k) {
        if (data.length <= k) {
            return data;
        }

        //把数组中前k个元素放入小顶堆
        MyMinHeap minHeap = new MyMinHeap(Arrays.copyOfRange(data, 0, k), k);
        minHeap.buildHeap();

        for (int i = k; i < data.length; i++) {
            if (data[i] > minHeap.getTop()) {
                minHeap.removeTop();
                minHeap.insert(data[i]);
            }
        }

        return minHeap.getData();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] a = new int[20];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(String.format("--- Top %s ---", k));
        int[] topk = TopK.getTopK(a, k);
        System.out.println(Arrays.toString(topk));
    }
}
