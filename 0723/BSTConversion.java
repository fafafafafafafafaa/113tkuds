import java.util.*;

public class BSTConversion {

    static class TreeNode {
        int data;
        TreeNode left, right;  // 也用作雙向鏈表的 prev/next

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. BST轉雙向鏈表（中序遍歷，in-place）
    static TreeNode prev = null;   // 紀錄前一節點
    static TreeNode head = null;   // 雙向鏈表頭節點

    public static TreeNode bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        inorderConvert(root);
        return head;
    }

    private static void inorderConvert(TreeNode node) {
        if (node == null) return;

        inorderConvert(node.left);

        if (prev == null) {
            head = node;  // 最左節點為head
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        inorderConvert(node.right);
    }

    // 2. 排序陣列轉平衡BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length -1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return root;
    }

    // 3. BST轉換為累加樹（節點值改為所有大於等於該節點值的節點值總和）
    // 用反中序遍歷（右->中->左）
    static int sum = 0;

    public static void bstToGreaterSumTree(TreeNode root) {
        sum = 0;
        reverseInorder(root);
    }

    private static void reverseInorder(TreeNode node) {
        if (node == null) return;

        reverseInorder(node.right);

        sum += node.data;
        node.data = sum;

        reverseInorder(node.left);
    }

    // 工具：中序遍歷印出樹節點
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // 印出雙向鏈表（從head往right遍歷）
    public static void printDoublyList(TreeNode head) {
        System.out.print("雙向鏈表: ");
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 範例 BST
        /*
                  20
                 /  \
                10  30
               / \   \
              5  15  40
         */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.right = new TreeNode(40);

        System.out.print("原BST中序: ");
        printInorder(root);
        System.out.println();

        // 1. BST轉雙向鏈表
        TreeNode head = bstToDoublyList(root);
        printDoublyList(head);

        // 2. 排序陣列轉平衡BST
        int[] sortedArr = {1, 3, 5, 7, 9, 11};
        TreeNode balancedRoot = sortedArrayToBST(sortedArr);
        System.out.print("排序陣列轉平衡BST中序: ");
        printInorder(balancedRoot);
        System.out.println();

        // 3. BST轉累加樹
        bstToGreaterSumTree(balancedRoot);
        System.out.print("累加樹中序: ");
        printInorder(balancedRoot);
        System.out.println();
    }
}
