package org.autumn.revolution.j2se.demo.algorithm.leetcode.link;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2020/12/23
 */
public class CycleDetect {

    /**
     * 检测链表中环的节点位置
     * @param head
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 方法2
     * 双指针相遇法
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        return null;
    }


    public static void main(String[] args) {

    }
}
