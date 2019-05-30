package cn.zhou9.myHashSet;

import javax.jws.Oneway;
import java.util.HashMap;

/**
 * 手写HashSet
 * @Auther: CN.Zhou9
 * @Date: 2019/5/30
 * @Description: cn.zhou9.myHashSet
 * @version: 1.0
 */
public class MyHashSet01 {
    HashMap map;
    private static final Object PERSENT = new Object();
    public MyHashSet01() {
        map = new HashMap();
    }
    public int size() {
        return map.size();
    }
    public void add(Object o) {
        map.put(o, PERSENT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Object key:map.keySet()) {
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet01 m = new MyHashSet01();
        m.add("a");
        m.add("b");
        m.add("c");
        System.out.println(m);
    }
}

