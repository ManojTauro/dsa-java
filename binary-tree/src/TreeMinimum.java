import java.util.LinkedList;
import java.util.Queue;

public class TreeMinimum {
    public static void main(String[] args) {
        TreeNode root = buildTree();
//        System.out.println(treeMinimum(root));
        System.out.println(treeMinimumBFS(root));
    }

    private static int treeMinimum(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        int treeMin = Math.min(root.val, Math.min(treeMinimum(root.left), treeMinimum(root.right)));

        return treeMin;
    }

    private static int treeMinimumBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int treeMin = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.val < treeMin) treeMin = cur.val;

            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }

        return treeMin;
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        return a;
    }
}
