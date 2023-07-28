import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0}, {0,1,0},{0,0,1}};

        System.out.println(findCircleNum(isConnected));

    }

    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = getAdjList(isConnected);
        int len = isConnected.length;
        int numOfProvinces = 0;

        boolean[] vis = new boolean[len];
        int start = 0;

        for(int i=0; i<len; i++) {
            if(!vis[i]) {
                numOfProvinces++;
                dfs(i, adjList, vis);
            }
        }

        return numOfProvinces;
    }

    private static void dfs(int node, List<ArrayList<Integer>> adjList, boolean[] vis) {
        vis[node] = true;

        for(int i: adjList.get(node)) {
            if(!vis[i])
                dfs(i, adjList, vis);
        }
    }

    private static ArrayList<ArrayList<Integer>> getAdjList(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int len = isConnected.length;

        for(int i=0; i<len; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        return adjList;
    }
}
