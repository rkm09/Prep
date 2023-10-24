package leet.medium;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        List<Integer> res = largestValues1(root);
        res.stream().forEach(System.out::println);
    }

//    BFS time: O(n), space: O(n) where n is the number of nodes
    public static List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int currMax = Integer.MIN_VALUE;
            int currLength = queue.size();
            for(int i = 0 ; i < currLength ; i++) {
                TreeNode currNode = queue.remove();
                currMax = Math.max(currMax, currNode.val);
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            ans.add(currMax);
        }

        return ans;
    }

//    DFS same complexity as above
    public static List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    public static void dfs(TreeNode node, int depth, List<Integer> res) {
        if(node == null) return;
        if(depth == res.size()) {
            res.add(node.val);
        } else {
            res.set(depth, Math.max(res.get(depth), node.val));
        }
        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}

/*
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]


Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1
 */
