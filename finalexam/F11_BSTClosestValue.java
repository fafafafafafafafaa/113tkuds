import java.util.*;

public class F11_BSTClosestValue {
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

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode node = root;

        while (node != null) {
            int diffNode = Math.abs(node.val - target);
            int diffClosest = Math.abs(closest - target);

            if (diffNode < diffClosest) {
                closest = node.val;
            } else if (diffNode == diffClosest && node.val < closest) {
                // 差距相等時取較小值
                closest = node.val;
            }

            if (target < node.val) {
                node = node.left;
            } else if (target > node.val) {
                node = node.right;
            } else {
                // 差值為0，已找到最接近值
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();

        // 讀入 BST 節點層序序列，-1 表 null，直到無輸入
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
            if (!sc.hasNextInt()) break;
        }

        // 讀目標值 T
        int T = sc.nextInt();
        sc.close();

        TreeNode root = buildTree(vals);
        int ans = closestValue(root, T);

        System.out.println("Closest: " + ans);
    }
}

