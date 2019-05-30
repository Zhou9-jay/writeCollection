package cn.zhou9.myHashMap;

/**
 * 实现泛型
 * @Auther: CN.Zhou9
 * @Date: 2019/5/29
 * @Description: cn.zhou9.myHashMap
 * @version: 4.0
 */
public class MyHashMap04<K, V> {
    NodeNew[] table; //位桶数组
    int size; //存放键值对的个数c

    public MyHashMap04() {
        table = new NodeNew[16]; //长度一般定义为2的整数幂
    }

    public void put(K key, V value) {
        //完善：扩容
        //定义了新的节点对象
        NodeNew newNode = new NodeNew();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;
        NodeNew temp = table[newNode.hash]; //到达位桶数组的指定位置
        NodeNew iterLast = null; //正在遍历的最后一个元素
        boolean keyRepeat = false; //默认键重复为false
        if (temp == null) {
            //此处数组元素为空，则直接将新节点放进去。
            table[newNode.hash] = newNode;
            size++;
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
                size++;
            }
        }
    }

    public V get(K key) {
        int hash = myHash(key.hashCode(), table.length);
        V value = null;
        if (table[hash] != null) {
            NodeNew temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) { //如果相等则表示找到
                    value = (V)temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
        return value;
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
            NodeNew temp = table[i];
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
        MyHashMap04<Integer, String> m4 = new MyHashMap04<>();
        m4.put(1,"a");
        m4.put(1,"a2");
        m4.put(2,"b");
        System.out.println(m4);
    }
}

