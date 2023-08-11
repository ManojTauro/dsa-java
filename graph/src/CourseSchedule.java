import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
//        int[][] schedule = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 1}};
        int[][] schedule = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(schedule.length, schedule));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adj = getAdjList(numCourses, prerequisites);
        boolean[] vis = new boolean[numCourses];
        boolean[] curDFSPath = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!vis[i])
                if(detectCycle(i, adj, vis, curDFSPath)) return false; // cycle exists
        }

        return true;
    }

    private boolean detectCycle(int node, List<ArrayList<Integer>> adj, boolean[] vis, boolean[] curDFSPath) {
        vis[node] = true;
        curDFSPath[node] = true;

        for(int curNode: adj.get(node)) {
            if(!vis[curNode] && detectCycle(curNode, adj, vis, curDFSPath)) return true;
            else if(curDFSPath[curNode]) return true;
        }

        curDFSPath[node] = false;
        return false;
    }

    private List<ArrayList<Integer>> getAdjList(int n, int[][] matrix) {
        List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());

        for(int[] row: matrix) {
            int u = row[1];
            int v = row[0];

            adj.get(u).add(v);
        }

        return adj;
    }
}
