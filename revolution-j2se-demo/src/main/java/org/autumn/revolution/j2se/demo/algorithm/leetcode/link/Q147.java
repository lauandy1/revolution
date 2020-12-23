package org.autumn.revolution.j2se.demo.algorithm.leetcode.link;

/**
 * created by yangzhichao on 2019/12/8
 */
public class Q147 {

    public static ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        while(head != null){
            ListNode cur = res;
            ListNode next = head.next;
            while(cur.next != null && cur.next.val < head.val){
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return res.next;
    }


    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }


    public static void main(String[] args) {
        ListNode forth = new Q147.ListNode(1);
        ListNode third = new Q147.ListNode(5);
        third.next = forth;
        ListNode second = new Q147.ListNode(7);
        second.next = third;
        ListNode first = new Q147.ListNode(2);
        first.next = second;

        ListNode res = insertionSortList(first);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
