package cn.zhou9.myArrayList;

/**
 * 自定义实现一个ArrayList
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9
 * @version: 1.0
 */
public class MyArrayList01 {

    private Object[] elementData; //默认为null
    private int size; //默认为0
    private static final int DEFAULT_CAPACITY = 10; //默认容量为10

    //无参构造函数默认大小
    public MyArrayList01() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    //有参构造函数指定大小
    public MyArrayList01(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(Object obj) {
        elementData[size++] = obj;
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
        MyArrayList01 arr1 = new MyArrayList01();
        System.out.println(arr1.elementData);
        System.out.println(arr1.size);
        System.out.println(arr1.toString());
        arr1.add(1);
        arr1.add("jay");
        System.out.println(arr1.elementData);
        System.out.println(arr1.size);
        System.out.println(arr1.toString());
    }
}
