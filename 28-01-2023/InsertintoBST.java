class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode Node=new TreeNode(val);
            return Node;
        }
        if(val<root.val){
            root.left=insertIntoBST(root.left,val);
            return root;
        }
        else{
            root.right=insertIntoBST(root.right,val);
            return root;
        }
    }
}