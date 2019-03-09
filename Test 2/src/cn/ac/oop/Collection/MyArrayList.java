package cn.ac.oop.Collection;

public class MyArrayList {
    private Object[] elementData;

    private int size = 0;

    public int size(){
        return size;
    }

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initialCapacity){
        if(initialCapacity < 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    public void add(Object o){
        ensureCapacity();
        elementData[size++] = o;
        //size ++;
    }

    private void ensureCapacity(){
        if(size >= elementData.length){
            Object[] newArray = new Object[2*size + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index){
        if(index < 0 | index >= size ){
            try {
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(int index){
        //remove the object of the point index
        rangeCheck(index);

        int numberMove = size - index - 1;
        System.arraycopy(elementData,index+1, elementData, index, numberMove);
        elementData[--size] = null;
    }

    public void remove(Object obj){
        if(obj == null){
            for (int i = 0; i < size; i++) {
                if(elementData[i] == null){
                    remove(i);
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(obj.equals(elementData[i])){
                    remove(i);
                }
            }
        }
    }

    public Object set(int index, Object o){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = o;
        return oldValue;
    }

    public void add(int index,Object o){
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(elementData,index,elementData,index+1, size -1 - index);
        elementData[index] = o;
    }

    public static void main(String[] args) {

    }
}
