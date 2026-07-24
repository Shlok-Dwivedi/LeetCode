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
    public int pairSum(ListNode head) {
        List<Integer> l=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            l.add(temp.val);
            temp=temp.next;
        }
        int start=0;
        int end=l.size()-1;
        int max_sum=0;
        while(start<end){
            int sum=l.get(start)+l.get(end);
            max_sum=Math.max(max_sum,sum);
            start++;
            end--;
        }
        return max_sum;
    }
}