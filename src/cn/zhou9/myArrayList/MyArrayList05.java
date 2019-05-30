package cn.zhou9.myArrayList;

/**
 * 增加remove
 * 增加size
 * 增加isEmpty
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9.myArrayList
 * @version: 5.0
 */
public class MyArrayList05<E> {

    private Object[] elementData; //默认为null
    private int size; //默认为0
    private static final int DEFAULT_CAPACITY = 10; //默认容量为10

    //无参构造函数默认大小
    public MyArrayList05() {
        //new对象后即有地址
        elementData = new Object[DEFAULT_CAPACITY];
    }
    //有参构造函数指定大小
    public MyArrayList05(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("容器容量不能为负数：" + capacity);
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
    }

    public E get(int index) {
        checkIndex(index);
        return (E)elementData[index];
    }
    public void set(E element, int index) {
        checkIndex(index);
        elementData[index] = element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void add(E element) {
        //判断是否需要扩容
        if (size == elementData.length) {
            //扩容操作（新数组地址改变）
            Object[] elementDataNew = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, elementDataNew, 0, elementData.length);
            elementData = elementDataNew;
        }
        elementData[size++] = element;
    }

    //移除方法
    public void remove(E element) {
        //element与所有元素进行挨个比较，获得第一个比较为true的，返回。
        for (int i = 0; i < size; i++) {
            //容器中所有的比较操作都用equals而不用==
            if (element.equals(get(i))) {
                //将元素从此处移除
                remove(i);
            }
        }
    }
    public void remove(int index) {
        int numMoved = elementData.length - index -1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        //elementData[size - 1] = null;
        //size--;
        elementData[--size] = null;
    }

    //判断索引合法[0, size)
    public void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            //不合法
            throw new RuntimeException("索引不合法：" + index); //手动抛出异常
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            sb.append("[]");
        } else {
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i] + ",");
            }
            sb.setCharAt(sb.length() - 1, ']');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList05<Integer> arr5 = new MyArrayList05<>();
        arr5.add(1);
        arr5.add(2);
        arr5.add(3);
        arr5.add(4);
        arr5.add(5);
        System.out.println(arr5.toString());
        arr5.remove(2);
        System.out.println(arr5.toString());
        arr5.remove((Integer)2);
        System.out.println(arr5.toString());
    }
}