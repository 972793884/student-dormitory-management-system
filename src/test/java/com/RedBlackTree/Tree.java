package com.RedBlackTree;

public class Tree<T extends Comparable> {
    private Node rootNode;
    private static final boolean RED=false;
    private static final boolean BLACK=true;

     public class Node<T extends Comparable<T>>{
        boolean color;
        T key;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(boolean color, T key, Node<T> left, Node<T> right, Node<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
         public boolean leftRotate(Node<T> x){
             Node<T> y=x.left;
             x.right=y.left;
             if (y.left!=null){
                 y.left.parent=x;
             }
             y.parent=x.parent;
             if (y.parent==null){
                 rootNode=y;
             }else {
                 if (x.parent.left==x){
                     x.parent.left=y;
                 }else {
                     x.parent.right=y;
                 }
             }
             y.left=x;
             x.parent=y;
             return true;
         }
    }

}
