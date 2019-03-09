package cn.ac.oop.Collection;

public class MyHashMap {

    MyLinkedList myLinkedList[] = new MyLinkedList[999];

    private int size;

    public void put(Object key, Object value){
        MyEntry n = new MyEntry(key, value);
        int a = getHashCode(key);
        if(myLinkedList[a] == null){
            MyLinkedList list = new MyLinkedList();
            myLinkedList[a] = list;
            list.add(n);
        } else {
            MyEntry me = getEntry(key);
            if (me == null) {
                myLinkedList[a].add(n);
            } else {
                me.value = value;
                size--;
            }

        }
        size ++;
    }


    public Object get(Object key){
        MyEntry me = getEntry(key);
        if(me != null) {
            return me.value;
        } else {
            return null;
        }
    }

    private MyEntry getEntry(Object key){
        if (myLinkedList[getHashCode(key)] != null){
            MyLinkedList list = myLinkedList[key.hashCode()%999];
            for (int i = 0; i < list.size(); i++) {
                MyEntry me = (MyEntry)list.get(i);
                if(me.key.equals(key)){
                    return me;
                }
            }
            return null;
        } else return null;
    }

    private int getHashCode(Object key){
        int hash = key.hashCode();
        hash = hash<0? -hash:hash;
        int a = hash % myLinkedList.length;
        return a;
    }

    public int size(){
        return size;
    }

    private class MyEntry{
        private Object key;
        private Object value;

        private MyEntry(Object key,Object value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(12,234);
        myHashMap.put(323,"sdf");
        myHashMap.put(3,"df");
        myHashMap.put(3,"dsf");
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(3));
    }
}

