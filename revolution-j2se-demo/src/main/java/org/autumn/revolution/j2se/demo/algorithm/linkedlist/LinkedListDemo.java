package org.autumn.revolution.j2se.demo.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/11/28
 */
public class LinkedListDemo {

    static class Node {
        int data;
        Node next;
        Node(){

        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public Node initDesc(int n){
        Random random = new Random();
        Node head = new Node();
        head.data = n--;
        Node pre = head;
        while (n > 0){
            Node next = new Node();
            next.data = random.nextInt(10);
            pre.next = next;
            pre = next;
            n--;
        }
        return head;
    }


    public Node reverse(Node head){
        // cur指向下个节点
        Node cur = head.next == null ? null : head.next;
        if(cur == null){
            return head;
        }
        Node pre = head;
        head.next = null;
        while (cur != null){
            // 暂存cur的下个节点
            Node next = cur.next;
            // 指向反转，将cur指向pre
            cur.next = pre;
            //将pre移动到cur
            pre = cur;
            // 将cur移动到next
            cur = next;
        }
        return pre;
    }

    public Node initAsc(int n){
        Random random = new Random();
        Node after = new Node();
        int i = 0;
        after.data = i;
        Node head = after;
        while (i < n){
            i++;
            Node cur = new Node();
            cur.data = random.nextInt(10);
            cur.next = after;
            after = cur;
            head.next = cur;
        }
        return head;
    }

    public void print(Node head){
        while (head != null){
            System.out.print(head.data);
            head = head.next;
            if(head != null){
                System.out.print(",");
            }
        }
    }

    /**
     * 判断是否有环，时间复杂度空间复杂度都是O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(Node head){
        Set<Node> set = new HashSet<>();
        while (head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针法，相遇即为有环
     * @return
     */
    public boolean hasCycle2(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            // slow前进一步
            slow = slow.next;
            // fast前进2步
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 归并排序
     * @param
     * @param
     * @return
     */
    public Node merge(Node cur1, Node cur2){
        Node res = new Node();
        Node cur = res;
        while (cur1 != null && cur2 != null){
            // 比较 并 插入
            if(cur1.data <= cur2.data){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 != null ? cur1 : cur2;
        return res.next;
    }

    /**
     * 归并排序，数组
     * @param array1
     * @param array2
     * @return
     */
    public static int[] merge(int[] array1, int[] array2){
        if(array1 == null && array2 == null){
            return null;
        }
        if(array1 == null && array2 != null){
            return array2;
        }
        if(array2 == null && array1 != null){
            return array1;
        }
        int length1 = array1.length;
        int length2 = array2.length;
        int[] resArray = new int[length1 + length2];
        int i = 0, j = 0;
        while (i < length1 && j < length2){
            if(array1[i] <= array2[j]){
                resArray[i + j] = array1[i];
                i++;
            }else{
                resArray[j + i] = array2[j];
                j++;
            }
        }
        // 剩余数组拷贝到新数组
        if(i == length1){
            System.arraycopy(array2, j, resArray, i + j, length2 - j);
        }else if(j == length2){
            System.arraycopy(array1, i, resArray, i + j, length1 - i);
        }
        return resArray;
    }

    public static void main(String[] args) {

//        int[] array1 = new int[]{1,2,3,4};
//        int[] array2 = new int[]{4,5,6};
//        int[] resArray = merge(array1, array2);
//        for(int i : resArray){
//            System.out.println(i);
//        }

         LinkedListDemo linkedListDemo = new LinkedListDemo();
//         Node head1 =  linkedListDemo.initDesc(5);
//         Node head2 =  linkedListDemo.initDesc(5);
//         linkedListDemo.print(head1);
//         linkedListDemo.print(head2);

         Node head1 = new Node();
         head1.data = -9;
         Node h12 = new Node();
         h12.data = 3;
//         Node h13 = new Node();
//         h13.data = 5;
         //h12.next = h13;
         head1.next = h12;
         //linkedListDemo.print(head1);

         Node head2 = new Node();
         head2.data = 5;
         Node h22 = new Node();
         h22.data = 7;
//         Node h23 = new Node();
//         h23.data = 6;
//         h22.next = h23;
         head2.next = h22;
         //linkedListDemo.print(head2);

         Node res = linkedListDemo.merge(head1, head2);
        //System.out.println(JSON.toJSONString(res));
         linkedListDemo.print(res);


//        LinkedListDemo linkedListDemo = new LinkedListDemo();
//        Node head = linkedListDemo.initDesc(5);
//        Node headAsc = linkedListDemo.initAsc(5);
//        //linkedListDemo.print(head);
//        linkedListDemo.print(headAsc);

//        System.out.println();
//        Node reverse = linkedListDemo.reverse(head);
//        linkedListDemo.print(reverse);

    }
}
