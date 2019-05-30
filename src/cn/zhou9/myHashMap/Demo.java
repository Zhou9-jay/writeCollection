package cn.zhou9.myHashMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试next的传递
 * @Auther: CN.Zhou9
 * @Date: 2019/5/28
 * @Description: cn.zhou9.myHashMap
 * @version: 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Node2 n1 = new Node2();
        n1.value = 100;
        Node2 n2 = new Node2();
        n2.value = 200;
        Map m = new TreeMap();
        Node2 temp = n1;
        temp.next = n2;
        System.out.println(n2.value);
        System.out.println(n1.next.value);
        String a = "aaaaaa"; //a只是对象的引用
        System.out.println(a.hashCode());
        String b = a;
        System.out.println(b.hashCode());
        a = "vvvvvv";
        System.out.println(a.hashCode());
    }
}

class Node2 {
    int value;
    Node2 next;
}
