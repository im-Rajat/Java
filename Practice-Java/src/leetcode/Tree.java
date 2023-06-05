package leetcode;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Tree {
    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n1 = new TreeNode(10, n2, n3);
//        n1.left = n2;
//        n1.right = n3;

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(13);

        n3.left = n6;
        n3.right = n7;

        inorder(n1);

    }

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}