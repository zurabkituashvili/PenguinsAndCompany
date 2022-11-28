package pgdp.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T>{

    private List<Node<T>> children;
    private Node<T> parent;
    private T data;
    public Node(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
    public void insert(Node<T> value) {
        // TO-DO
    }

    public boolean isLeaf() {
        // TO-DO
        return false;
    }

    public int size() {
       // TO-DO
       return 0;
    }

    public void remove() {
       // TO-DO
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void traversal(Node<T> root) {
        // TO-DO
    }

}
