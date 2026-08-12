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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode current = head;
        ListNode prevGroupEnd = null;

        int groupSize = 1;

        while (current != null) {

            ListNode groupStart = current;
            int count = 0;

            ListNode temp = current;

            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {

                ListNode prev = temp;
                ListNode node = groupStart;

                for (int i = 0; i < count; i++) {
                    ListNode nextNode = node.next;
                    node.next = prev;
                    prev = node;
                    node = nextNode;
                }

                if (prevGroupEnd != null) {
                    prevGroupEnd.next = prev;
                } else {
                    head = prev;
                }

                prevGroupEnd = groupStart;
                current = temp;

            } else {

                for (int i = 0; i < count; i++) {
                    prevGroupEnd = current;
                    current = current.next;
                }

            }

            groupSize++;
        }

        return head;
    }
}