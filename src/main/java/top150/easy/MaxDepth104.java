package top150.easy;

import leet.medium.TreeNode;

import java.util.Stack;

public class MaxDepth104 {
    public static void main(String[] args) {
        TreeNode rightFirstChild = new TreeNode(15);
        TreeNode rightSecondChild = new TreeNode(7);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, rightFirstChild, rightSecondChild);
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(maxDepth1(root));
    }

//    dfs & recursion; time : O(n), space: O(n)
//    could have also used bfs; one problem with recursion is space overuse could lead to stack overflow;
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

//    Iterative dfs with stack; time: O(n), space: O(n)
    public static int maxDepth1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);
        int depth = 0, currentDepth;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            currentDepth = depths.pop();
            if(node != null) {
                depth = Math.max(depth, currentDepth);
                stack.push(node.right);
                stack.push(node.left);
                depths.push(currentDepth + 1);
                depths.push(currentDepth + 1);
            }
        }
        return depth;
    }
}

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2
Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */