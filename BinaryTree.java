package mytreeproject;

import java.util.*;

class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    
    public void insert(T data) {
        root = insertRec(root, data);
    }
    
    private TreeNode<T> insertRec(TreeNode<T> root, T data) {
        if (root == null) return new TreeNode<>(data);
        if (data.compareTo(root.data) < 0) root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0) root.right = insertRec(root.right, data);
        return root;
    }
    
    public boolean search(T data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(TreeNode<T> root, T data) {
        if (root == null) return false;
        if (data.compareTo(root.data) == 0) return true;
        return data.compareTo(root.data) < 0 ? searchRec(root.left, data) : searchRec(root.right, data);
    }
    
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }
    
    private void inOrderRec(TreeNode<T> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
    
    public void delete(T data) {
        root = deleteRec(root, data);
    }
    
    private TreeNode<T> deleteRec(TreeNode<T> root, T data) {
        if (root == null) return null;
        if (data.compareTo(root.data) < 0) root.left = deleteRec(root.left, data);
        else if (data.compareTo(root.data) > 0) root.right = deleteRec(root.right, data);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }
    
    private T findMin(TreeNode<T> root) {
        T min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    
    public int countNodes() {
        return countNodesRec(root);
    }
    
    private int countNodesRec(TreeNode<T> root) {
        return root == null ? 0 : 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
    
    public int height() {
        return heightRec(root);
    }
    
    private int heightRec(TreeNode<T> root) {
        return root == null ? 0 : 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }
}
