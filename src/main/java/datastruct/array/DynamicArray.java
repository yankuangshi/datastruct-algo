package datastruct.array;

/**
 * Array的简单实现，支持扩容（2倍）
 */
public class DynamicArray<T> {

    private T[] a;
    private int size;      //数组中元素个数

    //初始化数组
    public DynamicArray(int capacity) {
        a = (T[])new Object[capacity];
        size = capacity;
    }

    //无参构造函数，默认容量10
    public DynamicArray() {
        this(10);
    }

    //获取数组容量
    public int getCapacity() {
        return a.length;
    }

    //获取数组中元素个数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //set index位置的元素
    public void set(int index, T data) {
        checkIndex(index);
        a[index] = data;
    }

    public T get(int index) {
        checkIndex(index);
        return a[index];
    }

    //寻找对应元素所在下标，没有返回-1
    public int find(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T data) {
        if (find(data)>=0)
            return true;
        return false;
    }

    public void add(int index, T data) {
        checkIndexForAdd(index);
        if (size == a.length) {
            //如果已满，扩容2倍
            resize(2 * a.length);
        }
        for (int i = size; i > index; i--) {
            a[i] = a[i-1];
        }
        a[index] = data;
        ++size;
    }

    public void addFirst(T data) {
        add(0, data);
    }

    public void addLast(T data) {
        add(size, data);
    }

    public T remove(int index) {
        checkIndex(index);
        T removeData = a[index];
        for (int i = index+1; i < size; i++) {
            a[i-1] = a[i];
        }
        a[size-1] = null;
        --size;
        if (size == a.length / 4) {
            resize(Math.max(1, a.length / 2));
        }
        return removeData;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size-1);
    }

    public void resize(int capacity) {
        T[] b = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            b[i] = a[i];
        }
        a = b;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(String.format("Array size=%d, capacity=%d \n", size, a.length));
        b.append('[');
        for (int i = 0; i<size ; i++) {
            b.append(a[i]);
            if (i != size-1) {
                b.append(", ");
            }
            b.append(']');
        }
        return b.toString();
    }

    private void checkIndexForAdd(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException(String.format("Index: %d, Size: %d", index, size));
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException(String.format("Index: %d, Size: %d", index, size));
        }
    }
}

