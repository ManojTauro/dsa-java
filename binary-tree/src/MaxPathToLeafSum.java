public class MaxPathToLeafSum {
    public static void main(String[] args) {
        NumberNode root = buildTree();
        System.out.println(maxPathToLeafSum(root));
    }

    private static int maxPathToLeafSum(NumberNode root) {
        if(root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right == null) return root.val;

        return root.val + Math.max(maxPathToLeafSum(root.left), maxPathToLeafSum(root.right));
    }

    private static NumberNode buildTree() {
        NumberNode a = new NumberNode(5);
        NumberNode b = new NumberNode(11);
        NumberNode c = new NumberNode(3);
        NumberNode d = new NumberNode(4);
        NumberNode e = new NumberNode(2);
        NumberNode f = new NumberNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        return a;
    }
}
