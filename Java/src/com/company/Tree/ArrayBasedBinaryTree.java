package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class ArrayBasedBinaryTree {
    private static final int CAPACITY = 100;
    protected Integer[] data;
    protected int root;
    protected int size;

    public ArrayBasedBinaryTree() {
        this.data = new Integer[CAPACITY];
        this.root = 1;
        this.size = 0;
    }

    public void insert(Integer value) {
        this.size++;
        this.data[this.size] = value;

    }


    /*
     * Purpose: calculates and returns the index of t's left child
     * Parameters: int t - index of current element in this ArrayBasedBinaryTree
     * Returns: int - index of left child
     */
    protected int getLeft(int t) {
        return 2*t;
    }

    /*
     * Purpose: calculates and returns the index of t's right child
     * Parameters: int t - index of current element in this ArrayBasedBinaryTree
     * Returns: int - index of right child
     */
    protected int getRight(int t) {
        return 2*t+1;
    }


    public void inOrder(){
        List<Integer> res = new ArrayList<>();
        inOrder(res, this.root);
        for(Integer i : res){
            System.out.println(i);
        }
    }

    private void inOrder(List<Integer> res, int rootIdx){
        if(this.data[rootIdx] != null){
            inOrder(res, getLeft(rootIdx));
            res.add(this.data[rootIdx]);
            inOrder(res, getRight(rootIdx));
        }
    }


    public void preOrder(){
        List<Integer> res = new ArrayList<>();
        preOrder(res, this.root);
        for(Integer i : res){
            System.out.println(i);
        }
    }

    private void preOrder(List<Integer> res, int root_idx){
        if(this.data[root_idx] != null){
            res.add(this.data[root_idx]);
            preOrder(res, getLeft(root_idx));
            preOrder(res, getRight(root_idx));
        }
    }


    public void postOrder(){
        // TODO...
        List<Integer> res = new ArrayList<>();
        postOrder(res, this.root);
        for(Integer i : res){
            System.out.println(i);
        }
    }

    private void postOrder(List<Integer> res, int root_idx){
        if(this.data[root_idx] != null){
            postOrder(res, getLeft(root_idx));
            postOrder(res, getRight(root_idx));
            res.add(this.data[root_idx]);

        }
    }

    public String toString() {
        String s = "";
        for(int i = this.root; i < this.size; i++){
            s += this.data[i];
        }
        return s;
    }



    public static void main(String[] args) {

        ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println("in");
        myTree.inOrder();
        /*
                2
              /   \
             3     4
            / \    /
           5   6  7
         */
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();

        System.out.println("toString\n" + myTree);
    }

}
