import java.util.*;

public class DisjointSet {
    int[] rank;
    int[] parent;

    DisjointSet(int n) {
        // 1 based indexing
        this.rank = new int[n + 1];
        this.parent = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    int findUltimateParent(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = findUltimateParent(parent[u]);
    }

    void unionByRand(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = parent[pv];
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = parent[pu];
        } else {
            parent[pv] = parent[pu];
            rank[pv]++;
        }
    }
}
