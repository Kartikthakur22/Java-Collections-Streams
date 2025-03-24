package Collections.MapInterface;

import java.util.*;

class Employee {
    String name, department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String toString() {
        return name;
    }
}

public class GroupEmployees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        Map<String, List<Employee>> groupedByDepartment = new HashMap<>();
        
        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(scanner.nextLine());
        
        while (n-- > 0) {
            System.out.print("Enter name and department (space-separated): ");
            String[] input = scanner.nextLine().split(" ");
            Employee emp = new Employee(input[0], input[1]);
            employees.add(emp);
            groupedByDepartment.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        scanner.close();
        
        groupedByDepartment.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
    }
}
