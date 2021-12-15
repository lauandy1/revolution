package org.autumn.revolution.j2se.demo.algorithm.linkedlist;

import com.alibaba.fastjson.JSON;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/15
 */
public class LinkedListDemo2 {

    static class Node{
        int val;
        Node next;
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static Node reverse2(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node reverse3(Node head){
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static Node reverse(Node head){
        Node pre = null;
        while (head != null){
            // 先记录下next节点，因为反转后会找不到
            Node next = head.next;
            // head的next指针干掉
            head.next = pre;
            // 给pre赋值
            pre = head;
            // head后移
            head = next;
        }
        return pre;
    }

    public boolean hasCycle(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static Node merge(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1 == null && head2 == null){
            return null;
        }
        Node retNode = new Node(0, null);
        Node cur = retNode;
        while (head1 != null && head2 != null){
            if(head1.val > head2.val){
                cur.next = head2;
                head2 = head2.next;

            }else{
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head1 != null ? head1 : head2;
        return retNode.next;
    }

    public static void main(String[] args) {
        Node node3 = new Node(1, null);
        Node node2 = new Node(2, node3);
        Node head = new Node(3, node2);
        System.out.println(JSON.toJSONString(head));

        Node node6 = new Node(4, null);
        Node node5 = new Node(5, node6);
        Node head2 = new Node(6, node5);

        Node node = merge(head, head2);
        System.out.println(JSON.toJSONString(merge(head, head2)));
        //reverse(head);

       // System.out.println(JSON.toJSONString(reverse3(head)));
    }
}
