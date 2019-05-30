package cn.zhou9.myLinkedList;

/**
 * 插入节点
 * @Auther: CN.Zhou9
 * @Date: 2019/5/23
 * @Description: cn.zhou9.myLinkedList
 * @version: 1.0
 */
public class MyLinkedList04 {

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

    public void add(int index, Object obj) {
        Node newNode = new Node(obj);
        Node temp = getNode(index);
        if (temp != null) {
            if (index == 0) { //第一个位置插入
                temp.previous = newNode;
                //temp.previous.next = temp;
                newNode.next = temp;
                newNode.previous = null;
                first = newNode;
            } else if (index == size - 1) { //最后插入
                newNode.previous = last;
                newNode.next = null;
                last.next = newNode;
                last = newNode;
            } else {
                temp.previous.next = newNode;
                newNode.next = temp;
                temp.previous = newNode;
            }
            size++;
        }
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
        return temp != null ? temp.element : null;
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
        MyLinkedList04 mll4 = new MyLinkedList04();
        mll4.add("aa");
        mll4.add("bb");
        mll4.add("cc");
        System.out.println(mll4);
        mll4.add(1, "qq");
        System.out.println(mll4);
        mll4.add(3, "qq");
        System.out.println(mll4);
        mll4.add(0, "qq");
        System.out.println(mll4);
    }
}
