import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a target value, find if it's present in the binary tree.
 **/
public class TreeIncludes {
    public static void main(String[] args) {
        Node root = buildTree();
//        System.out.println(treeIncludesBFS(root, 'a'));
        System.out.println(treeIncludesRecDFS(root, 'q'));
    }

    private static Node buildTree() {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        return a;
    }

    private static boolean treeIncludesBFS(Node root, char target) {
        if(root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.val == target) return true;

            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }

        return false;
    }

    private static boolean treeIncludesRecDFS(Node root, char target) {
        if(root == null) return false;
        if(root.val == target) return true;
        return treeIncludesRecDFS(root.left, target) || treeIncludesRecDFS(root.right, target);
    }
}
