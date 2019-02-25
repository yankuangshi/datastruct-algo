package datastruct.heap;

public class Heap {

    private int[] a;        //数组，从下标1开始存储数据
    private int max;   //堆中可以存储的最大数据个数
    private int count;      //堆中已经存储的数据个数

    public Heap(int capacity) {
        //堆的初始化
        a = new int[capacity + 1];
        max = capacity;
        count = 0;
    }

    //新插入的元素放到堆的最后，然后进行"堆化"
    //堆化的过程（以大顶堆为例）：新插入的节点与父节点对比大小，如果大于父节点则互换两个节点，
    // 一直重复这个过程直到满足大小关系（子节点小于等于父节点）
    public void insert(int data) {
        if (count >= max) return;   //堆满了
        ++count;
        a[count] = data;    //新插入的元素放到数组最末尾，也即堆的最后
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {
            //新插入的节点值大于父节点值
            swap(a, i, i/2);    //交换下标i和i/2的元素
            i = i/2;
        }
    }

    //删除堆顶元素（已大顶堆为例），即删除最大值
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];    //把最后一个元素移至堆顶
        --count;
        heapify(a, count, 1);
    }

    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int i = n; //从最后一个开始
        while (i>1) {
            swap(a, 1, i); //和堆顶元素交换
            --i;
            heapify(a, i, 1);//从堆顶元素开始堆化
        }
    }

    //从数组"原地"构建堆
    private void buildHeap(int[] a, int n) {
         //最后一个非叶子节点下标n/2
        for (int i = n/2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    //从上而下堆化
    //下标为i的当前节点的左子节点的下标为i*2，右子节点的下标为i*2+1
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;    //如果左子节点大，记录maxPos为左子节点下标
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1; //如果右子节点更大，记录maxPos为右子节点下标
            if (maxPos == i) break; //对比完左右子节点，若maxPos没有发生变化，则说明当前节点比左右子节点都大，则直接跳出
            //否则，交换
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
