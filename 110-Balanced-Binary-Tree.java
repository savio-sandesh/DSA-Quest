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
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        variable(root);
        return result;
    }
    public int variable (TreeNode root){
        if(root==null){
            return 0;
        }
        int l = variable(root.left);
        int r = variable(root.right);
        if(Math.abs(l-r)>1) result=false;
        return 1+ Math.max(l,r);
    }
   
}