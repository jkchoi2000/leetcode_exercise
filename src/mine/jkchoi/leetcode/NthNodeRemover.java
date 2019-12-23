package mine.jkchoi.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class NthNodeRemover {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        int curPos = 1;
        ListNode curNode = head;
        ListNode preRemovingNode = null;
        ListNode removingNode = (n == 1) ? head : null;

        while (curNode.next != null) {
            curNode = curNode.next;
            ++curPos;

            if (curPos == n) {
                removingNode = head;
            } else if (curPos > n) {
                preRemovingNode = removingNode;
                removingNode = removingNode.next;
            }
        }

        if (removingNode != null) {
            if (preRemovingNode == null) {
                if (removingNode == head) {
                    head = removingNode.next;
                }
            } else {
                preRemovingNode.next = removingNode.next;
            }
        }

        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
