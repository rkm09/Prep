package top150.medium;


import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {
    static Map<Node, Node> visitedNodeMap = new HashMap<>();

    public static void main(String[] args) {
        Node head = new Node(3);
        Node one = new Node(3);
        Node two = new Node(3);
        head.next = one;
        one.next = two;
        one.random = head;
        Node node = copyRandomList2(head);
        System.out.println(node.next.val);
    }

    //    recursion; time: O(n), space: O(n)
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visitedNodeMap.containsKey(head)) {
            return visitedNodeMap.get(head);
        }
        Node node = new Node(head.val);
        visitedNodeMap.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

//    iterative; time: O(n), space:O(n)
    public static Node copyRandomList1(Node head) {
        if(head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visitedNodeMap.put(oldNode, newNode);
        while(oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedNodeMap.get(head);
    }
    private static Node getClonedNode(Node node) {
        if(node != null) {
            if (visitedNodeMap.containsKey(node)) {
                return visitedNodeMap.get(node);
            }
            visitedNodeMap.put(node, new Node(node.val));
            return visitedNodeMap.get(node);
        }
        return null;
    }

//    iterative, constant space; time: O(n), space: O(1)
//    interweave A->A'->B->B'->C->C'
    public static Node copyRandomList2(Node head) {
        if(head == null) {
            return null;
        }
        Node oldNodePtr = head;
        while(oldNodePtr != null) {
            Node newNodePtr = new Node(oldNodePtr.val);
            newNodePtr.next = oldNodePtr.next;
            oldNodePtr.next = newNodePtr;
            oldNodePtr = newNodePtr.next;
        }
//        interweave random
        oldNodePtr = head;
        while(oldNodePtr != null) {
            oldNodePtr.next.random = (oldNodePtr.random != null) ? oldNodePtr.random.next : null;
            oldNodePtr = oldNodePtr.next.next;
        }

//      separate out both lists again
        Node oldNodeList = head;
        Node newNodeList = head.next;
        Node newHead = head.next;
        while(oldNodeList != null) {
            oldNodeList.next = oldNodeList.next.next;
            newNodeList.next = (oldNodeList.next != null) ? oldNodeList.next.next : null;
            oldNodeList = oldNodeList.next;
            newNodeList = newNodeList.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node random, Node next) {
        this.val = val;
        this.random = random;
        this.next = next;
    }
}
/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Constraints:
0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
 */