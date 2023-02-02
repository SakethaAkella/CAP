class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        Sum(root,low,high);
        return sum;
    }
    public void Sum(TreeNode root, int low, int high){
        if(root!=null){
            if(root.val>=low && root.val<=high){
                sum+=root.val;
            }
            if(root.val>low){
                Sum(root.left,low,high);
            }
            if(root.val<high){
                Sum(root.right,low,high);
            }
        }
    }
}