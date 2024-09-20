import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    public static void main(String[] args) {
        Node node = new Node();
        cloneGraph(node);
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        return helper(node, map);
    }

    public static Node helper(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node child : node.neighbors) {
            newNode.neighbors.add(helper(child, map));
        }

        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        // val = 0;
        // neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
