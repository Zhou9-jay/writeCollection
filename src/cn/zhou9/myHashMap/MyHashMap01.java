package cn.zhou9.myHashMap;

/**
 * 自定义一个HashMap
 * 实现put方法增加键值对
 * 解决了键重复时相应的节点
 * @Auther: CN.Zhou9
 * @Date: 2019/5/24
 * @Description: cn.zhou9.myHashMap
 * @version: 1.0
 */
public class MyHashMap01 {
    Node[] table; //位桶数组
    int size; //存放键值对的个数

    public MyHashMap01() {
        table = new Node[16]; //长度一般定义为2的整数幂
    }

    public void put(Object key, Object value) {
        //定义了新的节点对象
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;
        Node temp = table[newNode.hash]; //到达位桶数组的指定位置
        Node iterLast = null; //正在遍历的最后一个元素
        boolean keyRepeat = false; //默认键重复为false
        if (temp == null) {
            //此处数组元素为空，则直接将新节点放进去。
            table[newNode.hash] = newNode;
        } else {
            //此处数组元素不为空，则遍历对应链表。
            while (temp != null) {
                //判断Key如果重复则覆盖
                if (temp.key.equals(key)) {
                    keyRepeat = true;
                    temp.value = value; //只需覆盖value即可
                    break;
                } else {
                    //key不重复则遍历下一个
                    iterLast = temp; //全局变量最后一个元素标记
                    temp = temp.next;
                }
            }
            if (!keyRepeat) { //如果没有发生key重复的情况则添加到链表最后
                iterLast.next = newNode;
            }
        }
    }

    public static int myHash(int h, int length) {
        //System.out.println("位运算myHash" + (h & (length - 1))); //效率高
        //System.out.println("取余运算myHash" + (h % (length - 1))); //效率低
        return h & (length - 1);
    }

    public static void main(String[] args) {
        MyHashMap01 m1 = new MyHashMap01();
        m1.put(1, "a");
        m1.put(2, "b");
        m1.put(3, "c");
        m1.put(4, "d");
        System.out.println(m1);
    }
}
