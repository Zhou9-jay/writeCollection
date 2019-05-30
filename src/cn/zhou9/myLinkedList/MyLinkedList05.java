package cn.zhou9.myLinkedList;

/**
 * 增加泛型
 * 增加小封装
 * @Auther: CN.Zhou9
 * @Date: 2019/5/23
 * @Description: cn.zhou9.myLinkedList
 * @version: 5.0
 */
public class MyLinkedList05<E> {

    private Node first;
    private Node last;
    private int size;

    public void add(E element) {
        Node node = new Node(element);
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

    public void add(int index, E element) {
        /*try {
            checkIndexs(index);
        } catch (RuntimeException e) {
            System.out.println("1");
        }*/
        checkIndexs(index);
        Node newNode = new Node(element);
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
        checkIndexs(index);
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

    public E get(int index) throws RuntimeException {
        checkIndexs(index);
        Node temp = getNode(index);
        //System.out.println("temp为：" + temp + ",temp.element为：" + temp.element);
        //System.out.println("temp.next为：" + temp.next);
        //System.out.println("temp.next.element为：" + temp.next.element);
        return temp != null ? (E)temp.element : null;
    }

    //获取指定索引节点
    private Node getNode(int index) {
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
    //检查索引
    private void checkIndexs(int index) {
        //手动抛出异常，索引数字不合法。
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
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
        MyLinkedList05<String> mll5 = new MyLinkedList05<>();
        mll5.add("aa");
        System.out.println(mll5);
        mll5.add(9, "qq");
        System.out.println(mll5);
    }
}
