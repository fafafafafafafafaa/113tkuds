public class BSTBalance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 用一個類別包裝高度和平衡狀態
    static class BalanceInfo {
        int height;
        boolean isBalanced;

        BalanceInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    // 1. 檢查是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private static BalanceInfo checkBalance(TreeNode node) {
        if (node == null) return new BalanceInfo(0, true);

        BalanceInfo left = checkBalance(node.left);
        BalanceInfo right = checkBalance(node.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean balanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        return new BalanceInfo(height, balanced);
    }

    // 2. 計算節點平衡因子(左子樹高度 - 右子樹高度)，並印出（前序）
    public static void printBalanceFactors(TreeNode root) {
        printBalanceFactorsHelper(root);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static void printBalanceFactorsHelper(TreeNode node) {
        if (node == null) return;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int bf = leftHeight - rightHeight;

        System.out.println("節點 " + node.data + " 的平衡因子: " + bf);

        printBalanceFactorsHelper(node.left);
        printBalanceFactorsHelper(node.right);
    }

    // 3. 找最不平衡節點（平衡因子絕對值最大）
    static class UnbalancedNode {
        TreeNode node;
        int balanceFactor;

        UnbalancedNode(TreeNode node, int bf) {
            this.node = node;
            this.balanceFactor = bf;
        }
    }

    public static UnbalancedNode findMostUnbalancedNode(TreeNode root) {
        return findMostUnbalancedNodeHelper(root, new UnbalancedNode(null, 0));
    }

    private static UnbalancedNode findMostUnbalancedNodeHelper(TreeNode node, UnbalancedNode currentMax) {
        if (node == null) return currentMax;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int bf = leftHeight - rightHeight;

        if (currentMax.node == null || Math.abs(bf) > Math.abs(currentMax.balanceFactor)) {
            currentMax = new UnbalancedNode(node, bf);
        }

        currentMax = findMostUnbalancedNodeHelper(node.left, currentMax);
        currentMax = findMostUnbalancedNodeHelper(node.right, currentMax);

        return currentMax;
    }

    // 測試
    public static void main(String[] args) {
        /*
            範例樹：
                  10
                 /  \
                5    20
               /      \
              3        30
                         \
                          40
         */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(30);
        root.right.right.right = new TreeNode(40);

        System.out.println("是否為平衡樹？ " + isBalanced(root));

        System.out.println("節點平衡因子:");
        printBalanceFactors(root);

        UnbalancedNode unbalanced = findMostUnbalancedNode(root);
        System.out.println("最不平衡節點: " + unbalanced.node.data + ", 平衡因子: " + unbalanced.balanceFactor);
    }
}
