/** 
Given a binary tree, check whether it is a Binary Search Tree

Assuming
left <= root < right
*/

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public boolean isBST(TreeNode node, int min, int max) {
    if(node == null)
        return true;
    
    if(node.value < min || node.value > max)
        return false;

    return isBST(node.left, min, node.value) && isBST(node.right, node.value + 1, max);
}