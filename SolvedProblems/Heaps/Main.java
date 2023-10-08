package SolvedProblems.Heaps;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        for (int i = 10; i > 0; i--) {
            heap.insert(i);
        }

        System.out.println(heap.list);
        System.out.println(heap.heapSort());
    }
}
