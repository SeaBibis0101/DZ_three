package mytreeproject;

class TreeNode<T extends Comparable<T>> {
    T data;
    TreeNode<T> left, right;
    
    TreeNode(T data) {
        this.data = data;
        left = right = null;
    }
}
