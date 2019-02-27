package algo.heap;

import datastruct.heap.MaxHeap_PQ;
import datastruct.heap.MinHeap_PQ;

import java.util.PriorityQueue;

/**
 * 利用大顶堆和小顶堆求中位数
 *
 * 解决思路：维护2个堆（一个大顶堆一个小顶堆），大顶堆存储前半部分数据，小顶堆存储后半部分数据，且小顶堆数据大于大顶堆数据
 *
 * 例如：如果n是偶数，那么前n/2个数据存储在大顶堆中，后n/2个数据存储在小顶堆中；如果n是奇数，前n/2+1个数据存储在大顶堆，后n/2个数据存储在小顶堆；那么大顶堆的堆顶元素就是中位数。
 *
 * 当添加一个新数据时，如果新元素大于等于大顶堆堆顶元素，则新数据加入小顶堆，否则加入大顶堆。
 *
 * 随着数据的加入和删除，大顶堆和小顶堆的个数会出现失衡，也就是不再符合先前约定的n/2和n/2、或者n/2+1和n/2，这种情况就需要移动2个堆的堆顶元素来再次实现平衡。比如：
 *
 * //中位数13，[7,8,9,13,15,20,21,30] n=8
 *
 * MaxHeap     MinHeap
 *    13      15
 *    /\      /\
 *   8  9    20 21
 *  /       /
 * 7       30
 *
 * //插入16（大于大顶堆堆顶13，插入小顶堆）
 *
 * MaxHeap     MinHeap
 *    13      15
 *    /\      /\
 *   8  9   16 21
 *  /       /\
 * 7       30 20
 *
 * //不再符合大顶堆5个和小顶堆4个的规格（总个数n=9），把小顶堆堆顶数据移动到大顶堆，中位数15
 *
 * MaxHeap     MinHeap
 *    15      16
 *   / \      /\
 *  13 9    20 21
 *  /\      /
 * 7  8    30
 */
public class MidNumSolver {

    private MaxHeap_PQ maxHeap;
    private MinHeap_PQ minHeap;
    private int count;

    public MidNumSolver() {
        maxHeap = new MaxHeap_PQ();
        minHeap = new MinHeap_PQ();
        count = 0;
    }

    public void add(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            add(nums[i]);
        }
    }

    public void add(int num) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.insert(num);
            count++;
            return;
        }
        if (num > maxHeap.getTop()) {
            minHeap.insert(num);
        } else {
            maxHeap.insert(num);
        }
        count++;
        balance();
    }

    public void balance() {
        if ((maxHeap.getSize() - minHeap.getSize()) > 1) {
            //move from max heap to min heap
            int tmp = maxHeap.removeTop();
            minHeap.insert(tmp);
            return;
        }
        if ((minHeap.getSize() - maxHeap.getSize()) > 0) {
            //move from min heap to max heap
            int tmp = minHeap.removeTop();
            maxHeap.insert(tmp);
            return;
        }
    }

    public int getMidNum() {
        return maxHeap.getTop();
    }

    public void printHeaps() {
        System.out.println("--- max heap ---");
        maxHeap.printHeap();
        System.out.println("--- min heap ---");
        minHeap.printHeap();
    }

    public static void main(String[] args) {
        int[] a = {7,8,13,20,15,30,21,9};
        MidNumSolver midNumSolver = new MidNumSolver();
        midNumSolver.add(a);
        midNumSolver.printHeaps();
        System.out.println("--- mid num ---");
        System.out.println(midNumSolver.getMidNum());
        System.out.println("--- now insert 16 ---");
        midNumSolver.add(16);
        midNumSolver.printHeaps();
        System.out.println("--- mid num ---");
        System.out.println(midNumSolver.getMidNum());
    }

}
