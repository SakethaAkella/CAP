class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return result;
        getval(root1);
        getval(root2);
        Collections.sort(result);
        return result;
    }
    public void getval(TreeNode root){
        if(root == null)
            return;
        else {
            result.add(root.val);
            getval(root.left);
            getval(root.right);
        }
}