package leet.simple;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode resList = mergeTwoLists(l1, l2);
        ListNode resList = mergeTwoListsRec(l1,l2);
        while(resList.next != null) {
            System.out.println(resList.val);
            resList = resList.next;
        }
        System.out.println(resList.val);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        time: O(m+n), space: O(1)
        ListNode head = new ListNode(0);
        ListNode current = head;
        int x = 0;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                x = list1.val;
                list1 = list1.next;
            } else {
                x = list2.val;
                list2 = list2.next;
            }
            current.next = new ListNode(x);
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public static ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        // time: O(m+n) , space: O(m+n)
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoListsRec(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRec(list1, list2.next);
            return list2;
        }
    }

}

/*
Recursive:
Time complexity : O(n+m)O(n + m)O(n+m)
Because each recursive call increments the pointer to l1 or l2 by one (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.
Space complexity : O(n+m)O(n + m)O(n+m)
The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n+mn + mn+m stack frames consume O(n+m)O(n + m)O(n+m) space.

Iterative:
Time complexity : O(n+m)O(n + m)O(n+m)
Because exactly one of l1 and l2 is incremented on each loop
iteration, the while loop runs for a number of iterations equal to the
sum of the lengths of the two lists. All other work is constant, so the
overall complexity is linear.
Space complexity : O(1)O(1)O(1)
The iterative approach only allocates a few pointers, so it has a
constant overall memory footprint.
 */

