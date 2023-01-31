class Solution {
    int index=0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length !=   inorder.length) 
            return null;
        
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i);
        return dfs(inorder, preorder, 0, inorder.length - 1);
        
    }
    public TreeNode dfs(int[] inorder, int[] preorder, int start, int end) {
        if (start > end) return null; // catch dfs attempting to process visisted nodes
        int rootVal = preorder[index++];
        int rootInd = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        if (start == end)
            return root;
        root.left = dfs(inorder, preorder, start, rootInd - 1);
        root.right = dfs(inorder, preorder, rootInd + 1, end);
        return root;
    }
}