package org.autumn.revolution.j2se.demo.datastructure.tree;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by lauandy on 2017-06-22.
 */
public class BinTree {

    private int height;
    private BinNode root;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BinNode getRoot() {
        return root;
    }

    public void setRoot(BinNode root) {
        this.root = root;
    }

    public void createTree(){
        BinNode node41 = new BinNode(8, null, null);
        BinNode node42 = new BinNode(9, null, null);
        BinNode node31 = new BinNode(4, node41, node42);
        BinNode node32 = new BinNode(5, null, null);
        BinNode node21 = new BinNode(2, node31, node32);
        BinNode node33 = new BinNode(6, null, null);
        BinNode node34 = new BinNode(7, null, null);
        BinNode node22 = new BinNode(3, node33, node34);
        this.root = new BinNode(1, node21, node22);
    }

    public void createTree2(){
        BinNode node21 = new BinNode(4, null, null);
        BinNode node22 = new BinNode(5, null, null);
        BinNode node31 = new BinNode(6, null, null);
        BinNode node32 = new BinNode(7, null, null);
        BinNode node2 = new BinNode(2, node21, node22);
        BinNode node3 = new BinNode(3, node31, node32);
        this.root = new BinNode(1, node2, node3);

    }

    public void midOrder(BinNode root){
        if(root.getLeft() != null){
            midOrder(root.getLeft());
        }
        System.out.println(root.getNumber());
        if(root.getRight() != null){
            midOrder(root.getRight());
        }
    }

    public void preOrder(BinNode root){
        System.out.println(root.getNumber());
        if(root.getLeft() != null){
            preOrder(root.getLeft());
        }
        if(root.getRight() != null){
            preOrder(root.getRight());
        }
    }

    public void afterOrder(BinNode root){
        if(root.getLeft() != null){
            afterOrder(root.getLeft());
        }
        if(root.getRight() != null){
            afterOrder(root.getRight());
        }
        System.out.println(root.getNumber());
    }


    /**
     * 层序遍历，广度优先，借助队列实现
     * @param root
     */
    public List<List<Integer>> levelOrder(BinNode root){
        if(root == null){
            return null;
        }
        List<List<Integer>> retList = new ArrayList<>();
        Queue<BinNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                BinNode node = queue.poll();
                levelList.add(node.getNumber());
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
            }
            retList.add(levelList   );
        }
        return retList;
    }

    /**
     * z字形遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagOrder(BinNode root){
        if(root == null){
            return null;
        }
        List<List<Integer>> retList = new ArrayList<>();
        Queue<BinNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int n = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                BinNode node = queue.poll();
                if(level % 2 == 1){
                    levelList.add(node.getNumber());
                }else{
                    levelList.add(0, node.getNumber());
                }
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
            }
            retList.add(levelList);
        }
        return retList;
    }

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.createTree2();
        //tree.midOrder(tree.getRoot());
        //tree.preOrder(tree.getRoot());
        //tree.afterOrder(tree.getRoot());
        System.out.println(JSON.toJSONString(tree.levelOrder(tree.getRoot())));
        System.out.println(JSON.toJSONString(tree.zigzagOrder   (tree.getRoot())));
    }
}
