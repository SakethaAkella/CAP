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
    List<Integer> inorder = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if(root==null){
            return null;
        }
        inorder(root);
        TreeNode rootNew = createBST(0,inorder.size()-1);
        return rootNew;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
    public TreeNode createBST(int low, int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        int curr = inorder.get(mid);
        TreeNode left = createBST(low,mid-1);
        TreeNode right = createBST(mid+1,high);
        TreeNode node= new TreeNode(curr,left,right);
        return node;
    }
}