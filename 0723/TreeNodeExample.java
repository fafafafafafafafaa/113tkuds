public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void displayNode() {
            System.out.println("節點值: " + data);
            System.out.println("左子節點: " + (left != null ? left.data : "null"));
            System.out.println("右子節點: " + (right != null ? right.data : "null"));
        }
    }

    // 印出樹的結構 (旋轉90度，右邊在上)
    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1); // 先印右子樹
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 縮排
        }
        System.out.println(node.data); // 印節點
        printTree(node.left, level + 1); // 再印左子樹
    }

    public static void main(String[] args) {
        // 建立節點
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);

        // 建立第一層子節點
        root.left = leftChild;
        root.right = rightChild;

        // 建立第二層子節點
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        leftChild.left = node1;
        leftChild.right = node2;

        // 顯示節點資訊
        System.out.println("根節點資訊:");
        root.displayNode();

        System.out.println("\n左子節點資訊:");
        leftChild.displayNode();

        System.out.println("\n右子節點資訊:");
        rightChild.displayNode();

        System.out.println("\n更新後的左子節點資訊:");
        leftChild.displayNode();

        // 顯示整棵樹
        System.out.println("\n樹的結構如下:");
        printTree(root, 0);
    }
}
