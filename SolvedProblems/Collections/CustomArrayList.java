package SolvedProblems.Collections;

import java.util.Arrays;

public class CustomArrayList {
    int[] data;
    static int DEFAULT_SIZE = 10;
    int size = 0;

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    void add(int value) {
        if (isFull()) {
            resize();
        }
        data[size++] = value;
    }

    void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    boolean isFull() {
        return (size == data.length) ? true : false;
    }

    int remove() {
        return data[--size];
    }

    int get(int index) {
        return data[index];
    }

    boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    int size() {
        return size;
    }

    void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

    

}

class Main {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(5);
        // list.isEmpty();
        // list.size();
        // list.add(1, 3);
        CustomArrayList list = new CustomArrayList();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(3);
        list.add(4);
        list.set(5, 9);

        System.out.println(list.isEmpty());
        System.out.println(list.size);

        System.out.println(list);
    }
}