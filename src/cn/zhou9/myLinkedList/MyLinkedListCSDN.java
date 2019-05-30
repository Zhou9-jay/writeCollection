package cn.zhou9.myLinkedList;

/**
 * CSDN重写LinkedList toString()方法
 * @Auther: CN.Zhou9
 * @Date: 2019/5/23
 * @Description: cn.zhou9.myLinkedList
 * @version: 1.0
 */

public  class MyLinkedListCSDN {

    private Node firstNode; //首节点
    private Node lastNode; //尾节点
    private int size; //元素个数

    //定义一个节点类（这是一个内部类）
    class Node{

        Node prev; //上一个节点
        Object obj;//保存元素
        Node next; //下一个节点

        Node(Node prev, Object obj, Node next) {
            super();
            this.prev = prev;
            this.obj = obj;
            this.next = next;
        }
        public Node() {

        }
    }

    //添加方法
    public boolean add(Object obj){
        //第一次添加元素，创建一个节点，节点的首尾为null.中间为元素本身
        Node newNode = new Node(null, obj, null);
        if(lastNode==null){
            //设置首尾节点都为newNode
            firstNode = newNode;
            lastNode  = newNode;
        }else{
            //将新的节点和上一个节点的next连接起来
            lastNode.next = newNode;
            newNode.prev = lastNode;
            //更新尾节点
            lastNode = newNode;
        }
        size++; //元素个数+1
        return true;
    }
    //获取元素个数
    public int size(){

        return size;
    }

    //重写toString
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        //拼接第一个元素
        sb.append(this.firstNode.obj);
        //获取当前节点的下一个节点
        Node node = this.firstNode.next;
        for(int i=0;i<size-1;i++ ){
            sb.append(",");
            //拼接每个节点的值
            sb.append(node.obj);
            //拼接完成让当前节点指向下一个节点
            //读取第一个为node.obj
            //第二个为node.next.obj
            //第三个为node.nexe.next.obj
            // 所以每次读下一个就是多加一个next对他进行一个拼接就可以完成			          node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedListCSDN ml = new MyLinkedListCSDN();
        ml.add(10);
        ml.add(20);
        ml.add(30);
        ml.add(40);
        ml.add(50);
        System.out.println(ml);
        System.out.println(ml.size());
    }
}