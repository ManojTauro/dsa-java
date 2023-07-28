import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=0ca1nvR0be4/

public class BoundaryTraversal {
    public static void main(String[] args) {
        List<Integer> boundaryOrderTraversal = boundaryOrder(buildTree());

        for (Integer i: boundaryOrderTraversal) {
            System.out.print(i+" ");
        }
    }

    private static List<Integer> boundaryOrder(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        if(!isLeafNode(root)) result.add(root.val);
        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root, result);
        return result;
    }

    //Using Recursion
    private static void addLeftBoundary(TreeNode cur, List<Integer> result) {
        if(cur == null) return;

        if(!isLeafNode(cur)) result.add(cur.val);

        if(cur.left != null) addLeftBoundary(cur.left, result);
        else addLeftBoundary(cur.right, result);
    }

    private static void addLeaves(TreeNode node, List<Integer> result) {
        if(isLeafNode(node)) {
            result.add(node.val);
            return;
        }

        if(node.left != null) addLeaves(node.left, result);
        if(node.right != null) addLeaves(node.right, result);
    }

    //Using iterative method
    private static void addRightBoundary(TreeNode node, List<Integer> result) {
        TreeNode cur = node.right;
        Stack<Integer> s = new Stack<>();

        while (cur != null) {
            if(!isLeafNode(cur)) s.push(cur.val);

            if(cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        while (s.size() > 0) {
            result.add(s.pop());
        }
    }

    private static boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        TreeNode ar = new TreeNode(7);
        TreeNode br = new TreeNode(8);
        TreeNode cr = new TreeNode(9);
        TreeNode dr = new TreeNode(10);
        TreeNode er = new TreeNode(11);

        a.left = b;
        a.right = ar;

        b.left = c;
        ar.right = br;

        c.right = d;
        br.left = cr;

        d.left = e;
        cr.left = dr;

        d.right = f;
        cr.right = er;

        return a;
    }
}
