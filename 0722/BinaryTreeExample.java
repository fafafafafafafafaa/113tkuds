public static void main(String[] args) {
    // 建立測試樹（高度 = 5，節點數 = 9）：
    //        1
    //       / \
    //      2   3
    //     /     \
    //    4       5
    //   /         \
    //  6           7
    // /             \
    //8               9

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(6);
    root.left.left.left.left = new TreeNode(8);

    root.right.right = new TreeNode(5);
    root.right.right.right = new TreeNode(7);
    root.right.right.right.right = new TreeNode(9);

    System.out.print("前序走訪: ");
    preOrder(root); // 1 2 4 6 8 3 5 7 9
    System.out.println();

    System.out.println("樹的高度: " + getHeight(root));   // 5
    System.out.println("節點總數: " + countNodes(root));  // 9
    System.out.println("搜尋 4: " + search(root, 4));     // true
    System.out.println("搜尋 6: " + search(root, 6));     // true
    System.out.println("搜尋 10: " + search(root, 10));   // false
}
