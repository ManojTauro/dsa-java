//https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionTopoSortBFS {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V + 1];
        getInput(adj, V);

        for(int i=1; i<=V; i++) {
            for(int node: adj.get(i))
                inDegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=V; i++)
            if(inDegree[i] == 0) q.add(i);

        int topoCount = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            topoCount++;

            for(int curNode: adj.get(node)) {
                inDegree[curNode]--;

                if(inDegree[curNode] == 0) q.add(curNode);
            }
        }

        //if topoCount doesn't match with number of vertices then there is a cycle
        System.out.println(topoCount);
        System.out.println(String.valueOf(topoCount == V));
    }

    private static void getInput(List<List<Integer>> adj, int V) {
        for(int i=0; i<=V; i++)
            adj.add(new ArrayList<>());

        adj.get(1).add(2);

        adj.get(2).add(3);

        adj.get(3).add(4);
        adj.get(3).add(5);

        adj.get(4).add(2);
    }
}
