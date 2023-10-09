package SolvedProblems.Heaps;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        for (int i = 10; i > 0; i--) {
            heap.insert(i);
        }

        System.out.println(heap.list);
        System.out.println(heap.heapSort());

        // Find max in not formed heap
        heap.list.clear();
        heap.list.add(-1);      // I wrote code based on 1-indexing
        heap.list.add(4);
        heap.list.add(1);
        heap.list.add(3);
        heap.list.add(2);
        heap.list.add(16);
        heap.list.add(9);
        heap.list.add(10);
        heap.list.add(14);
        heap.list.add(8);
        heap.list.add(7);
        
        System.out.println(heap.list);

        for (int i = heap.list.size() / 2; i >= 0; i--) {
            heap.downHeap(i);
        }

        System.out.println(heap.list);
        
    }
}
