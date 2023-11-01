package leet.simple;


import leet.medium.TreeNode;

import java.util.*;

public class FindModeBST {
    static HashMap<Integer, Integer> hmodes = new HashMap<>();
    public static void main(String[] args) {
//        [1, null, 2, 2]
        TreeNode left = null;
        TreeNode leftOfRight = new TreeNode(2);
        TreeNode right = new TreeNode(2, leftOfRight, null);
        TreeNode root = new TreeNode(1, left, right);
//        TreeNode root1 = new TreeNode(0);
        int[] res = findMode3(root);
        System.out.println(Arrays.toString(res));
    }

//    recursive dfs; time: O(n), space: O(n)
    public static int[] findMode3(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        dfs(root, counter);

        int maxFreq = 0;
        for(int key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }
        List<Integer> resList = new ArrayList<>();
        for(int key : counter.keySet()) {
            if(maxFreq == counter.get(key))
                resList.add(key);
        }

        int[] res = new int[resList.size()];
        for(int i = 0 ; i < res.length ; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }


//    bfs; time: O(n), space: O(n)
    public static int[] findMode2(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }

        int maxFreq = 0;
        for(int key : counter.keySet()) {
            maxFreq = Math.max(maxFreq, counter.get(key));
        }

        List<Integer> resList = new ArrayList<>();
        for(int key : counter.keySet()) {
            if(maxFreq == counter.get(key))
                resList.add(key);
        }

        int[] res = new int[resList.size()];
        for(int i = 0 ; i < res.length ; i++) {
            res[i] = resList.get(i);
        }
        return res;

    }


//    Our solutions ....
//    bfs; time: O(n), space: O(n)
    public static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> hmode = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int count = hmode.containsKey(node.val) ? hmode.get(node.val) : 0;
            hmode.put(node.val, ++count);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }

        int mode = 0;
        for(Map.Entry<Integer, Integer> entry : hmode.entrySet()) {
            int val = entry.getValue();
            if(val > mode){
                mode = val;
            }
        }

        List<Integer> li = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hmode.entrySet()) {
            if(entry.getValue() == mode) li.add(entry.getKey());
        }

        int n = li.size();
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++) {
            res[i] = li.get(i);
        }
        return res;
    }

//    recursive dfs; time: O(n), space: O(n)
    public static int[] findMode1(TreeNode root) {
        hmodes.put(root.val, 0);
        dfs(root);
        int mode = 0;
        for(Map.Entry<Integer, Integer> entry : hmodes.entrySet()) {
           if(entry.getValue() > mode) {
               mode = entry.getValue();
           }
        }
        List<Integer> li = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hmodes.entrySet()) {
            if(mode == entry.getValue()) {
                li.add(entry.getKey());
            }
        }
        int n = li.size();
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++) {
            res[i] = li.get(i);
        }
        return res;
    }
    public static void dfs(TreeNode node) {
        int count = hmodes.containsKey(node.val) ? hmodes.get(node.val) : 0;
        hmodes.put(node.val, ++count);

        if(node.left != null) dfs(node.left);
        if(node.right != null) dfs(node.right);
    }
}

/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]


Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105


Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */