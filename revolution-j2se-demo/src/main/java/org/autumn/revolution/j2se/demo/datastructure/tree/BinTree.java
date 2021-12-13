package org.autumn.revolution.j2se.demo.datastructure.tree;

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

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.createTree();
        //tree.midOrder(tree.getRoot());
        //tree.preOrder(tree.getRoot());
        tree.afterOrder(tree.getRoot());
    }
}
