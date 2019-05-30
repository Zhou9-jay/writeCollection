package cn.zhou9.myHashMap;

/**
 * 实现toString()方法
 * @Auther: CN.Zhou9
 * @Date: 2019/5/28
 * @Description: cn.zhou9.myHashMap
 * @version: 2.0
 */
public class MyHashMap02 {
    Node[] table; //位桶数组
    int size; //存放键值对的个数

    public MyHashMap02() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        //遍历位桶数组
        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];
            //遍历链表
            while (temp != null) {
                sb.append(temp.key + ":" +temp.value + ",");
                temp = temp.next;
            }
        }
        //System.out.println(sb.length());
        sb.setCharAt(sb.length() - 1, '}'); //从0开始
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap02 m2 = new MyHashMap02();
        m2.put(1, "a");
        m2.put(2, "b");
        m2.put(3, "c");
        m2.put(4, "d");
        m2.put(5, "e");
        System.out.println(m2);
    }
}
