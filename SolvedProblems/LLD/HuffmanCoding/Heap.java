package LLD.HuffmanCoding;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    ArrayList<T> list;

    Heap() {
        list = new ArrayList<>();
        list.add(null);
    }

    private void swap(int start, int end) {
        T temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }

    private int parent(int index) {
        return index / 2;
    }

    private int left(int index) {
        return 2 * index;
    }

    private int right(int index) {
        return 2 * index + 1;
    }

    int size() {
        return list.size() - 1;
    }

    void insert(T data) {
        list.add(data);
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {
        if (index == 1) {
            return;
        }

        int parent = this.parent(index);
        if (list.get(index).compareTo(list.get(parent)) < 0) {
            this.swap(index, parent);
            upHeap(parent);
        }
    }

    T remove() throws Exception {
        if (list.size() == 1) {
            throw new Exception("List is empty");
        }

        T data = list.get(1);
        T last = list.remove(list.size() - 1);
        if (list.size() > 1) {
            list.set(1, last);
            downHeap(1);
        }

        return data;
    }

    void downHeap(int index) {
        int left = this.left(index);
        int right = this.right(index);
        int min = index;

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            this.swap(min, index);
            downHeap(min);
        }
    }
}
