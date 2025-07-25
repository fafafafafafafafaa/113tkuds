import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 根據前序與中序重建二元樹
    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreInHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreInHelper(int[] preorder, int preStart, int preEnd,
                                             int[] inorder, int inStart, int inEnd,
                                             Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPreInHelper(preorder, preStart + 1, preStart + leftTreeSize,
                                    inorder, inStart, inRootIndex - 1, inMap);
        root.right = buildPreInHelper(preorder, preStart + leftTreeSize + 1, preEnd,
                                     inorder, inRootIndex + 1, inEnd, inMap);

        return root;
    }

    // 2. 根據後序與中序重建二元樹
    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostInHelper(postorder, 0, postorder.length - 1,
                                 inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostInHelper(int[] postorder, int postStart, int postEnd,
                                              int[] inorder, int inStart, int inEnd,
                                              Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPostInHelper(postorder, postStart, postStart + leftTreeSize - 1,
                                     inorder, inStart, inRootIndex - 1, inMap);
        root.right = buildPostInHelper(postorder, postStart + leftTreeSize, postEnd - 1,
                                      inorder, inRootIndex + 1, inEnd, inMap);

        return root;
    }

    // 3. 驗證樹：前序遍歷
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // 驗證樹：中序遍歷
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // 驗證樹：後序遍歷
    public static void printPostorder(TreeNode root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    // 測試
    public static void main(String[] args) {
        // 範例：二元樹
        // 前序:  [3,9,20,15,7]
        // 中序:  [9,3,15,20,7]
        // 後序:  [9,15,7,20,3]

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // 根據前序和中序建樹
        TreeNode rootFromPreIn = buildTreePreIn(preorder, inorder);
        System.out.println("用前序和中序重建的樹：");
        System.out.print("前序遍歷: ");
        printPreorder(rootFromPreIn);
        System.out.println();
        System.out.print("中序遍歷: ");
        printInorder(rootFromPreIn);
        System.out.println();
        System.out.print("後序遍歷: ");
        printPostorder(rootFromPreIn);
        System.out.println("\n");

        // 根據後序和中序建樹
        TreeNode rootFromPostIn = buildTreePostIn(postorder, inorder);
        System.out.println("用後序和中序重建的樹：");
        System.out.print("前序遍歷: ");
        printPreorder(rootFromPostIn);
        System.out.println();
        System.out.print("中序遍歷: ");
        printInorder(rootFromPostIn);
        System.out.println();
        System.out.print("後序遍歷: ");
        printPostorder(rootFromPostIn);
        System.out.println();
    }
}
