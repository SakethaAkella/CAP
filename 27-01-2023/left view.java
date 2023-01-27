class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        List<Integer> out = new ArrayList<>();
        for(int i=0; i<res.size(); i++){
            List<Integer> temp = res.get(i);
            out.add(temp.get(0));
        }
        return out;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) 
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int l = 0;
        while (!q.isEmpty()) {
            res.add(new ArrayList<>());
            int len=q.size();
            for(int i=0; i<len; i++){
                TreeNode node = q.remove();
                res.get(l).add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null) 
                    q.add(node.right);
            }
            l++;
        }
        return res;
    }
}