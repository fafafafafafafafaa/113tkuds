public class TreeComparison {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 判斷兩棵樹是否完全相同
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.data != t.data) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    // 2. 判斷t是否為s的子樹
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;    // 空樹是任意樹的子樹
        if (s == null) return false;

        if (isSameTree(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3. 找兩棵樹的最大公共子樹（最大相同子樹，回傳根節點）
    // 以遞迴比較，並使用輔助函數計算子樹大小，保留最大公共子樹根
    static TreeNode maxCommonSubtreeRoot = null;
    static int maxCommonSubtreeSize = 0;

    public static TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        maxCommonSubtreeRoot = null;
        maxCommonSubtreeSize = 0;

        helper(root1, root2);
        return maxCommonSubtreeRoot;
    }

    // 回傳兩子樹公共子樹大小
    private static int helper(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return 0;

        int left = helper(n1.left, n2.left);
        int right = helper(n1.right, n2.right);

        if (n1.data == n2.data) {
            int size = left + right + 1;
            if (size > maxCommonSubtreeSize) {
                maxCommonSubtreeSize = size;
                maxCommonSubtreeRoot = n1;  // 或 n2 都可
            }
            return size;
        } else {
            return 0;
        }
    }

    // 輔助：前序遍歷印樹
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // 測試範例
    public static void main(String[] args) {
        /*
          樹s:
               1
              / \
             2   3
            / \
           4   5

          樹t:
             2
            / \
           4   5
        */

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);
        s.left.right = new TreeNode(5);

        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(4);
        t.right = new TreeNode(5);

        System.out.println("兩樹是否完全相同？ " + isSameTree(s, t));
        System.out.println("t是否為s的子樹？ " + isSubtree(s, t));

        TreeNode largestCommonRoot = largestCommonSubtree(s, t);
        System.out.print("最大公共子樹前序遍歷: ");
        printPreorder(largestCommonRoot);
        System.out.println("\n最大公共子樹大小: " + maxCommonSubtreeSize);
    }
}
