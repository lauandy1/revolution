package org.autumn.revolution.j2se.demo.algorithm.leetcode.link;

/**
 * created by yangzhichao on 2019/12/8
 */
public class Regular {

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;

    }

    /**
     * 比上面的又省去了一个引用
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }


    /**
     * 方法3，旧链表迭代到新链表
     * 图解法整理思路
     * 1->2->3 变为 3->2->1
     * loop1 1->null 2->3
     * loop2 2->1->null 3
     * loop3 3->2->1->null
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head){
        ListNode newHead = null;
        while (head != null){
            // 记录下头指针断开后，剩下那段（2->3）
            ListNode tmp = head.next;
            // 改变头指针next指向，实现反转 (1->null)
            head.next = newHead;
            // 改变newHead指向 (newHead指向1)
            newHead = head;
            // 改变head指向作为下轮迭代输入
            head = tmp;
        }
        return newHead;
    }

    static class ListNode {

        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
        }

    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val);
            System.out.print(",");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;
        print(first);

        ListNode res = reverseList3(first);
        print(res);
       // print(first);

    }
}
