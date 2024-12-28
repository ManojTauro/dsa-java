import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {
        List<List<int[]>> adj = new ArrayList<>();
        int V = 0;
        int E = 0;
        List<int[]> v1 = new ArrayList<>();
        List<int[]> v2 = new ArrayList<>();
        List<int[]> v3 = new ArrayList<>();
        adj.add(v1);
        adj.add(v2);
        adj.add(v3);

        adj.get(0).add(new int[]{1, 5});
        adj.get(1).add(new int[]{0, 5});

        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});

        adj.get(0).add(new int[]{2, 1});
        adj.get(2).add(new int[]{0, 1});

        System.out.println(minSpanningTree(3, 3, adj));
    }

    private static int minSpanningTree(int V, int E, List<List<int[]>> adj) {
        int sum = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));
        pq.add(new Vertex(0, 0));
        boolean[] vis = new boolean[adj.size()];

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();

            if (vis[v.label]) continue;

            vis[v.label] = true;
            sum += v.distance;

            for (int i = 0; i < adj.get(v.label).size(); i++) {
                int label = adj.get(v.label).get(i)[0];
                int wt = adj.get(v.label).get(i)[1];

                if (!vis[label]) {
                    pq.add(new Vertex(label, wt));
                }
            }
        }

        return sum;
    }

    static class Vertex {
        int label;
        int distance;

        public Vertex(int label, int distance) {
            this.label = label;
            this.distance = distance;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
