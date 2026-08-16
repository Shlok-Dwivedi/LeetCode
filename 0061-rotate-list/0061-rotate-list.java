/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
class Solution {
    public ListNode rotateRight(ListNode head,int k) {
        if(head==null)
            return head;

        int rotateCount=0;
        int len=1;
        ListNode t=head;

        while(t.next!=null){
            t=t.next;
            len++;
        }

        int j=k%len;

        while(rotateCount<j){
            ListNode newHead=null;
            ListNode p=head;

            if(p.next==null)
                return head;

            while(p.next.next!=null)
                p=p.next;

            newHead=p.next;
            p.next=null;
            newHead.next=head;
            head=newHead;

            rotateCount++;
        }

        return head;
    }
}