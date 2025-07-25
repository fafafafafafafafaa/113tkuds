import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 驗證是否為BST
    // 利用中序遍歷的遞增性驗證
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    // 範圍限定法（min < node.data < max）
    private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) {
            return false;
        }
        return isValidBSTHelper(node.left, min, node.data) && 
               isValidBSTHelper(node.right, node.data, max);
    }

    // 2. 找出不符合BST規則的節點（以節點值表示）
    // 將所有節點遍歷，用同樣範圍判斷，違反規則的加入列表
    public static List<Integer> findViolations(TreeNode root) {
        List<Integer> violations = new ArrayList<>();
        findViolationsHelper(root, null, null, violations);
        return violations;
    }

    private static void findViolationsHelper(TreeNode node, Integer min, Integer max, List<Integer> violations) {
        if (node == null) return;
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) {
            violations.add(node.data);
        }
        findViolationsHelper(node.left, min, node.data, violations);
        findViolationsHelper(node.right, node.data, max, violations);
    }

    // 3. 計算最少移除節點數使樹成為BST
    // 方法：找出樹中最大BST子樹節點數，答案 = 總節點數 - 最大BST子樹節點數
    static class Result {
        boolean isBST;
        int size;      // subtree size
        int minVal;
        int maxVal;
        int maxBSTSize; // max BST subtree size in this subtree
    }

    public static int minRemoveToBST(TreeNode root) {
        int totalNodes = countNodes(root);
        Result res = largestBSTSubtree(root);
        return totalNodes - res.maxBSTSize;
    }

    // 計算節點數
    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // 找最大BST子樹
    private static Result largestBSTSubtree(TreeNode node) {
        if (node == null) {
            Result res = new Result();
            res.isBST = true;
            res.size = 0;
            res.minVal = Integer.MAX_VALUE;
            res.maxVal = Integer.MIN_VALUE;
            res.maxBSTSize = 0;
            return res;
        }

        Result left = largestBSTSubtree(node.left);
        Result right = largestBSTSubtree(node.right);

        Result res = new Result();
        res.size = 1 + left.size + right.size;

        if (left.isBST && right.isBST && node.data > left.maxVal && node.data < right.minVal) {
            res.isBST = true;
            res.minVal = Math.min(left.minVal, node.data);
            res.maxVal = Math.max(right.maxVal, node.data);
            res.maxBSTSize = res.size; // 整棵子樹是BST
        } else {
            res.isBST = false;
            res.minVal = Integer.MIN_VALUE;
            res.maxVal = Integer.MAX_VALUE;
            res.maxBSTSize = Math.max(left.maxBSTSize, right.maxBSTSize);
        }
        return res;
    }

    // 測試範例
    public static void main(String[] args) {
        /*
            範例樹（非BST）：
                  10
                 /  \
                5    15
               / \     \
              1   12    20
        12節點違反BST規則，因為它在5的右子樹，但大於10

            節點數：6
            最大BST子樹：包含節點{1,5}或{15,20}大小為2
            所以最少移除節點數 = 6 - 2 = 4
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(12);
        root.right.right = new TreeNode(20);

        System.out.println("是否為有效BST: " + isValidBST(root));

        List<Integer> violations = findViolations(root);
        System.out.println("不符合BST規則的節點: " + violations);

        int toRemove = minRemoveToBST(root);
        System.out.println("最少需要移除節點數使成為BST: " + toRemove);
    }
}
