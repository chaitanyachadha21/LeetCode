/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        boolean iscycle = false;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                iscycle = true;
            }

            if(iscycle == true)
            {
                slow = head;

                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}