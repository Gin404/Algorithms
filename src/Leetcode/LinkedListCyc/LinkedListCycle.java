package Leetcode.LinkedListCyc;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        int size = set.size();
        while (head != null){
            set.add(head.hashCode());
            if (size != set.size()){
                size = set.size();
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleQk(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
