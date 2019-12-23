package mine.jkchoi.leetcode;

public class TwoSortedListMerger {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Info info = new Info(l1, l2);

        while (true) {
            if (info.invalid()) {
                break;
            }

            if (info.getCurNode1() == null) {
                info.setCurNode2(setFunc(info, info.getCurNode2()));

            } else if (info.getCurNode2() == null) {
                info.setCurNode1(setFunc(info, info.getCurNode1()));

            } else if (info.getCurNode1().val < info.getCurNode2().val) {
                info.setCurNode1(setFunc(info, info.getCurNode1()));

            } else {
                info.setCurNode2(setFunc(info, info.getCurNode2()));
            }
        }

        return info.getHead();
    }

    private ListNode setFunc(Info info, ListNode curNode) {
        if (info.getHead() == null) {
            info.setHead(curNode);
        }

        if (info.getCurResult() == null) {
            info.setCurResult(curNode);
        } else {
            info.getCurResult().next = curNode;
            info.setCurResult(info.getCurResult().next);
        }

        return curNode.next;
    }

    public static class Info {
        private ListNode head = null;
        private ListNode curResult = null;
        private ListNode curNode1;
        private ListNode curNode2;

        public Info(ListNode l1, ListNode l2) {
            this.curNode1 = l1;
            this.curNode2 = l2;
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

        public ListNode getCurNode1() {
            return curNode1;
        }

        public void setCurNode1(ListNode curNode1) {
            this.curNode1 = curNode1;
        }

        public ListNode getCurNode2() {
            return curNode2;
        }

        public void setCurNode2(ListNode curNode2) {
            this.curNode2 = curNode2;
        }

        public boolean invalid() {
            return (curNode1 == null && curNode2 == null);
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




