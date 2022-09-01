package day18;

public class Task3 {
    public static void main(String[] args) {
        Node root = new Node(20);
        addChild(root, 14);
        addChild(root, 11);
        addChild(root, 16);
        addChild(root, 15);
        addChild(root, 18);
        addChild(root, 5);
        addChild(root, 8);
        addChild(root, 23);
        addChild(root, 22);
        addChild(root, 27);
        addChild(root, 24);
        addChild(root, 150);
        dfs(root);
    }
    public static void addChild(Node node, int value) {
        if (value < node.getValue()) {
            if (node.getLeftChild() == null)
                node.setLeftChild(new Node(value));
            else
                addChild(node.getLeftChild(), value);
        } else if (value > node.getValue()) {
            if (node.getRightChild() == null)
                node.setRightChild(new Node(value));
            else
                addChild(node.getRightChild(), value);
        }
    }
    public static void dfs(Node node){
        if (node.getLeftChild() != null) {
            dfs(node.getLeftChild());
            System.out.print(node.getValue() + " ");
        }
        if (node.getRightChild() != null) {
            if (node.getLeftChild() == null)
                System.out.print(node.getValue() + " ");
            dfs(node.getRightChild());
        }
        if (node.getRightChild() == null && node.getLeftChild() == null)
            System.out.print(node.getValue() + " ");
    }
}