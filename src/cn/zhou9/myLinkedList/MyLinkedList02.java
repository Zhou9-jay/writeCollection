package cn.zhou9.myLinkedList;

/**
 * 增加get方法
 * @Auther: CN.Zhou9
 * @Date: 2019/5/23
 * @Description: cn.zhou9.myLinkedList
 * @version: 2.0
 */
public class MyLinkedList02 {

    private Node first;
    private Node last;
    private int size;

    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
        System.out.println(size);
    }

    public Object get(int index) throws RuntimeException {
        //手动抛出异常，索引数字不合法。
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
        Node temp;
        if (index <= (size >> 1)) { //size>>1相当于除以2
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }
        System.out.println("temp为：" + temp + ",temp.element为：" + temp.element);
        System.out.println("temp.next为：" + temp.next);
        System.out.println("temp.next.element为：" + temp.next.element);
        return temp.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList02 mll2 = new MyLinkedList02();
        mll2.add("a");
        mll2.add("b");
        mll2.add("c");
        mll2.add("d");
        mll2.add("e");
        mll2.add("f");
        System.out.println(mll2.get(3));
    }
}
