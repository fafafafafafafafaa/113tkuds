import java.util.*;

public class F10_BSTRangeSum {
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

    static int rangeSum = 0;
    static int L, R;

    public static void inorder(TreeNode root) {
        if (root == null) return;

        // 左子樹剪枝：如果 root.val > L，才往左走，因為左子樹節點小於 root.val
        if (root.val > L) inorder(root.left);

        // 根節點判斷是否在區間內
        if (root.val >= L && root.val <= R) {
            rangeSum += root.val;
        }

        // 右子樹剪枝：如果 root.val < R，才往右走，因為右子樹節點大於 root.val
        if (root.val < R) inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();

        // 輸入 BST 節點（層序），-1 表 null
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
            if (sc.hasNextLine()) break;  // 防止讀過頭，根據題目可調整
        }

        // 讀 L 和 R
        if (sc.hasNextInt()) L = sc.nextInt();
        if (sc.hasNextInt()) R = sc.nextInt();
        sc.close();

        TreeNode root = buildTree(vals);
        rangeSum = 0;
        inorder(root);

        System.out.println("Sum: " + rangeSum);
    }
}
