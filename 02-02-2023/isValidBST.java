class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean isBST(TreeNode root,double min,double max){
        if(root==null){
            return true;
        }
        if(root.val<=min || root.val>=max)
            return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}