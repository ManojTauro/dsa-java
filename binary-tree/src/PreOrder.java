import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();

            res.add(node.val);

            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
        }

        return res;
    }
}
