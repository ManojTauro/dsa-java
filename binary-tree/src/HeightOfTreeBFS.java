import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTreeBFS {
    static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;

        q.add(root);

        while (true) {
            int totalNodes = q.size(); // Total nodes at current level

            if(totalNodes == 0)
                return height;

            height++;

            while (totalNodes > 0) {
                TreeNode node = q.peek();
                q.remove();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                totalNodes--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Height of a given BT using BFS is "+maxDepth(buildTree()));
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        a.left = b;
        a.right = c;
        c.left = d;
        c.left.left = e;
        c.right = f;

        return a;
    }
}