package mine.jkchoi.leetcode;

import java.util.Stack;

/**
 * 25. Reverse Nodes in k-Group
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class KGroupNodesReverser {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        ListNode result = head;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        ListNode nextPartStartNode = head.next;
        ListNode curPartNode = head;
        ListNode curPartEndNode = head;


        final Stack<ListNode> partNodeStack = new Stack<>();

        int partCount = 1;
        while (true) {
            if (curNode == null) {
                curPartEndNode.next = nextPartStartNode;
                break;
            }

            nextNode = curNode.next;

            if (partCount < k) {
                partNodeStack.push(curNode);

            } else if (partCount == k) {
                if (result == head) {
                    result = curNode;
                }

                if (curPartEndNode != null) {
                    curPartEndNode.next = curNode;
                }

                curPartNode = curNode;

                while (!partNodeStack.isEmpty()) {
                    curPartNode.next = partNodeStack.pop();
                    curPartNode = curPartNode.next;
                }

                curPartEndNode = curPartNode;
                nextPartStartNode = nextNode;
                partCount = 0;
            }


            ++partCount;
            curNode = nextNode;
        }

        return result;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
