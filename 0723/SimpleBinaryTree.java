public class SimpleBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 印出樹的結構（右 -> 根 -> 左，會比較像樹形結構）
    public static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        printTree(root.right, level + 1);
        
        // 印出目前節點（加上縮排）
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(root.data);
        
        printTree(root.left, level + 1);
    }

    public static void main(String[] args) {
        // 建立一個簡單的二元樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("樹的階層結構:");
        printTree(root, 0);
    }
}
