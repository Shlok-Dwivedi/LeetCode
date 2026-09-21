class Solution {
    int i = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int j = 0; j < inorder.length; j++)
            map.put(inorder[j], j);

        return build(preorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(preorder[i++]);

        int mid = map.get(root.val);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}