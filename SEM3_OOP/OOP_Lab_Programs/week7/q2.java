import java.util.*;

class Employee {
    int empId;
    String name;
    int daysPresent;

    Employee(int empId, String name, int daysPresent) {
        this.empId = empId;
        this.name = name;
        this.daysPresent = daysPresent;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Alice", 22));
        employees.add(new Employee(102, "Bob", 18));
        employees.add(new Employee(103, "Charlie", 25));
        employees.add(new Employee(104, "David", 15));
        employees.add(new Employee(105, "Eva", 20));

        System.out.println("All Employees:");
        for (Employee e : employees) {
            System.out.println(e.empId + " " + e.name + " " + e.daysPresent);
        }

        System.out.print("Enter Employee ID to search: ");
        int searchId = sc.nextInt();
        boolean found = false;
        for (Employee e : employees) {
            if (e.empId == searchId) {
                System.out.println("Employee Found: " + e.name + " - Days Present: " + e.daysPresent);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }

        System.out.println("Employees with attendance less than 20 days:");
        for (Employee e : employees) {
            if (e.daysPresent < 20) {
                System.out.println(e.empId + " " + e.name + " " + e.daysPresent);
            }
        }
    }
}
