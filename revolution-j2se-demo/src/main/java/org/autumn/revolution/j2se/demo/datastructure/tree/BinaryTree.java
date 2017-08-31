package org.autumn.revolution.j2se.demo.datastructure.tree;

import java.util.Random;

/**
 * Created by yangzhichao on 17/6/21.
 */
public class BinaryTree {

    private BinaryTreeNode root;

    private int height; //树的深度，根节点为1，往下递增

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public BinaryTree createBinaryTree(int height){
//        // num为height时，是叶子节点，从最底层开始构建
//        for(int num = height; num > 0; num--){
//            // 深度为num时,节点总数量，如果是满二叉树，总数量为2的num-1次方
//            int total = 2 << num - 2;
//            // 如果当前深度为height,将数量设置为total内的随机数
//            if(num == height){
//                Random random = new Random();
//                total = random.nextInt(height);
//                if(total == 0){
//                    total = 1;
//                }
//            }
//            for(int i = 0; i < total; i++){
//
//
//            }
//
//
//        }
        return null;
    }

    public BinaryTree createBinaryTree(int height, BinaryTreeNode left, BinaryTreeNode right){
        return null;
    }

    public static BinaryTreeNode createBinaryTree(BinaryTreeNode root){
        return null;
    }

    public void createBinaryTree(){
        BinaryTreeNode left31 = new BinaryTreeNode(31, null, null);
        BinaryTreeNode right32 = new BinaryTreeNode(32, null, null);
        BinaryTreeNode left21 = new BinaryTreeNode(21, left31, right32);

        BinaryTreeNode left33 = new BinaryTreeNode(33, null, null);
        BinaryTreeNode right34 = new BinaryTreeNode(34, null, null);
        BinaryTreeNode right22 = new BinaryTreeNode(22, left33, right34);

        this.root = new BinaryTreeNode(11, left21, right22);
    }

    public void preOrder(BinaryTreeNode root){
        BinaryTreeNode left = root.getLeft();
        if(left != null){
            preOrder(left);
        }
        System.out.println(root.getNumber());
        BinaryTreeNode right = root.getRight();
        if(right != null){
            preOrder(right);
        }
    }

    public void midOrder(BinaryTreeNode root){
        System.out.println(root.getNumber());
        BinaryTreeNode left = root.getLeft();
        if(left != null){
            preOrder(left);
        }
        BinaryTreeNode right = root.getRight();
        if(right != null){
            preOrder(right);
        }
    }



    public static void main(String[] args) {
        //int total = 2 << 2;
        //System.out.println(total);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        //binaryTree.preOrder(binaryTree.getRoot());
        binaryTree.midOrder(binaryTree.getRoot());
    }
}
