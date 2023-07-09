import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTreeBFS {
    static int maxDepth(NumberNode root) {
        if(root == null) return 0;
        Queue<NumberNode> q = new LinkedList<>();
        int height = 0;

        q.add(root);

        while (true) {
            int totalNodes = q.size(); // Total nodes at current level

            if(totalNodes == 0)
                return height;

            height++;

            while (totalNodes > 0) {
                NumberNode node = q.peek();
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

    private static NumberNode buildTree() {
        NumberNode a = new NumberNode(1);
        NumberNode b = new NumberNode(2);
        NumberNode c = new NumberNode(3);
        NumberNode d = new NumberNode(4);
        NumberNode e = new NumberNode(5);
        NumberNode f = new NumberNode(6);

        a.left = b;
        a.right = c;
        c.left = d;
        c.left.left = e;
        c.right = f;

        return a;
    }
}