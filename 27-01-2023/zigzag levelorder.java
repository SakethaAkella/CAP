class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) 
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int l = 0;
        boolean lr = true;
        while (!q.isEmpty()) {
            List<Integer> sub = new LinkedList<>();
            int len=q.size();
            for(int i=0; i<len; i++){
                TreeNode node = q.peek();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                sub.add(q.remove().val);
            }
            if(l%2==1){
                Collections.reverse(sub);
            }
            res.add(sub);
            l++;
        }
        return res;
    }
}