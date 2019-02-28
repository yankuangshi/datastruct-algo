package datastruct.stack;

/**
 * 基于数组实现的栈：顺序栈
 * 支持扩容和缩容，栈满后扩容到2倍，栈大小小于等于1/4时，缩容到1/2）
 */
public class ArrayStack<T> {

    private T[] a;
    private int size;           //栈中元素个数
    private int initCapacity;   //栈的最初大小

    /**
     * 初始化栈，默认大小为10的数组空间
     */
    public ArrayStack() {
        this(10);
    }

    /**
     * 初始化栈，申请一个大小为k的数组空间
     * @param k
     */
    public ArrayStack(int k) {
        a = (T[]) new Object[k];
        initCapacity = k;
        size = 0;
    }

    /**
     * 入栈
     * @param data
     */
    public void push(T data) {
        if (size == a.length) resize(2*a.length);
        a[size++] = data;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if (size == 0) return null;
        T temp = a[size-1];
        a[size-1] = null;
        --size;
        if (size > 0 && size <= a.length/4 && initCapacity <= a.length/2) //缩容最小至原始栈大小
            resize(a.length/2);
        return temp;
    }

    /**
     * 调整栈大小
     */
    public void resize(int length) {
        T[] temp = (T[])new Object[length];
        for (int i = 0; i < size; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public T peek() {
        return a[size-1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
