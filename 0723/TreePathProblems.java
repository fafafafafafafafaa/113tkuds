import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 找出所有根到葉節點的路徑（以List<List<Integer>>回傳）
    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        dfsPaths(root, path, res);
        return res;
    }

    private static void dfsPaths(TreeNode node, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.data);

        // 如果是葉節點，加入結果
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            dfsPaths(node.left, path, res);
            dfsPaths(node.right, path, res);
        }

        path.remove(path.size() - 1);  // 回溯
    }

    // 2. 判斷是否存在根到葉路徑，和為 targetSum
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 葉節點判斷
        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.data) ||
               hasPathSum(root.right, targetSum - root.data);
    }

    // 3. 找出根到葉路徑和最大值（只回傳最大和）
    public static int maxRootToLeafSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE; // 無效路徑

        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftMax = maxRootToLeafSum(root.left);
        int rightMax = maxRootToLeafSum(root.right);

        return root.data + Math.max(leftMax, rightMax);
    }

    // 測試範例
    public static void main(String[] args) {
        /*
              10
             /  \
            5    12
           / \     \
          4   7     15
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(15);

        // 1. 所有根到葉路徑
        List<List<Integer>> paths = allRootToLeafPaths(root);
        System.out.println("所有根到葉路徑:");
        for (List<Integer> p : paths) {
            System.out.println(p);
        }

        // 2. 判斷是否有路徑和為22
        int targetSum = 22;
        System.out.println("存在根到葉路徑和為 " + targetSum + " 嗎？" + hasPathSum(root, targetSum));

        // 3. 最大根到葉路徑和
        System.out.println("最大根到葉路徑和: " + maxRootToLeafSum(root));
    }
}
