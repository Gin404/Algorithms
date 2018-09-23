package Leetcode.Merge2List;

public class Add2Nums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int comp = 0;
        ListNode res = new ListNode(0);
        ListNode result = res;
        int l1num = 0;
        int l2num = 0;
        while (true){
            if (l1 != null) {
                l1num = l1.val;
            }

            if (l2 != null){
                l2num = l2.val;
            }


            res.val = (l1num + l2num + comp)%10;
            comp = (l1num + l2num + comp)/10;



            if (l1 != null && l1.next != null){
                l1 = l1.next;
            }else {
                l1 = null;
                l1num = 0;
            }

            if (l2!= null && l2.next != null){
                l2 = l2.next;
            }else {
                l2 = null;
                l2num = 0;
            }

            if (l1 == null && l2 == null){
                if (comp != 0){
                    res.next = new ListNode(comp);
                }
                break;
            }

            if (l1 != null || l2 != null) {
                res.next = new ListNode(0);
                res = res.next;
            }


        }

        return result;
    }
}
