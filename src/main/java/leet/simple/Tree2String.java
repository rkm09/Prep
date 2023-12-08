package leet.simple;

import leet.medium.TreeNode;

public class Tree2String {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2, node, null);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(tree2str(root));
    }
    public static String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        binaryTreeTraversal(root, sb);
        return sb.toString();
    }
    private static void binaryTreeTraversal(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        sb.append(node.val);
        if(node.left != null) {
            sb.append("(");
            binaryTreeTraversal(node.left, sb);
            sb.append(")");
        } else if(node.right != null) {
            sb.append("()");
        }
        if(node.right != null) {
            sb.append("(");
            binaryTreeTraversal(node.right, sb);
            sb.append(")");
        }
    }
}

/*
Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
Constraints:
The number of nodes in the tree is in the range [1, 104].
-1000 <= Node.val <= 1000
 */