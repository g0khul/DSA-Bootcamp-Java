package LLD.HuffmanCoding;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCoding {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left;
        Node right;

        Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    HuffmanCoding(String feeder) throws Exception {
        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i = 0; i < feeder.length(); i++) {
            fmap.put(feeder.charAt(i), fmap.getOrDefault(feeder.charAt(i), 0) + 1);
        }

        Heap<Node> minHeap = new Heap<>();
        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        Node fullTree = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoder(fullTree, "");
    }

    private void initEncoder(Node node, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            encoder.put(node.data, path);
            decoder.put(path, node.data);
        }

        initEncoder(node.left, path + "0");
        initEncoder(node.right, path + "1");
    }

    public String encode(String source) {
        StringBuilder encode = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            encode.append(this.encoder.get(source.charAt(i)));
        }

        return encode.toString();
    }

    public String decode(String encodedString) {
        StringBuilder decode = new StringBuilder();

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i++) {
            key.append(encodedString.charAt(i));
            if (decoder.containsKey(key.toString())) {
                decode.append(decoder.get(key.toString()));
                key.delete(0, key.length());
            }
        }

        return decode.toString();
    }
}