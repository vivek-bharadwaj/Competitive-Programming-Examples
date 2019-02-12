/* 
Given a binary tree, return the preorder traversal of its nodes' values
*/

// Source: Leetcode

/*
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
*/

/**
    Definition of a Binary Tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 */
 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorder = helper(root, preorder);
        return preorder;
    }
    
    private List<Integer> helper(TreeNode r, List<Integer> l) {
        if(r != null) {
            l.add(r.val);
            l = helper(r.left, l);
            l = helper(r.right, l);
        }
        return l;
    }
}