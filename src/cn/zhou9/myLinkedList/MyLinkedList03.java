package cn.zhou9.myLinkedList;

/**
 * 增加remove
 * @Auther: CN.Zhou9
 * @Date: 2019/5/23
 * @Description: cn.zhou9.myLinkedList
 * @version: 3.0
 */
public class MyLinkedList03 {

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
        //System.out.println(size);
    }

    public void remove(int index) {
        Node temp = getNode(index);
        if (temp != null) {
            Node up = temp.previous;
            Node down = temp.next;
            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }
            //被删除的元素是第一个元素时
            if (index == 0) {
                first = down;
            }
            //被删除的元素是最后一个元素时
            if (index == size - 1) {
                last = up;
            }
            size--; //size不能忘
        }
    }

    public Object get(int index) throws RuntimeException {
        //手动抛出异常，索引数字不合法。
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
        Node temp = getNode(index);
        //System.out.println("temp为：" + temp + ",temp.element为：" + temp.element);
        //System.out.println("temp.next为：" + temp.next);
        //System.out.println("temp.next.element为：" + temp.next.element);
        return temp.element;
    }

    //获取指定索引节点
    public Node getNode(int index) {
        Node temp = null;
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = 0; i > index; i--) {
                temp = temp.previous;
            }
        }
        return temp;
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
        MyLinkedList03 mll3 = new MyLinkedList03();
        mll3.add("aa");
        mll3.add("bb");
        mll3.add("cc");
        mll3.add("dd");
        mll3.add("ee");
        System.out.println(mll3);
        System.out.println(mll3.get(4));
        mll3.remove(4);
        System.out.println(mll3);
    }
}
