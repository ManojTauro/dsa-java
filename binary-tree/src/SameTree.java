import java.util.Stack;

public class SameTree {
    public static void main(String[] args) {
        System.out.println(isSameTree(buildTree1(), buildTree2()));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        // Using Iterative Pre order traversal to compare the Trees
        if(p == null || q == null) return p == q;

        Stack<TreeNode> sp = new Stack<TreeNode>();
        Stack<TreeNode> sq = new Stack<TreeNode>();

        sp.push(p);
        sq.push(q);

        while(!sp.isEmpty() && !sq.isEmpty()) {
            TreeNode nodep = sp.peek();
            TreeNode nodeq = sq.peek();

            sp.pop();
            sq.pop();

            if(nodep == null && nodeq == null) continue;

            if(nodep == null || nodeq == null) {
                return false;
            }

            if(nodep.val != nodeq.val) {
                return false;
            }

            sp.push(nodep.right);
            sp.push(nodep.left);

            sq.push(nodeq.right);
            sq.push(nodeq.left);
        }

        return true;
    }

    private static TreeNode buildTree1() {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
//        NumberNode d = new NumberNode(4);
//        NumberNode e = new NumberNode(5);
//        NumberNode f = new NumberNode(6);

        a.left = b;
        a.right = c;
//        c.left = d;
//        c.left.left = e;
//        c.right = f;

        return a;
    }

    private static TreeNode buildTree2() {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
//        NumberNode d = new NumberNode(4);
//        NumberNode e = new NumberNode(5);
//        NumberNode f = new NumberNode(6);

        a.left = b;
        a.left.right = c;
//        c.left = d;
//        c.left.left = e;
//        c.right = f;

        return a;
    }
}
