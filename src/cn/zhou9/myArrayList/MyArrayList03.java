package cn.zhou9.myArrayList;

/**
 * 增加数组扩容功能
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9.myArrayList
 * @version: 3.0
 */
public class MyArrayList03<E> {

    private Object[] elementData; //默认为null
    private int size; //默认为0
    private static final int DEFAULT_CAPACITY = 10; //默认容量为10

    //无参构造函数默认大小
    public MyArrayList03() {
        //new对象后即有地址
        elementData = new Object[DEFAULT_CAPACITY];
    }
    //有参构造函数指定大小
    public MyArrayList03(int capacity) {
        elementData = new Object[capacity];
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
        MyArrayList03<Integer> arr3 = new MyArrayList03<>(2);
        System.out.println(arr3.elementData);
        System.out.println(arr3.size);
        System.out.println(arr3.toString());
        arr3.add(1);
        arr3.add(2);
        System.out.println(arr3.elementData);
        System.out.println(arr3.size);
        System.out.println(arr3.toString());
        arr3.add(3);
        System.out.println(arr3.elementData);
        System.out.println(arr3.size);
        System.out.println(arr3.toString());
    }
}
