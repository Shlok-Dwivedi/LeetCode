/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};
        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int pos = 1;
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;
        int max = -1;
        while (curr.next != null) {

            int prevVal = prev.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;

            // Check if current node is a critical point
            if ((currVal > prevVal && currVal > nextVal) ||
                (currVal < prevVal && currVal < nextVal)) {
                // First critical point
                if (first == -1) {
                    first = pos;
                }
                // We already have a previous critical point
                if (last != -1) {
                    min = Math.min(min, pos - last);
                    max = pos - first;
                }
                last = pos;
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }
        if (first == -1 || first == last) {
            return ans;
        }
        return new int[]{min, max};
    }
}