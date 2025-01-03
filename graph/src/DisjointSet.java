import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    private List<Integer> rank = new ArrayList<>();
    private List<Integer> parent = new ArrayList<>();

    //Not mandatory - we can do it either by rank or size
    private List<Integer> size = new ArrayList<>();

    public DisjointSet(int V) {
        for (int i = 0; i <= V; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public List<Integer> getParent() {
        return parent;
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) return node;

        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);

        return parent.get(node);
    }

    public void unionByRank(int src, int dest) {
        int ulp_src = findUltimateParent(src);
        int ulp_dest = findUltimateParent(dest);

        if (ulp_src == ulp_dest) return; // Src and Dest is in the same component

        if (rank.get(ulp_src) < rank.get(ulp_dest))
            parent.set(ulp_src, ulp_dest);

        else if (rank.get(ulp_src) > rank.get(ulp_dest))
            parent.set(ulp_dest, ulp_src);

        else {
            parent.set(ulp_src, ulp_dest);
            int rankSrc = rank.get(ulp_src);
            rank.set(ulp_src, rankSrc + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

