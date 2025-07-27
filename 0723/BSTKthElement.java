public class BSTKthElement {

    // 定義 BST 節點
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 建立 BST：插入節點
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // 包裝類：用來記錄目前數到第幾個，以及答案
    static class Counter {
        int count = 0;
        int result = -1;
    }

    // 找第 k 小元素（中序：左->中->右）
    public static void findKth(TreeNode root, int k, Counter counter) {
        if (root == null || counter.count >= k) return;

        findKth(root.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = root.data;
            return;
        }

        findKth(root.right, k, counter);
    }

    // 主程式
    public static void main(String[] args) {
        /*
            建立 BST：
                    20
                   /  \
                 10    30
                 / \   / \
                5  15 25 35
         */
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        int k = 3; // 第三小
        Counter counter = new Counter();
        findKth(root, k, counter);

        if (counter.result != -1) {
            System.out.println("BST中第 " + k + " 小的元素是: " + counter.result);
        } else {
            System.out.println("第 " + k + " 小的元素不存在。");
        }
    }
}
