package leet.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CorrectBinaryTree {
    public static void main(String[] args) {
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2, null, right);
        TreeNode root = new TreeNode(1, left, right);
        TreeNode ans = correctBinaryTree(root);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.right.val);
    }
    public static TreeNode correctBinaryTree(TreeNode root) {
        // Queue for BFS. Every element stores [node, parent]
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root, null});

        // Traverse Level by Level
        while(!queue.isEmpty()) {
            // Nodes in the current level
            int currSize = queue.size();
            // Hash Set to store nodes of the current level
            HashSet<TreeNode> visited = new HashSet<>();
            // Traverse all nodes in the current level
            for(int i = 0 ; i < currSize ; i++) {
                // Pop the node and its parent from the queue
                TreeNode[] temp = queue.poll();
                TreeNode node = temp[0];
                TreeNode parent = temp[1];
                // If node.right is already visited, then node is defective
                if(visited.contains(node.right)) {
                    // Replace the child of node's parent with null and return root
                    if(parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return root;
                }
                // Add node to visited
                visited.add(node);
                // Add child in queue for traversal in next level
                // They won't get popped in this level because of "n"
                // Add right child first, so that we can explore right to left
                if(node.right != null) {
                    queue.add(new TreeNode[] {node.right, node});
                }
                if(node.left != null) {
                    queue.add(new TreeNode[] {node.left, node});
                }
            }
        }
        return root;
    }
}

/*
You have a binary tree with a small defect. There is exactly one invalid node where its right child incorrectly points to another node at the same depth but to the invalid node's right.

Given the root of the binary tree with this defect, root, return the root of the binary tree after removing this invalid node and every node underneath it (minus the node it incorrectly points to).

Custom testing:

The test input is read as 3 lines:

TreeNode root
int fromNode (not available to correctBinaryTree)
int toNode (not available to correctBinaryTree)
After the binary tree rooted at root is parsed, the TreeNode with value of fromNode will have its right child pointer pointing to the TreeNode with a value of toNode. Then, root is passed to correctBinaryTree.

Input: root = [1,2,3], fromNode = 2, toNode = 3
Output: [1,null,3]
Explanation: The node with value 2 is invalid, so remove it.

Input: root = [8,3,1,7,null,9,4,2,null,null,null,5,6], fromNode = 7, toNode = 4
Output: [8,3,1,null,null,9,4,null,null,5,6]
Explanation: The node with value 7 is invalid, so remove it and the node underneath it, node 2.


Constraints:

The number of nodes in the tree is in the range [3, 104].
-109 <= Node.val <= 109
All Node.val are unique.
fromNode != toNode
fromNode and toNode will exist in the tree and will be on the same depth.
toNode is to the right of fromNode.
fromNode.right is null in the initial tree from the test data.


BFS:
Time complexity: O(N)

The queue processes every node at most once.

Now processing includes

popping the node from the queue

checking if node.right is already visited

adding node in the visited set

adding node.right and node.left in the queue for traversal in the next level

Thus, processing one node takes O(1) time. Thus, processing all nodes takes O(N) time.

Space complexity: O(N)

The queue can have at most N nodes. The visited set can have at most N nodes. Thus, the overall space complexity is O(N).
 */
