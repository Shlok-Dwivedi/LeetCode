/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseBetween(struct ListNode* head, int left, int right) {
    if (!head || left == right) return head;

    struct ListNode dummy;
    dummy.next = head;
    struct ListNode *prev = &dummy;

    for (int i = 1; i < left; i++) {
        if (!prev) return head;
        prev = prev->next;
    }

    struct ListNode *curr = prev->next;
    struct ListNode *next = NULL;
    struct ListNode *last_unreversed = curr;

    struct ListNode *rev_prev = NULL;
    for (int i = left; i <= right; i++) {
        if (!curr) break;
        next = curr->next;
        curr->next = rev_prev;
        rev_prev = curr;
        curr = next;
    }
    prev->next = rev_prev;
    last_unreversed->next = curr;

    return dummy.next;
}
