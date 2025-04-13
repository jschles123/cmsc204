public class TreeNode<T> {

    public TreeNode<T> left;
    public TreeNode<T> right;
    private T data;

    public TreeNode(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public TreeNode(TreeNode<T> copy) {
        this.data = copy.data;
        this.left = copy.left;
        this.right = copy.right;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }
}
