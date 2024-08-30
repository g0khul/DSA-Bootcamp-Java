import java.util.*;

public class GraphImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n : ");
        // Nodes
        int n = sc.nextInt();
        System.out.print("m : ");
        // Edges
        int m = sc.nextInt();

        // int[][] adjMat = new int[n + 1][n + 1];
        // for (int i = 0; i < m; i++) {
        // System.out.print("node 1 : ");
        // int node1 = sc.nextInt();
        // System.out.print("node 2 : ");
        // int node2 = sc.nextInt();

        // // Store weights if it's a weighted graph
        // adjMat[node1][node2] = 1;
        // // Don't store this if it's a directed graph
        // adjMat[node2][node1] = 1;
        // }

        // for (int[] is : adjMat) {
        // System.out.println(Arrays.toString(is));
        // }

        // List<List<Integer>> adjList = new ArrayList<>();
        // for (int i = 0; i <= n; i++) {
        // adjList.add(new ArrayList<>());
        // }

        // for (int i = 0; i < m; i++) {
        // System.out.print("node 1 : ");
        // int node1 = sc.nextInt();
        // System.out.print("node 2 : ");
        // int node2 = sc.nextInt();
        // adjList.get(node1).add(node2);
        // // Don't store this if it's a directed graph
        // adjList.get(node2).add(node1);
        // }

        // for (int i = 0; i < adjList.size(); i++) {
        // System.out.println(adjList.get(i));
        // }

        // // Adjacency List of Weighted graph
        List<List<List<Integer>>> adjListWeight = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjListWeight.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            System.out.print("node 1 : ");
            int node1 = sc.nextInt();
            System.out.print("node 2 : ");
            int node2 = sc.nextInt();
            System.out.print("weight : ");
            int weight = sc.nextInt();

            List<Integer> nodeWeightPairs = new ArrayList<>();
            nodeWeightPairs.add(node2);
            nodeWeightPairs.add(weight);
            System.out.println(node1 + "  :   " + nodeWeightPairs);
            adjListWeight.get(node1).add(nodeWeightPairs);
            System.out.println(adjListWeight.get(node1));
            System.out.println("---------------------");

            nodeWeightPairs.set(0, node1);
            System.out.println(node2 + "  :   " + nodeWeightPairs);
            adjListWeight.get(node2).add(nodeWeightPairs);
            System.out.println(adjListWeight.get(node2));
            System.out.println("---------------------");
        }
    }
}
