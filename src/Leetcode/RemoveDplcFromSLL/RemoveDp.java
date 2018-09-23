package Leetcode.RemoveDplcFromSLL;
/**
 * 删除有序链表中的重复元素*/
public class RemoveDp {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null){
            if (next.val == pre.val){
                next = next.next;
                if (next == null){
                    pre.next = null;
                }
            }else {
                pre.next = next;
                pre = next;
                next = pre.next;
            }
        }
        return head;
    }
}
