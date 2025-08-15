/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    int count=0;
    struct ListNode* p=head;
    while(p!=NULL){
        count++;
        p=p->next;
    }
    p=head;
    int pos=0;
    if(count==1){
        free(head);
        return NULL;
    }
    else if (n==count){
        head=head->next;
    }
    else{
        while(pos<count-n-1){
            p=p->next;
            pos++;
        }
        struct ListNode*c=p->next;
        p->next=p->next->next;
        free(c);
    }
    return head;
}