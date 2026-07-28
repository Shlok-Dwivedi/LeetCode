/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l=new ArrayList<>();
    int right_height=1;
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return l;
    }
    void helper(TreeNode root, int depth) {
    if (root == null)
        return;

    if (depth == l.size())
        l.add(root.val);

    helper(root.right, depth + 1);
    helper(root.left, depth + 1);
}
}