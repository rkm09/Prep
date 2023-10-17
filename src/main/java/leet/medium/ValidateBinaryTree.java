package leet.medium;

import java.util.*;

public class ValidateBinaryTree {
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,-1,-1,-1};
        boolean res = validateBinaryTreeNodes1(n, leftChild, rightChild);
        System.out.println(res);
    }

//    DFS
    public static boolean validateBinaryTreeNodes1(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1) return false;

        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();

        stack.add(root);
        seen.add(root);

        while(!stack.empty()) {
            int node = stack.pop();
            int[] children = {leftChild[node], rightChild[node]};
            for(int child : children) {
                if(child != -1) {
                    if(seen.contains(child))
                        return false;
                    seen.add(child);
                    stack.push(child);
                }
            }
        }

        return seen.size() == n;
    }


//    BFS
    public static boolean validateBinaryTreeNodes2(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1) return false;

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        seen.add(root);
        queue.add(root);

        while(!queue.isEmpty()) {
            int node = queue.remove();
            int[] children = {leftChild[node], rightChild[node]};
            for(int child : children) {
                if(child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }
                    seen.add(child);
                    queue.add(child);
                }
            }
        }

        return seen.size() == n;
    }
    public static int findRoot(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for(int node : left)
            children.add(node);
        for(int node : right)
            children.add(node);

        for(int i = 0 ; i < n ; i++) {
            if(!children.contains(i))
                return i;
        }
        return -1;
    }
}

/*
You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.
Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true
Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
Output: false
Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
Output: false


Constraints:

n == leftChild.length == rightChild.length
1 <= n <= 10^4
-1 <= leftChild[i], rightChild[i] <= n - 1

As mentioned above, the root has no parent - this also means that the root is not the child of any nodes. The input arrays leftChild and rightChild describe all children, so the root would not appear in these arrays. We can simply use a for loop from 0 to n - 1 and for each number, check if it is present in leftChild or rightChild. If it's not present in either, then we can return it as the root. If we don't find any root, we can return -1.

To improve efficiency, we will convert leftChild and rightChild to a set for O(1) checks.

BFS:
BFS uses a queue instead of a stack.
Complexity Analysis

Time complexity: O(n)

To find the root, we convert leftChild and rightChild to a set, which costs O(n). Then, we iterate over all nodes, which also costs O(n).

Once we have the root, we perform a BFS that costs O(n) as we never visit a node more than once. Note that an efficient queue implementation with O(1) operations is required to achieve this complexity.

Space complexity: O(n)

We require O(n) space when converting leftChild and rightChild to a set to find the root. We also require O(n) space for queue and seen during the BFS.

Once the DFS finishes, every node we visited will be in seen. If the tree is connected, then the length of seen will be equal to n. If seen.length != n, it means that some nodes were not visited, and thus the tree must be disconnected. Thus, we can return seen.length == n at the end of the algorithm.

This process is sufficient in validating a binary tree:

If a binary tree does not have a root, then findRoot will return -1.
If there is a node with more than one parent, then we will detect it with seen.
If the tree is disconnected, then seen will hold less than n nodes at the end.
If there is a cycle, then we will detect it with seen.
Any other scenario we don't explicitly check for will be caught by some other rule. For example, the second rule we stated was:

Every node other than the root must have exactly one parent.

You may be thinking: we are explicitly checking the case when a node has multiple parents with seen, but what if there is a node with no parent other than the root? That is, what if there are multiple roots? In that scenario, findRoot would give us the root with the lowest value. We would perform a DFS from there, and never reach any of the other roots. Then at the end, seen would have less than n nodes.
 */