
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { 
	return id; 
	}
    public String getName() { 
	return name; 
	}
    public int getAge() { 
	return age; 
	}

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Age: " + age;
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareToIgnoreCase(e2.getName());
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getAge(), e2.getAge());
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee " + i + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            employees.add(new Employee(id, name, age));
        }

        Collections.sort(employees, new NameComparator());
        System.out.println("\nSorting by Name:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees, new AgeComparator());
        System.out.println("\nSorting by Age:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        sc.close();
    }
}
