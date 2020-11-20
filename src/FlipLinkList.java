import java.util.List;

public class FlipLinkList {
    public static ListNode flipList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode prev = null;
        ListNode cur = node;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode flipDoubleNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode prev = null;
        ListNode cur1 = node;
        ListNode heard = node.next;
        ListNode cur2 = node.next;
        ListNode next;
        while (cur1 != null && cur2 != null) {
            next = cur2.next;
            cur2.next = cur1;
            cur1.next = next;
            if (prev != null) {
                prev.next = cur2;
            }
            prev = cur2;
            cur1 = cur1.next;
            if (cur1 == null || cur1.next == null)
                break;
            else {
                cur2 = cur1.next;
            }
        }
        return null;
    }

    public static ListNode flipDoubleNode2(ListNode head) {
        ListNode node1 = new ListNode(0);
        node1.next = head;
        ListNode temp = node1;
        while (temp.next != null && temp.next.next != null) {
            ListNode cur1 = temp.next;
            ListNode cur2 = temp.next.next;
            cur1.next = cur2.next;
            temp.next = cur2;
            cur2.next = cur1;
            temp = cur1;
        }
        return node1.next;
    }

    public static ListNode flipDoubleNode3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        ListNode next;
        while (cur1 != null && cur2 != null) {
            next = cur2.next;
            cur2.next = cur1;
            cur1.next = next;
            if (prev != null) {
                prev.next = cur2;
            }
            prev = cur1;
            cur1 = next;
            if (cur1 != null) {
                cur2 = cur1.next;
            } else {
                break;
            }
        }
        return newHead;
    }

    public static ListNode Recursion(ListNode head) {
        if (head == null ||head.next == null) {
            return head;
        }
        ListNode newNode = Recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static ListNode Recursion1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newNode = Recursion(head.next);
        newNode.next = head;
        head.next = null;
        return newNode;
    }


    public static void main(String[] args) {
        ListNode prev = ListNode.createListNode();
        ListNode.print(prev);
        System.out.println();
        ListNode node = Recursion(prev);
        ListNode.print(node);


    }

}