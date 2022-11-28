package pgdp.company;
import pgdp.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Company {

    private Employee CEO;
    private Tree<Integer> employeesTree;
    private Map<Integer,Employee> employees;
    private Queue<Integer> availableIDs;
    private static int availableID = 1;
    private String name;

    public Company(String name, Employee CEO) {
        this.name = name;
        this.CEO = CEO;
        employeesTree = new Tree<>(0);
        availableIDs = new PriorityQueue<>();
        employees = new HashMap<>();
        employees.put(0,CEO);
    }

    public void addEmployee(Employee newEmployee) {
        // TO-DO
    }

    public void fireEmployee(int ID) {
       // TO-DO
    }

    public Employee findCommonBoss(Employee e1, Employee e2) {
        // TO-DO
        return null;
    }

    public Employee findByID(int ID) {
       // TO-DO
        return null;
    }

}
