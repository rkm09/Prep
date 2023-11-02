package leet.medium;

import java.util.*;

public class AverageOfSubTree {
    static int count = 0;
    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(6);
        TreeNode left = new TreeNode(8, left1, right1);
        TreeNode right = new TreeNode(5, null, right2);
        TreeNode root = new TreeNode(4, left, right);

        int res = averageOfSubtree(root);
        System.out.println(res);
    }
    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

//    postorder traversal; time: O(n), space: O(n)
    public static int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int totalSum = left[0] + right[0] + root.val;
        int totalCount = left[1] + right[1] + 1;

        if(root.val == totalSum / totalCount) {
            count++;
        }

        return new int[]{totalSum, totalCount};
    }
}

/*
Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation:
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.
Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
 */