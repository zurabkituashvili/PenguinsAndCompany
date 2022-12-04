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
        if (employees.get(newEmployee.getBoss().getID()) != null) {
            Integer newId = availableIDs.poll();
            if (newId == null) newId = availableID++;
            newEmployee.setID(newId);
            employeesTree.insert(newId, newEmployee.getBoss().getID());
            employees.put(newId, newEmployee);
        }
    }

    public void fireEmployee(int ID) {
        if (ID != CEO.getID()) {
            employeesTree.remove(ID);
            availableIDs.add(ID);
            employees.remove(ID);
        }
    }

    public Employee findCommonBoss(Employee e1, Employee e2) {
        int ID = employeesTree.LCA(e1.getID(), e2.getID());
        Employee commonEmployee = employees.get(ID);
        return commonEmployee;
    }

    public Employee findByID(int ID) {
        return employees.get(ID);
    }

}
