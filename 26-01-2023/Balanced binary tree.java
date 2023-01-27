class Solution {
    public static int height(TreeNode root)
    {
        if(root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l , r) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return (height(root) != -1);
    }
}