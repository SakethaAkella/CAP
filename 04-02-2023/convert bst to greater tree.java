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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode curr){
        if(curr==null){
            return;
        }
        convert(curr.right);
        sum += curr.val;
        curr.val = sum;
        convert(curr.left);
    }
}