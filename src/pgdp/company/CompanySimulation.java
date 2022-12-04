package pgdp.company;

import java.util.Scanner;

public class CompanySimulation {
    public static void main(String[] args) {
        simulation("Novak","ATP");
    }

    private static void simulation(String ceoName, String companyName) {
        Employee ceo = new Employee(ceoName,null);
        ceo.setID(0);
        Company company = new Company(companyName,ceo);
        Scanner scanner = new Scanner(System.in);
        String numberOfQueries = scanner.nextLine();

        for (int k = 0; k < Integer.parseInt(numberOfQueries); k++) {
            String query = scanner.nextLine();
            try {
                if (query.startsWith("EmployeeWithID ")) {
                    String id = query.substring(query.indexOf(' ') + 1);
                    if (company.findByID(Integer.parseInt(id)) == null) {
                        System.out.println("Employee with provided ID doesn't exist");
                    } else {
                        System.out.println(company.findByID(Integer.parseInt(id)));
                    }

                } else if (query.startsWith("Add ")) {
                    String id = query.substring(query.lastIndexOf(' ') + 1);
                    String name = query.substring(query.indexOf(' ') + 1, query.lastIndexOf(' '));
                    if (company.findByID(Integer.parseInt(id)) == null) {
                        System.out.println("Boss with provided ID doesn't exist");
                    } else {
                        company.addEmployee(new Employee(name, company.findByID(Integer.parseInt(id))));
                    }
                } else if (query.startsWith("Fire ")) {
                    String id = query.substring(query.indexOf(' ') + 1);
                    if (company.findByID(Integer.parseInt(id)) == null) {
                        System.out.println("Employee with provided ID doesn't exist");
                    } else {
                        company.fireEmployee(Integer.parseInt(id));
                    }
                } else if (query.startsWith("FindCommonBoss ")) {
                    String id1 = query.substring(query.lastIndexOf(' ') + 1);
                    String id2 = query.substring(query.indexOf(' ') + 1, query.lastIndexOf(' '));
                    if (company.findByID(Integer.parseInt(id1)) == null || company.findByID(Integer.parseInt(id2)) == null) {
                        System.out.println("Employee with provided ID doesn't exist");
                    } else {
                        System.out.println(company.findCommonBoss(company.findByID(Integer.parseInt(id1)), company.findByID(Integer.parseInt(id2))));
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            catch (Exception e) {
                System.out.println("Provided query incorrect, please try again.");
            }
        }
        scanner.close();
    }
}
