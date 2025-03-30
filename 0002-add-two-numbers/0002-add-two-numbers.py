class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # Initialize the result linked list and carry
        dummy_head = ListNode(0)
        current = dummy_head
        carry = 0
        
        # Traverse both linked lists
        while l1 or l2 or carry:
            # Get values from l1 and l2, default to 0 if node is None
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            # Calculate sum and carry
            total = val1 + val2 + carry
            carry = total // 10
            sum_digit = total % 10
            
            # Create new node with sum_digit
            current.next = ListNode(sum_digit)
            current = current.next
            
            # Move to the next nodes in l1 and l2
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        
        return dummy_head.next

# Example usage
solution = Solution()
l1 = ListNode(2, ListNode(4, ListNode(3)))  # Represents 342
l2 = ListNode(5, ListNode(6, ListNode(4)))  # Represents 465
result = solution.addTwoNumbers(l1, l2)