package competitive.singhankit.leetcode.easy.firstsession;

/**
 * @author _singhankit
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode());
        root.next.val = 2;
        root.next.next = new ListNode(3, new ListNode());
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode(5, null);
        System.out.println(root);
        ListNode node = new ReverseLinkedList().reverseList(root);
        // System.out.println(node);
    }

    //1--2--3--4--5
    //5--4--3--2--1
    public ListNode reverseList(ListNode head) {
        ListNode reverse=new ListNode();
        reverse.val=head.next.next.next.next.val;
       reverse.next=head.next.next.next.next.next;
        reverse.next=head.next.next.next;
      reverse.next.next=head.next.next;
      reverse.next=head.next;
        System.out.println(reverse);
        return null;
    }

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

        @Override
        public String toString() {
            return "ListNode{" +
                           "val=" + val +
                           ", next=" + next +
                           '}';
        }
    }


}
