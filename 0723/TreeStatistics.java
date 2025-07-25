public class TreeStatistics {

    // 定義樹節點類別
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 計算所有節點值的總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // 找出最大值
    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // 找出最小值
    public static int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    // 計算葉節點數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 計算樹的高度（深度）
    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 測試範例
    public static void main(String[] args) {
        /*
              10
             /  \
            5    15
           / \     \
          2   7     20
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("節點總和: " + sum(root));
        System.out.println("最大值: " + findMax(root));
        System.out.println("最小值: " + findMin(root));
        System.out.println("葉節點數: " + countLeaves(root));
        System.out.println("樹的高度: " + treeDepth(root));
    }
}
