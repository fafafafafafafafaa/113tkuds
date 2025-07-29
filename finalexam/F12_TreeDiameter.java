import java.util.*;

public class F12_TreeDiameter {
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

            if (i < vals.size() && vals.get(i) != -1) {
                current.left = new TreeNode(vals.get(i));
                queue.offer(current.left);
            }
            i++;

            if (i < vals.size() && vals.get(i) != -1) {
                current.right = new TreeNode(vals.get(i));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static int diameter = 0;

    // 後序遞迴：回傳節點高度（以邊數計）
    public static int height(TreeNode node) {
        if (node == null) return -1; // 高度以邊數計，空節點為 -1

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // 更新直徑：左右子樹高度和 + 2（左右邊數）
        int pathLen = leftHeight + rightHeight + 2;
        diameter = Math.max(diameter, pathLen);

        // 回傳節點高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();

        // 輸入層序序列，-1 表 null
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        sc.close();

        TreeNode root = buildTree(vals);
        diameter = 0;
        height(root);

        System.out.println("Diameter: " + diameter);
    }
}
