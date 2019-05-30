package cn.zhou9.myArrayList;

/**
 * 增加get和set方法
 * 增加数组边界检查
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9.myArrayList
 * @version: 4.0
 */
public class MyArrayList04<E> {

    private Object[] elementData; //默认为null
    private int size; //默认为0
    private static final int DEFAULT_CAPACITY = 10; //默认容量为10

    //无参构造函数默认大小
    public MyArrayList04() {
        //new对象后即有地址
        elementData = new Object[DEFAULT_CAPACITY];
    }
    //有参构造函数指定大小
    public MyArrayList04(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("容器容量不能为负数：" + capacity);
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
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

    public E get(int index) {
        checkIndex(index);
        return (E)elementData[index];
    }
    public void set(E element, int index) {
        checkIndex(index);
        elementData[index] = element;
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
        MyArrayList04<Integer> arr4 = new MyArrayList04<>(2);
        arr4.add(1);
        arr4.add(1);
        arr4.add(1);
        arr4.add(1);
        arr4.set(2, 0);
    }
}
