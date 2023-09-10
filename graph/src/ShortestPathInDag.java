import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDag {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};

        System.out.println(Arrays.toString(shortestPath(6, 7, edges)));
    }

    private static int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        boolean[] vis = new boolean[N];
        Stack<Integer> topo = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i])
                topoSort(i, vis, adj, topo);
        }

//        while (!topo.isEmpty()) {
//            System.out.print(topo.pop() + "\t");
//        }

        System.out.println();

        int[] dis = new int[N];
        Arrays.fill(dis, (int) 1e9);

        dis[0] = 0;
        while (!topo.isEmpty()) {
            int node = topo.pop();

            for (Pair neighbor : adj.get(node)) {
                int edgeTo = neighbor.edgeTo;
                int wt = neighbor.wt;

                if (dis[node] + wt < dis[edgeTo])
                    dis[edgeTo] = dis[node] + wt;
            }
        }

        return dis;
    }

    private static void topoSort(int node, boolean[] vis, List<List<Pair>> adj, Stack<Integer> topo) {
        vis[node] = true;

        for (Pair neighbor : adj.get(node)) {
            if (!vis[neighbor.edgeTo])
                topoSort(neighbor.edgeTo, vis, adj, topo);
        }

        topo.push(node);
    }
}

class Pair {
    int edgeTo;
    int wt;

    Pair(int edgeTo, int wt) {
        this.edgeTo = edgeTo;
        this.wt = wt;
    }
}