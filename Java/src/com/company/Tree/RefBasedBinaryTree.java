package com.company.Tree;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
//public class RefBasedBinaryTree implements BinaryTree {
//    protected TreeNode root;
//    private int size;
//
//    public RefBasedBinaryTree() {
//        this.size = 0;
//
//    }
//
//    public void insert(Integer value){
//        this.size++;
//        insert(null, root, value);
//    }
//
//    /*
//     * Purpose: recursively determines the shortest path (root to leaf)
//     *      inserts a new TreeNode with given value at that leaf
//     * Parameters: TreeNode parent - the parent to t
//     *             TreeNode t - the current TreeNode in recursive traversal
//     *             Integer value - the value to be inserted
//     * Returns: nothing
//     */
//    private void insert(TreeNode parent, TreeNode t, Integer value) {
//        if (t==null) {
//            if(parent == null)
//                root = new TreeNode(value);
//            else if(parent.getLeft()==null)
//                parent.setLeft(new TreeNode(value));
//            else
//                parent.setRight(new TreeNode(value));
//
//        }  else {
//            int htLeft = height(t.getLeft());
//            int htRight = height(t.getRight());
//            if (htLeft>htRight)
//                insert(t, t.getRight(), value);
//            else
//                insert(t, t.getLeft(), value);
//        }
//    }
//
//    /*
//     * Purpose: computes and returns the height of BinaryTree t
//     *      NOTE a BinaryTree with no node is height 0
//     * Parameters: TreeNode t - the BinaryTree
//     * Returns: int - the height
//     */
//    private int height(TreeNode t) {
//        int res = 0;
//        if(t != null){
//            int leftheight = height(t.left);
//            int rightheight = height(t.right);
//            if(leftheight >= rightheight){
//                res = leftheight+1;
//            }else{
//                res = rightheight+1;
//            }
//        }
//        return res;
//    }
//
//
//    public void inOrder(){
//        List<TreeNode> res = new ArrayList<>();
//        inOrder(res, root);
//        for(TreeNode i : res){
//            System.out.println(i.data);
//        }
//    }
//
//    private void inOrder(List<TreeNode> res, TreeNode root){
//        if(root != null){
//            inOrder(res, root.left);
//            res.add(root);
//            inOrder(res, root.right);
//        }
//        return;
//    }
//
//
//
//    public void preOrder(){
//        List<TreeNode> res = new ArrayList<>();
//        preOrder(res, root);
//        for(TreeNode i : res){
//            System.out.println(i.data);
//        }
//    }
//
//    private void preOrder(List<TreeNode> res, TreeNode root){
//        if(root != null){
//            res.add(root);
//            preOrder(res, root.left);
//            preOrder(res, root.right);
//        }
//        return;
//    }
//
//
//    public void postOrder(){
//        List<TreeNode> res = new ArrayList<>();
//        postOrder(res, root);
//        for(TreeNode i : res){
//            System.out.println(i.data);
//        }
//    }
//
//    private void postOrder(List<TreeNode> res, TreeNode root){
//        if(root != null){
//            postOrder(res, root.left);
//            postOrder(res, root.right);
//            res.add(root);
//
//        }
//        return;
//    }
//
//
//
//    public String toString() {
//        String s = "";
//
//        return "";
//    }
//
//
//    // provided for testing of RefBasedBinaryTree class
//    public static void main(String[] args) {
//
//        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
//        for(int i=2; i<8; i++) {
//            myTree.insert(i);
//        }
//        System.out.println("in");
//        myTree.inOrder();
//        System.out.println("pre");
//        myTree.preOrder();
//        System.out.println("post");
//        myTree.postOrder();
////
//        System.out.println("toString\n" + myTree);
//    }
    
//}
