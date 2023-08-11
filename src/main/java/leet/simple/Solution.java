package leet.simple;


public class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        mergeTwoLists(list1, list2);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(0,null);
        while(list1.next.next != null || list2.next.next != null) {
            if(list1 != null && list1.val > list2.val) {
                list3.val = list1.val;
                list1 = list1.next;
                list3 = list3.next;
            } else {
                if(list2 != null) {
                    list3.val = list2.val;
                    list2 = list2.next;
                }
                list3 = list3.next;
            }
        }
        return list3;
    }
}
