package pgdp.tree;

public class Tree<T> {

    private Node<T> root;

    public Tree (T data) {
        root = new Node(data);
    }

    public void insert(T value, T parent) {
       Node<T> parentNode = root.findNode(parent);
       parentNode.insert(new Node<>(value));
    }

    public void remove(T value) {
        Node<T> node = root.findNode(value);
        node.remove();
    }

    public T LCA(T a, T b) {
        if (a == b) return a;

        if (root.findNode(a).findNode(b) != null) {
            return a;
        }
        else if (root.findNode(b).findNode(a) != null) {
            return b;
        }
        else {
            Node<T> tmp = root.findNode(a);
            while (tmp != root) {
                tmp = tmp.getParent();
                if (tmp.findNode(b) != null) return tmp.getData();
            }
        }
        return null;
    }

    public int distanceBetweenNodes(T a, T b) {
        int aDistance = 0;
        int bDistance = 0;
        Node<T> commonNode = root.findNode(LCA(a, b));
        Node<T> aNode = root.findNode(a);
        Node<T> bNode = root.findNode(b);
        aDistance = aNode.findParentDistance(commonNode);
        bDistance = bNode.findParentDistance(commonNode);
        return aDistance + bDistance;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean containsKey(T key) {
        return root.findNode(key) != null;
    }

    public void traversal() {
        root.traversal(root);
    }

}
