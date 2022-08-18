import java.util.LinkedList;
import java.util.Queue;

public class TreeMinimum {
    public static void main(String[] args) {
        NumberNode root = buildTree();
//        System.out.println(treeMinimum(root));
        System.out.println(treeMinimumBFS(root));
    }

    private static int treeMinimum(NumberNode root) {
        if(root == null) return Integer.MAX_VALUE;
        int treeMin = Math.min(root.val, Math.min(treeMinimum(root.left), treeMinimum(root.right)));

        return treeMin;
    }

    private static int treeMinimumBFS(NumberNode root) {
        Queue<NumberNode> queue = new LinkedList<>();
        queue.add(root);
        int treeMin = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            NumberNode cur = queue.poll();
            if(cur.val < treeMin) treeMin = cur.val;

            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }

        return treeMin;
    }

    private static NumberNode buildTree() {
        NumberNode a = new NumberNode(5);
        NumberNode b = new NumberNode(11);
        NumberNode c = new NumberNode(1);
        NumberNode d = new NumberNode(4);
        NumberNode e = new NumberNode(15);
        NumberNode f = new NumberNode(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        return a;
    }
}
