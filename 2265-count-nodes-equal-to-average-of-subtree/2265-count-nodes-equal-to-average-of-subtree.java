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
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<int[]> values = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node != null){
                stack.push(node);
                stack.push(null);

                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
            }
            else{
                TreeNode cur = stack.pop();

                int sum = cur.val;
                int count = 1;

                if(cur.left != null){
                    int[] x = values.pop();
                    sum += x[0];
                    count += x[1];
                }

                if(cur.right != null){
                    int[] x = values.pop();
                    sum += x[0];
                    count += x[1];
                }

                if(sum / count == cur.val)
                    ans++;

                values.push(new int[]{sum, count});
            }
        }

        return ans;
    }
}