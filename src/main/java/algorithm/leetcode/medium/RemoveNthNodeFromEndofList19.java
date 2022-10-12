package algorithm.leetcode.medium;

public class RemoveNthNodeFromEndofList19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        int i = 0;
        for (; first!=null && i < n; i++) first=first.next;
        if(first==null && i<n){
            return null;
        }
        ListNode p = head;
        while (first!=null){
            p=p.next;
            first=first.next;
        }
        ListNode d = p.next;
        p.next=d.next;
        d.next=null;

        return head;
    }

    private class ListNode{
        public ListNode next;
    }
}
