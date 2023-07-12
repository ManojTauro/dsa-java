import java.util.*;
import java.util.stream.Collectors;

public class ZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println(zigZagTraversal(buildTree()));
    }

    private static List<List<Integer>> zigZagTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        boolean isEvenLevel = true;

        while(!q.isEmpty()) {
            int qSize = q.size();

            int[] curLevelNodes = new int[qSize];

            for(int i=0; i<qSize; i++) {
                TreeNode node = q.poll();

                int index = isEvenLevel ? i : (qSize - 1 - i);
                curLevelNodes[index] = node.val;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            isEvenLevel = !isEvenLevel;
            result.add(Arrays.stream(curLevelNodes).boxed().collect(Collectors.toList()));
        }
        return result;
    }

    private static TreeNode buildTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
//        NumberNode f = new NumberNode(6);

        a.left = b;
        a.right = c;
        b.left = d;
//        c.left.left = e;
        c.right = e;

        return a;
    }
}
