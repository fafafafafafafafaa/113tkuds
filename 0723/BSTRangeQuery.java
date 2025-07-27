import java.util.ArrayList;

public class BSTRangeQuery {

    // 定義 BST 節點
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 插入節點（建立 BST 用）
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // 範圍查詢函式，結果排序（中序）
    public static void rangeQuery(TreeNode root, int min, int max, ArrayList<Integer> result) {
        if (root == null) return;

        // 左子樹
        if (root.data > min) {
            rangeQuery(root.left, min, max, result);
        }

        // 中間（符合條件）
        if (root.data >= min && root.data <= max) {
            result.add(root.data);
        }

        // 右子樹
        if (root.data < max) {
            rangeQuery(root.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        // 建立 BST：[20, 10, 30, 5, 15, 25, 35]
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        int min = 12, max = 27;
        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, min, max, result);

        System.out.println("範圍 [" + min + ", " + max + "] 內的節點值: " + result);
    }
}
