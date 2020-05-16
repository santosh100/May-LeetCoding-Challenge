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
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode headOdd = head;
        ListNode tailOdd = head;
        ListNode headEven = head.next;
        ListNode tailEven = head.next;
        int i=3;
        ListNode temp = head.next.next;
        while(temp != null){
            if(i%2==1){                
                tailOdd.next = temp;                            
                tailOdd = temp;                
            }else{                                
                tailEven.next = temp;                       
                tailEven = temp; 
            }
            i++;                
            temp = temp.next;
        }
        
        tailEven.next = null;        
        tailOdd.next = headEven;
        return headOdd;
    }
}