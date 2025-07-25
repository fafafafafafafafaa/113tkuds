public class TreeMirror {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 功能 1：判斷是否對稱（左右子樹互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 工具：判斷兩棵子樹是否互為鏡像
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // 功能 2：將一棵樹轉成鏡像樹（原地修改）
    public static void mirror(TreeNode root) {
        if (root == null) return;

        // 遞迴鏡像左右子樹
        mirror(root.left);
        mirror(root.right);

        // 交換左右子樹
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // 功能 3：比較兩棵樹是否互為鏡像
    public static boolean areMirrors(TreeNode t1, TreeNode t2) {
        return isMirror(t1, t2);
    }

    // 測試範例
    public static void main(String[] args) {
        /*
              範例對稱樹：
                  1
                 / \
                2   2
               / \ / \
              3  4 4  3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("這棵樹是對稱的嗎？" + isSymmetric(root)); // true

        // 建立另一棵樹
        TreeNode treeA = new TreeNode(1);
        treeA.left = new TreeNode(2);
        treeA.right = new TreeNode(3);

        TreeNode treeB = new TreeNode(1);
        treeB.left = new TreeNode(3);
        treeB.right = new TreeNode(2);

        System.out.println("treeA 與 treeB 是鏡像的嗎？" + areMirrors(treeA, treeB)); // true

        // 鏡像原本的 root 樹
        mirror(root);
        System.out.println("鏡像後，這棵樹還是對稱的嗎？" + isSymmetric(root)); // true（鏡像對稱仍對稱）
    }
}
