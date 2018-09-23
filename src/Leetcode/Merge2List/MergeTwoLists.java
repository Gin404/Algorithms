package Leetcode.Merge2List;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null){
            return l2;
        }else if (l2 == null && l1 != null){
            return l1;
        }else if (l1 == null && l2 == null){
            return null;
        }

        ListNode head = null;
        ListNode temp = null;
        ListNode fix = null;
        ListNode next = null;

        if (l1.val <= l2.val){
            head = l1;
            temp = l1;
            fix = l2;
        }else {
            head = l2;
            temp = l2;
            fix = l1;
        }

        while (true){


            while (temp.next != null && temp.next.val <= fix.val){
                temp = temp.next;
            }
            next = temp.next;
            temp.next = fix;

            if (next == null){
                break;
            }

            temp = fix;
            fix = next;
        }

        return head;
    }
}
