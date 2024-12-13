import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class GraphNode {
    String name;
    Metric metric;
    int contributionToParent;
    boolean isConsideredLeaf;
    Map<String, GraphNode> children;

    GraphNode(String name, float score, int contributionToParent, int numeratorSum, int denominatorSum) {
        this.name = name;
        this.score = score;
        this.contributionToParent = contributionToParent;
        this.numeratorSum = numeratorSum;
        this.denominatorSum = denominatorSum;
        this.questionWindowNumerator = new ArrayList<>();
        this.questionWindowDenominator = new ArrayList<>();
        this.children = new HashMap<>();
    }

    // Insert method based on hierarchical path
    public void insert(String path, String name, float score, int contributionToParent, int numeratorSum,
            int denominatorSum) {
        GraphNode current = this;
        String[] parts = path.split("(?<=\\G....)"); // Splitting the path in groups of 4 (e.g., 001Z)

        for (String part : parts) {
            if (!current.children.containsKey(part)) {
                // Create a new node if it doesn't exist
                current.children.put(part,
                        new GraphNode(name, score, contributionToParent, numeratorSum, denominatorSum));
            }
            current = current.children.get(part);
        }
        // Update the node details
        current.name = name;
        current.score = score;
        current.contributionToParent = contributionToParent;
        current.numeratorSum = numeratorSum;
        current.denominatorSum = denominatorSum;
    }

    // Display the tree
    public void prettyDisplay(GraphNode node, int level) {
        if (node == null)
            return;

        for (Map.Entry<String, GraphNode> entry : node.children.entrySet()) {
            GraphNode child = entry.getValue();
            for (int i = 0; i < level; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + child.name);
            prettyDisplay(child, level + 1);
        }
    }
}
