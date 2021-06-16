package competitive.singhankit.leetcode.easy;

/**
 * @author _singhankit
 */
public class SwapNodesUsingRecursion {
    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode());
        root.next.val = 2;
        root.next.next = new ListNode(3, new ListNode());
        root.next.next.next.val = 4;
        System.out.println(new SwapNodesUsingRecursion().swapPairs(root));
    }

    public ListNode swapPairs(ListNode head) {
        if (head.next == null)
            return head;
        int val = head.val;
        head.val = head.next.val;
        head.next.val = val;
        if (head.next.next == null)
            return head;
        head.next.next = swapPairs(head.next.next);
        return head;
    }


}

class ListNode {
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
