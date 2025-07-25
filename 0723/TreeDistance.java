import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 輔助：找兩節點最近公共祖先 (LCA)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 計算從root開始到target節點的距離 (節點個數-1)
    public static int distanceFromRoot(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) return 0;

        int leftDist = distanceFromRoot(root.left, target);
        if (leftDist >= 0) return leftDist + 1;

        int rightDist = distanceFromRoot(root.right, target);
        if (rightDist >= 0) return rightDist + 1;

        return -1;
    }

    // 1. 計算任意兩節點間距離 = dist(root, p) + dist(root, q) - 2 * dist(root, LCA)
    public static int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        int distP = distanceFromRoot(root, p);
        int distQ = distanceFromRoot(root, q);
        int distLCA = distanceFromRoot(root, lca);
        return distP + distQ - 2 * distLCA;
    }

    // 2. 找樹的直徑（最大兩節點距離）
    // 同時回傳高度與最大直徑，使用輔助類別
    static class DiameterInfo {
        int height;
        int diameter;

        DiameterInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int treeDiameter(TreeNode root) {
        return diameterHelper(root).diameter;
    }

    private static DiameterInfo diameterHelper(TreeNode node) {
        if (node == null) return new DiameterInfo(0, 0);

        DiameterInfo left = diameterHelper(node.left);
        DiameterInfo right = diameterHelper(node.right);

        int height = Math.max(left.height, right.height) + 1;

        int pathThroughRoot = left.height + right.height;
        int maxDiameter = Math.max(Math.max(left.diameter, right.diameter), pathThroughRoot);

        return new DiameterInfo(height, maxDiameter);
    }

    // 3. 找距離根節點為distance的所有節點
    public static List<TreeNode> nodesAtDistance(TreeNode root, int distance) {
        List<TreeNode> res = new ArrayList<>();
        findNodesAtDistance(root, distance, res);
        return res;
    }

    private static void findNodesAtDistance(TreeNode node, int distance, List<TreeNode> res) {
        if (node == null) return;
        if (distance == 0) {
            res.add(node);
            return;
        }
        findNodesAtDistance(node.left, distance - 1, res);
        findNodesAtDistance(node.right, distance - 1, res);
    }

    // 輔助：前序印節點資料
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // 測試範例
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \   \
          4   5   6
         /
        7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        // 節點間距離: 7 和 5
        System.out.println("節點7和5距離: " + distanceBetweenNodes(root, root.left.left.left, root.left.right));

        // 樹的直徑
        System.out.println("樹的直徑: " + treeDiameter(root));

        // 距離根節點為2的節點
        List<TreeNode> nodesDist2 = nodesAtDistance(root, 2);
        System.out.print("距離根節點為2的節點: ");
        for (TreeNode n : nodesDist2) {
            System.out.print(n.data + " ");
        }
        System.out.println();
    }
}
