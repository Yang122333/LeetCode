public class MergeLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public static void merge(ListNode l1, ListNode l2) {
        ListNode heard = new ListNode();
        ListNode cur = heard;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return;
    }

    public static ListNode recursion(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode node = null;
        if(l1.val < l2.val){
            node = new ListNode(l1.val);
            node.next = recursion(l1.next, l2);
        } else {
            node = new ListNode(l2.val);
            node.next = recursion(l1, l2.next);
        }
        return node;
    }

    public static ListNode recursion1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = recursion1(l1.next, l2);
            return l1;
        } else {
            l2.next = recursion1(l1, l2.next);
            return l2;
        }
    }
}
