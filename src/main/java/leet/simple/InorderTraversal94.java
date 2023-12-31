package leet.simple;

import leet.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal94 {
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode c1 = new TreeNode(3);
        TreeNode right = new TreeNode(2, c1, null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(inorderTraversal1(root));
    }

//    [def]; recursion; time: O(n), space: O(n)
    public static List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }
    private static void traverse(TreeNode node) {
        if(node == null) return;
        traverse(node.left);
        res.add(node.val);
        traverse(node.right);
    }

//    Iterative stack; time: O(n), space: O(n)
    private static List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !stack.empty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
 */