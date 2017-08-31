package org.autumn.revolution.j2se.demo.datastructure.tree;

/**
 * Created by yangzhichao on 17/6/21.
 */
public class BinaryTreeNode {

    private int number;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int number, BinaryTreeNode left, BinaryTreeNode right) {
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

}
