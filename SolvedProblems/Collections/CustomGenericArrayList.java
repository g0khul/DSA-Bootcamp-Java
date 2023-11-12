package Collections;

import java.util.*;
                            // <T extends Number> will allow only type of Number or it's sub class
public class CustomGenericArrayList<T extends Number> {
    Object[] data;
    static int DEFAULT_SIZE = 10;
    int size = 0;

    public CustomGenericArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    void add(T value) {
        if (isFull()) {
            resize();
        }
        data[size++] = value;
    }

    void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    boolean isFull() {
        return (size == data.length) ? true : false;
    }

    T remove() {
        return (T) data[size--];
    }

    T get(int index) {
        return (T) data[index];
    }

    boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    int size() {
        return size;
    }

    void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(5);
        // list.isEmpty();
        // list.size();
        // list.add(1, 3);
        // CustomGenericArrayList<String> list = new CustomGenericArrayList<>();
        // list.add("sdklj");
        // list.add("sdklfj");
        // list.add("eklf");
        // list.remove();
        // list.add("go");

        // System.out.println(list.isEmpty());
        // System.out.println(list.size);

        // System.out.println(list);
    }
     
}
