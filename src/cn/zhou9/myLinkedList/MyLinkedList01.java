package cn.zhou9.myLinkedList;

/**
 * 自定义一个链表
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9.myLinkedList
 * @version: 1.0
 */
public class MyLinkedList01 {

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
        MyLinkedList01 mll1 = new MyLinkedList01();
        mll1.add("ss");
        mll1.add("bb");
        System.out.println(mll1);
    }
}
