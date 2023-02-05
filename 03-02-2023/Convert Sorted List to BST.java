/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int n=0;
        ListNode curr = head;
        node = head;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        return split(0,n-1);
    }
    public TreeNode split(int start, int end){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode left = split(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        TreeNode right = split(mid + 1, end);
        root.right = right;
        return root;
    }
}