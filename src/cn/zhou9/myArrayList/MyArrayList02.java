package cn.zhou9.myArrayList;

/**
 * 增加泛型
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9
 * @version: 2.0
 */
public class MyArrayList02<E> {

    private Object[] elementData; //默认为null
    private int size; //默认为0
    private static final int DEFAULT_CAPACITY = 10; //默认容量为10

    //无参构造函数默认大小
    public MyArrayList02() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    //有参构造函数指定大小
    public MyArrayList02(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E element) {
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
        MyArrayList02<Integer> arr2 = new MyArrayList02<>();
        System.out.println(arr2.elementData);
        System.out.println(arr2.size);
        System.out.println(arr2.toString());
        arr2.add(1);
        arr2.add(2);
        System.out.println(arr2.elementData);
        System.out.println(arr2.size);
        System.out.println(arr2.toString());
    }
}
