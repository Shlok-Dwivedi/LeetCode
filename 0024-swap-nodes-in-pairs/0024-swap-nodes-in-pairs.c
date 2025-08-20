/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head==NULL||head->next==NULL){
        return head;
    }
    struct ListNode *new_head = head->next;
    struct ListNode *prev_tail = head;

    struct ListNode *temp = head->next->next;
    new_head->next = head;
    head->next = temp;

    while (prev_tail->next != NULL && prev_tail->next->next != NULL) {
        struct ListNode *node1 = prev_tail->next;
        struct ListNode *node2 = node1->next;

        node1->next = node2->next;
        node2->next = node1;
        prev_tail->next = node2;
        
        prev_tail = node1;
    }
    
    return new_head;
}