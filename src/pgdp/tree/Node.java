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
        children.add(value);
        value.parent = this;
    }

    public boolean isLeaf() {
        if (children == null || children.isEmpty())
            return true;
        else
            return false;
    }

    public int size() {
       int res = 1;
       for (Node<T> child : children) {
           res += child.size();
       }
       return res;
    }

    public void remove() {
       parent.children.remove(this);
       for (Node<T> child : children) {
           parent.insert(child);
       }
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
        System.out.println(data);
        if (children != null){
            for (Node<T> child : children) {
                child.traversal(child);
            }
        }
    }

    public Node<T> findNode(T value) {
        if (data == value) {
            return this;
        }
        else {
            Node<T> result = null;
            for (Node<T> child : children) {
                result = child.findNode(value);
                if (result != null) break;
            }
            return result;
        }
    }

    public int findParentDistance(Node<T> parent) {
        int distance = 0;
        Node<T> child = this;
        while (child != parent) {
            child = child.parent;
            distance++;
        }
        return distance;
    }

}
