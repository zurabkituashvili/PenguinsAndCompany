package pgdp.penguinDate;

import pgdp.tree.Tree;

public class PenguinDateGenerator {

    private Tree<Penguin> tree;

    public PenguinDateGenerator(Tree<Penguin> tree) {
        this.tree = tree;
    }

    public boolean canGoOnADate(Penguin p1, Penguin p2) {
        int distance = tree.distanceBetweenNodes(p1, p2);
        if (distance >= p1.getAllowance() && distance >= p2.getAllowance()) {
            return true;
        }
        return false;
    }

    public Tree<Penguin> getTree() {
        return this.tree;
    }

}
