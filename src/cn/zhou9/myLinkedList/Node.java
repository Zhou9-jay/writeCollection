package cn.zhou9.myLinkedList;

/**
 * @Auther: CN.Zhou9
 * @Date: 2019/5/22
 * @Description: cn.zhou9.myLinkedList
 * @version: 1.0
 */
public class Node {

    Node previous; //上一个节点
    Node next; //下一个节点
    Object element; //元素数据

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }

    public Node() {
    }
}
