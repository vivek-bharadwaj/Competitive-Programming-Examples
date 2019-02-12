/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorder = helper(root, postorder);
        return postorder;
    }
    
    private List<Integer> helper(TreeNode r, List<Integer> l) {
        if(r != null) {
            l = helper(r.left, l);
            l = helper(r.right, l);
            l.add(r.val);
        }
        return l;
    }
}