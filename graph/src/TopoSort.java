import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        getInput(adj, V);

        for(int i=0; i<V; i++) {
            if(!vis[i])
                dfs(i, adj, vis, s);
        }

        printStack(s);

    }

    private static void printStack(Stack<Integer> s) {
        while (!s.isEmpty())
            System.out.print(s.pop()+"\t");
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> s) {
        vis[node] = true;

        for(int curNode: adj.get(node)) {
            if(!vis[curNode])
                dfs(curNode, adj, vis, s);
        }

        s.push(node);
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
