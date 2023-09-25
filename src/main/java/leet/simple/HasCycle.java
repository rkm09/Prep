package leet.simple;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {
        ListNode zero = new ListNode(3);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(-4);
        zero.next = one; one.next = two; two.next = three; three.next = one;
        boolean res = hasCycle1(zero);
        System.out.println(res);
    }
//    Hashtable
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
//    Solve using O(1) (i.e. constant) memory [Floyd's hare & tortoise algorithm]
    public static boolean hasCycle1(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
/*
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Complexity:
Time: O(n)
We visit each of the nnn elements in the list at most once. Adding a node to the hash table costs only O(1) time.
Space: O(n) for hashtable approach
he space depends on the number of elements added to the hash table, which contains at most n elements.

For floyd's approach:
Time: O(n)
n = non cyclic
k = cyclic length
O(n+k) ~ O(n)
Space: O(1)
 */

