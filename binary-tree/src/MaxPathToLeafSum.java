public class MaxPathToLeafSum {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println(maxPathToLeafSum(root));
    }

    private static int maxPathToLeafSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right == null) return root.val;

        return root.val + Math.max(maxPathToLeafSum(root.left), maxPathToLeafSum(root.right));
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        return a;
    }
}
