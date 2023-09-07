import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=27
// Kahn's Algorithms
public class TopoSortBFS {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V]; // InDegree - Number of incoming edges into a particular node
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();

        getInput(adj, V);

        for (int i=0; i<V; i++) {
            for(int node: adj.get(i))
                inDegree[node]++;
        }

        for(int i=0; i<V; i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topoSort.add(node);

            for (int curNode: adj.get(node)) {
                inDegree[curNode]--;

                if(inDegree[curNode] == 0) q.add(curNode);
            }

        }

        for(int node: topoSort) {
            System.out.print(node+"\t");
        }

    }

    private static void getInput(List<List<Integer>> adj, int V) {
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());

        adj.get(2).add(3);

        adj.get(3).add(1);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(5).add(0);
        adj.get(5).add(2);
    }
}
