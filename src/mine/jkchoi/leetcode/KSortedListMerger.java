package mine.jkchoi.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 23. Merge k Sorted Lists (Hard)
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class KSortedListMerger {
    public ListNode mergeKLists(ListNode[] lists) {
        final Info info = new Info(lists);

        while (true) {
            if (info.invalid()) {
                break;
            }

            final int nodeIndex = info.getMinCurNodeIndex();
            final ListNode node = info.getCurNode(nodeIndex);

            info.setCurNode(nodeIndex, info.setProperties(node));
        }

        return info.getHead();
    }

    public static class Info {
        private ListNode head = null;
        private ListNode curResult = null;
        private List<ListNode> curNodes;

        public Info(ListNode[] lists) {
            curNodes = Arrays.asList(lists);
        }

        public ListNode getHead() {
            return head;
        }

        public void setHead(ListNode head) {
            this.head = head;
        }

        public ListNode getCurResult() {
            return curResult;
        }

        public void setCurResult(ListNode curResult) {
            this.curResult = curResult;
        }

        public boolean invalid() {
            return this.curNodes.stream().allMatch(Objects::isNull);
        }

        public int getMinCurNodeIndex() {
            int minValue = Integer.MAX_VALUE;
            int minNodeIndex = -1;
            final int size = this.curNodes.size();
            for (int i = 0; i < size; i++) {
                final ListNode node = this.curNodes.get(i);
                if (node != null && (minValue > node.val)) {
                    minValue = node.val;
                    minNodeIndex = i;
                }
            }

            return minNodeIndex;
        }

        private ListNode setProperties(ListNode curNode) {
            if (head == null) {
                head = curNode;
            }

            if (curResult == null) {
                curResult = curNode;
            } else {
                curResult.next = curNode;
                curResult = curResult.next;
            }

            return curNode.next;
        }

        public ListNode getCurNode(int nodeIndex) {
            return this.curNodes.get(nodeIndex);
        }

        public void setCurNode(int nodeIndex, ListNode node) {
            this.curNodes.set(nodeIndex, node);
        }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
