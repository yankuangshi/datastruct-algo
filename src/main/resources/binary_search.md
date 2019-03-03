# 二分查找(1)（Binary Search）

二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，
或者区间被缩小为0。

## 0x0 时间复杂度分析

假设数据大小是n，每次查找后数据都会缩小为原来的一半，最坏情况下，直到查找区间被缩小为空，才停止。

被查找区间的大小变化：n，n/2，n/4，n/8，... ，n/2<sup>k</sup>，可以看出这是一个等比数列。其中n/2<sup>k</sup>=1时，k的值就是总共缩小的次数，
而每次缩小操作只涉及2个数据的大小比较，所以经过k次区间缩小操作，时间复杂度就是O(k)。通过n/2<sup>k</sup>=1，可以求得`k=log<sub>2</sub>n`，
所以时间复杂度是O(logn)

### 0x01 认识对数时间复杂度O(logn)

1. 这是一种极其高效的时间复杂度，有时甚至比时间复杂度是常量级的O(1)还高效，为什么？
2. logn是一个非常"恐怖"的数量级，即便n非常非常大，对应的logn也很小。比如n=2^32，大约是42亿，如果我们在42亿个数据中用二分查找一个数据，最多只需要比较32次
3. 用大O标记法表示时间复杂度，会省略掉常数、系数和低阶。对于常量级时间复杂度的算法，O(1)可能表示的是一个非常大的值，比如O(1000)、O(10000)

## 0x1 二分查找的实现

### 0x11 非递归方法

代码实现如下：

```java
public int binarySearch(int[] a, int n, int value) {
    int low = 0;
    int high = n-1;
    while(low <= high) {
        int mid = (low+high)/2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            low = mid+1;
        } else {
            high = mid-1;
        }
    }
    return -1;
}
```

1. 循环退出条件是`low<=high`，而不是`low<high`
2. 其实`mid=(low+high)/2`这种写法有问题，因为如果low和high比较大的话，两者之和有可能会溢出，改进的方法是写成`mid=low+(high-low)/2`，
如果要将性能优化到极致，可以用位运算`mid=low+((high-low)>>1)`
3. low和high的更新是`low=mid+1`和`high=mid-1`

### 0x12 递归方法

```java
public int binarySearch(int[] a, int n, int value) {
    return binarySearchInternally(a, 0, n-1, value);
}

private int binarySearchInternally(int[] a, int low, int high, int value) {
    if (low > high) return -1;
    
    int mid = low + ((high-low)>>1);
    if (a[mid] == value) return mid;
    else if (a[mid] < value) {
        return binarySearchInternally(a, mid+1, high, value);
    } else {
        return binarySearchInternally(a, low, mid-1, value);
    }
}
```

## 0x2 二分查找应用场景的局限性

1. 二分查找依赖的是顺序表结构，就是数组。

    如果是链表，不可以，因为二分查找需要按照小标随即访问元素
        
2. 二分查找针对的是有序数据

    如果数据无序，需要先排序，排序的时间复杂度最低是O(nlogn)，所以针对的是一组静态的数据，没有频繁地插入、删除，
    可以进行一次排序，多次二分查找；针对动态变化的数据集合，二分查找将不再适合

3. 数据量太小不适合二分查找

    如果处理的数据量很小，没有必要用二分查找，顺序遍历就足够，只有数据量比较大，二分查找的优势才会比较明显。
    不过有个例外，如果数据之间的比较操作非常耗时，不管数据量大小，都推荐使用二分查找，因为我们需要尽可能地减少
    比较次数，而比较次数的减少会大大提高效率
   
4. 数据量太大也不适合二分查找

    因为二分查找的底层依赖于数组，而数组为了支持随即访问的特性，要求内存空间连续，所以如果数据量太多，就无法在内存中申请足够的连续内存空间
    
## 0x3 思考

假设我们有 1000 万个整数数据，每个数据占 8 个字节，如何设计数据结构和算法，快速判断某个整数是否出现在这 1000 万数据中？
我们希望这个功能不要占用太多的内存空间，最多不要超过 100MB

<details>
<summary>点击展开</summary>
1000万个整数，每个数据占8个字节，都存在内存里差不多占80MB，符合内存的限制，可以先对1000万数据从小到大排序，然后再利用二分查找算法

如果用散列表或者二叉树来解决，都会需要额外的内存空间，用100MB的内存是存不下的，而二分查找底层依赖的是数组，是最省内存空间的存储方式
</details>    
    