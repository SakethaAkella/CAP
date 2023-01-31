class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) 
            return null;
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode dfs(int[] preorder, int min, int max) {
        if (index == preorder.length) return null;
        int val = preorder[index];
        
        if (val <= min || val >= max) return null;
        index++;
        TreeNode node = new TreeNode(val);
        node.left = dfs(preorder, min, val);
        node.right = dfs(preorder, val, max);
        return node;
    }
}