package cn.ac.oop.Collection;

import java.util.HashMap;

public class MyHashSet {

    private MyHashMap myHashMap;
    private final Object no = new Object();

    public MyHashSet(){
        myHashMap = new MyHashMap();
    }

    public void add(Object o){
        myHashMap.put(o, no);
    }

    public int size(){
        return myHashMap.size();
    }

}
