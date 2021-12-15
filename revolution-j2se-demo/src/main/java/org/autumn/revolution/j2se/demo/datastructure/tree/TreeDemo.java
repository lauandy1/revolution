package org.autumn.revolution.j2se.demo.datastructure.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/15
 */
public class TreeDemo {

    static class BinNode{
        int val;
        BinNode left;
        BinNode right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public BinNode getLeft() {
            return left;
        }

        public void setLeft(BinNode left) {
            this.left = left;
        }

        public BinNode getRight() {
            return right;
        }

        public void setRight(BinNode right) {
            this.right = right;
        }

        BinNode(int val, BinNode left, BinNode right){
            this.val = val;
            this.left = left;
            this.right = right;


        }
    }

    public static List<List<Integer>> levelTrace(BinNode root){
        if(root == null){
            return null;
        }
        List<List<Integer>> retList = new ArrayList<>();
        // 定义队列
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(root);
        // 两层循环，外层控制树的层数，内层控制同层节点遍历
        // 每遍历一层，先将结果集添加至list；此外，将每个节点的左子节点和右子节点添加至队列中
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            retList.add(list);
            int size = queue.size();
            for(int i = 0; i < size; i++){
                BinNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return retList;
    }

    public static List<List<Integer>> zigzagTrace(BinNode root){
        if(root == null){
            return null;
        }
        List<List<Integer>> retList = new ArrayList<>();
        // 定义队列
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(root);
        // 两层循环，外层控制树的层数，内层控制同层节点遍历
        // 每遍历一层，先将结果集添加至list；此外，将每个节点的左子节点和右子节点添加至队列中
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            List<Integer> list = new ArrayList<>();
            retList.add(list);
            int size = queue.size();
            for(int i = 0; i < size; i++){
                BinNode node = queue.poll();
                // 判断是奇数层还是偶数层，等于0偶数层
                if(level % 2 == 0){
                    list.add(0, node.val);
                }else{
                    list.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        // 构建三层节点树
        BinNode node31 = new BinNode(4, null, null);
        BinNode node32 = new BinNode(5, null, null);
        BinNode node33 = new BinNode(6, null, null);
        BinNode node34 = new BinNode(7, null, null);
        BinNode node21 = new BinNode(2, node31, node32);
        BinNode node22 = new BinNode(3, node33, node34);
        BinNode root = new BinNode(1, node21, node22);
        //System.out.println(JSON.toJSONString(root));
        System.out.println(JSON.toJSONString(levelTrace(root)));
        System.out.println(JSON.toJSONString(zigzagTrace(root)));
    }

}
