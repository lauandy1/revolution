package org.autumn.revolution.j2se.demo.algorithm.linkedlist;

import java.util.Random;

/**
 * Created by yangzhichao on 15/10/14.
 */
public class LinkedListRevert {
    class Node{
        int value;
        Node next;
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public int getValue(){
            return value;
        }

        public boolean hasNext(){
            if(getNext()!=null){
                return true;
            }
            return false;
        }

    }

    /**
     * 随机创建一个长度为n的单向链表
     * @return
     */
    public Node createLinkedList(int n){
        Random random = new Random();
        Node head = new Node(random.nextInt(100),null);
        for(int i=0;i<n;i++){
            int value = random.nextInt(100);
            //System.out.println(value);
            head = new Node(value,head);
        }
        return head;
    }

    /**
     * 循环实现反转链表
     * @param head
     */
    public Node revertLinkedList(Node head){
        Node result = new Node(head.getValue(),null);
        while(head.hasNext()){
            Node next = head.getNext();
            Node next2 = next.getNext();
            next.setNext(head);
            result.setNext(next);
            head = next2;
        }
        return result;
    }

    /**
     * 递归实现反转链表
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        Node reversedHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reversedHead;
    }

    public static void printLinkedList(Node node){
        while(node.hasNext()){
            System.out.print(node.getValue());
            System.out.print(",");
            node = node.getNext();
        }
        System.out.println();

    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     *
     */
    public static Node reverse2(Node head) {
        if (null == head) {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        Node next;
        while (null != cur) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        //将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
        head.setNext(null);
        head = pre;

        return head;
    }


    public static void main(String[] args) {

        LinkedListRevert linkedListRevert = new LinkedListRevert();

        Node node = linkedListRevert.createLinkedList(7);

        printLinkedList(node);

        Node revert = reverse2(node);
        printLinkedList(revert);

    }
}
