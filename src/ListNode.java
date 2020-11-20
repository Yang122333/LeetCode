public class ListNode {
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

        public static ListNode createListNode(){
            ListNode a = new ListNode(1);
            ListNode b = new ListNode(2);
            a.next = b;
            ListNode c = new ListNode(3);
            b.next = c;
            ListNode d = new ListNode(4);
            c.next = d;
            ListNode e = new ListNode(5);
            d.next = e;
            return a;
        }

        public static void print(ListNode node){
            while (node!= null){
                System.out.print(node.val+" ");
                node = node.next;
            }
        }
    }