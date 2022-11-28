package pgdp.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {

    private Node<T> root;

    public Tree (T data) {
        root = new Node(data);
    }

    public void insert(T value, T parent) {
       // TO-DO
    }

    public void remove(T value) {
        // TO-DO
    }

    public T LCA(T a, T b) {
        // TO-DO
        return null;
    }

    public int distanceBetweenNodes(T a, T b) {
        // TO-DO
        return 0;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean containsKey(T key) {
        // TO-DO
        return false;
    }

    public void traversal() {
        // TO-DO
    }

}
