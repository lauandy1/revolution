package org.autumn.revolution.j2se.demo.datastructure.tree;

/**
 * Created by lauandy on 2017-06-22.
 */
public class BinNode {

    private int number;
    private BinNode left;
    private BinNode right;

    public BinNode(int number, BinNode left, BinNode right) {
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
}
