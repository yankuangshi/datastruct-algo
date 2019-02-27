package datastruct.array;

/**
 * Array的简单实现，不考虑扩容
 */
public class MyArray {

    private int[] data;
    private int n;
    private int count;

    public MyArray(int capacity) {
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    //下标index处插入元素，不考虑扩容问题
    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("数组已满");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.println("插入位置错误");
            return false;
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //删除下标index的元素
    public boolean remove(int index) {
        if (count == 0) {
            System.out.println("数组为空");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.println("删除位置错误");
            return false;
        }
        for (int i = index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public int find(int index) {
        if (index < 0 || index > count) return -1;
        return data[index];
    }

    public void print() {
        if (count == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; ; i++) {
            b.append(data[i]);
            if (i == count-1) {
                System.out.println(b.append("]").toString());
                return;
            }
            b.append(", ");
        }
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(10);
        array.print();
        array.insert(0, 1);
        array.insert(0, 2);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(0, 5);
        array.print();
        array.remove(0);
        array.remove(0);
        array.print();
    }
}
