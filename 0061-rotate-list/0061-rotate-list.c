/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if(head==NULL){
        return head;
    }
    int rotate_count=0;
    int len=1;
    struct ListNode *t=head;
    while(t->next!=NULL){
        t=t->next;
        len++;
    }
    int j=k%len;
    while(rotate_count<j){
        struct ListNode *new_head=NULL, *p=head;
        if(p->next==NULL){
            return head;
        }
        while(p->next->next!=NULL){
            p=p->next;
        }
            new_head=p->next;
            p->next=NULL;
            new_head->next=head;
            head=new_head;
            rotate_count++;
    }
    return head;
}