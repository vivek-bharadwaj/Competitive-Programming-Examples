/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

 
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
 public List<List<Integer>> levelOrder(TreeNode root) {
     List<List<Integer>> traversal = new ArrayList<>();
     Queue<TreeNode> q = new LinkedList<>();

     if(root == null)
        return traversal;

    q.offer(root);
    while(!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            TreeNode current = q.poll();
            level.add(current.val);
            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }
        traversal.add(level);
    }
    return traversal;
 }
}
