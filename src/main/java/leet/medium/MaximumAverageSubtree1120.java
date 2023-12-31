package leet.medium;

public class MaximumAverageSubtree1120 {
    private double average = 0.0;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(1);
        TreeNode root = new TreeNode(5, left, right);
        MaximumAverageSubtree1120 maxAvg = new MaximumAverageSubtree1120();
        System.out.println(maxAvg.maximumAverageSubtree2(root));
    }

    class State {
        int nodeCount;
        int sumValue;
        double maxAverage;
        State(int nodeCount, int sumValue, double maxAverage) {
            this.nodeCount = nodeCount;
            this.sumValue = sumValue;
            this.maxAverage = maxAverage;
        }
    }

//    Postorder traversal; time: O(N), space: O(N)
    public double maximumAverageSubtree(TreeNode root) {
        return maxAverage(root).maxAverage;
    }
    private State maxAverage(TreeNode node) {
        if(node == null) {
            return new State(0,0,0);
        }
        State left = maxAverage(node.left);
        State right = maxAverage(node.right);

        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int sumValue = left.sumValue + right.sumValue + node.val;
        double maxAverage = Math.max((1.0 * sumValue) / nodeCount, Math.max(left.maxAverage, right.maxAverage));

        return  new State(nodeCount, sumValue, maxAverage);
    }

//    without updating in place; can use Pair too..with avg as a separate variable
    public double maximumAverageSubtree2(TreeNode root) {
        return helper1(root)[2];
    }
    private double[] helper1(TreeNode node) {
        if(node == null) return new double[]{0,0,0};
        double[] left = helper1(node.left);
        double[] right = helper1(node.right);
        double maxChild = Math.max(left[2], right[2]);
        double sum = left[0] + right[0] + node.val;
        double count = left[1] + right[1] + 1;
        double maxAverage = Math.max(sum/count, maxChild);
        return new double[] {sum, count, maxAverage};
    }

//    Another way (updating in place);
    public double maximumAverageSubtree1(TreeNode root) {
        helper(root);
        return average;
    }
    private int helper(TreeNode node) {
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int count = left + right + 1;
        if(left != 0) {
            node.val += node.left.val;
        }
        if(right != 0) {
            node.val += node.right.val;
        }
        average = Math.max(average, (double)(node.val)/ count);
        return count;
    }
}

/*
Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.
A subtree of a tree is any node of that tree plus all its descendants.
The average value of a tree is the sum of its values, divided by the number of nodes.
Input: root = [5,6,1]
Output: 6.00000
Explanation:
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
Example 2:
Input: root = [0,null,1]
Output: 1.00000
Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 105
 */