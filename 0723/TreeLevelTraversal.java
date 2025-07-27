import java.util.*;

public class TreeLevelTraversal {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 取得每層節點列表（普通層序遍歷）
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.data);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelList);
        }
        return res;
    }

    // 之字形層序遍歷（Zigzag），每層節點存在不同 List
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 根據方向加入頭尾
                if (leftToRight) {
                    levelList.addLast(node.data);
                } else {
                    levelList.addFirst(node.data);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(levelList);
            leftToRight = !leftToRight; // 翻轉方向
        }

        return res;
    }

    // 只印出每層最後一個節點（從zigzag結果中取）
    public static void printLastNodeOfEachLevel(List<List<Integer>> levels) {
        System.out.println("每層最後一個節點：");
        for (List<Integer> level : levels) {
            if (!level.isEmpty()) {
                System.out.println(level.get(level.size() - 1));
            }
        }
    }

    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            / \   \
           4   5   6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 普通層序遍歷
        List<List<Integer>> levels = levelOrder(root);
        System.out.println("普通層序遍歷:");
        System.out.println(levels);

        // 之字形層序遍歷
        List<List<Integer>> zigzagLevels = zigzagLevelOrder(root);
        System.out.println("之字形層序遍歷:");
        System.out.println(zigzagLevels);

        // 印出每層最後一個節點
        printLastNodeOfEachLevel(zigzagLevels);
    }
}
