import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < vals.size()) {
            TreeNode current = queue.poll();

            // 左子節點
            if (vals.get(i) != -1) {
                current.left = new TreeNode(vals.get(i));
                queue.offer(current.left);
            }
            i++;
            if (i >= vals.size()) break;

            // 右子節點
            if (vals.get(i) != -1) {
                current.right = new TreeNode(vals.get(i));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 每層第一個節點加入結果（左視圖）
                if (i == 0) res.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();

        // 一行輸入，多個整數，以空白分隔
        // -1 表示空節點
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        sc.close();

        TreeNode root = buildTree(vals);
        List<Integer> leftViewList = leftView(root);

        System.out.print("LeftView:");
        for (int v : leftViewList) {
            System.out.print(" " + v);
        }
        System.out.println();
    }
}
