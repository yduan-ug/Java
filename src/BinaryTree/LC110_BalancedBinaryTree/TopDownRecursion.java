package BinaryTree.LC110_BalancedBinaryTree;

import BinaryTree.TreeNode;
/*
Given a binary tree, determine if it is height-balanced.


Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true


Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
*/
public class TopDownRecursion {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1;
    }

    private int getHeight(TreeNode root) {
        // only one node, balanced
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1) return -1;
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
