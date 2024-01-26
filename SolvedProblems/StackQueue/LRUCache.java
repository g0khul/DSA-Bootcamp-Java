import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.deque;
import java.util.Stack;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        this.left.next = right;
        this.right.prev = left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(Node node) {
        Node p = this.right.prev;
        Node n = this.right;

        p.next = node;
        n.prev = node;

        node.prev = p;
        node.next = n;
    }

    private void remove(Node node) {
        Node p = node.prev;
        Node n = node.next;

        p.next = n;
        n.prev = p;
    }

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}