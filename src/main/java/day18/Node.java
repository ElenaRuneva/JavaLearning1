package day18;

import java.util.List;

public class Node {
    private Node leftChild = null;
    private Node rightChild = null;
    private int value;

    public Node(int value){
        this.value = value;
    }

    public void setLeftChild(Node node) {
        this.leftChild = node;
    }
    public void setRightChild(Node node) {
        this.rightChild = node;
    }
    public Node getRightChild() {
        return this.rightChild;
    }
    public Node getLeftChild(){
        return this.leftChild;
    }
    public int getValue(){
        return this.value;
    }

}
