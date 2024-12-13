public class DisjointSetMain {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRand(1, 2);
        ds.unionByRand(2, 3);
        ds.unionByRand(4, 5);
        ds.unionByRand(6, 7);
        ds.unionByRand(5, 6);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same parent");
        } else {
            System.out.println("Different parent");
        }

        ds.unionByRand(3, 7);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same parent");
        } else {
            System.out.println("Different parent");
        }
    }
}
