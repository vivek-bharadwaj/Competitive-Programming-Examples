/* 
Given a binary tree, return the inorder traversal of its nodes' values
*/

// Source: LeetCode

/* 
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder = helper(root, inorder);
        return inorder;
    }
    
    private List<Integer> helper(TreeNode r, List<Integer> l) {
        if(r != null) {
            l = helper(r.left, l);
            l.add(r.val);
            l = helper(r.right, l);
        }
        return l;
    }
}