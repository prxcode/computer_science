import java.util.Scanner; 
 
class Employee { 
    String name; 
    int id; 
    double salary; 
 
    Employee(String name, int id, double salary) { 
        this.name = name; 
        this.id = id; 
        this.salary = salary; 
    } 
 
    public String toString() { 
        return "ID: " + id + " | Name: " + name + " | Salary: " + salary; 
    } 
} 
 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        Employee[] employees = new Employee[10]; 
 
        System.out.println("Enter details for 10 employees:"); 
        for (int i = 0; i < 10; i++) { 
            System.out.println("Employee " + (i + 1) + ":"); 
            System.out.print("Name: "); 
            String name = sc.next(); 
            System.out.print("ID: "); 
            int id = sc.nextInt(); 
            System.out.print("Salary: "); 
            double salary = sc.nextDouble(); 
            employees[i] = new Employee(name, id, salary); 
        } 
 
        System.out.println("\n--- Unsorted Records ---"); 
        display(employees); 
 
        long startTime = System.currentTimeMillis(); 
        mergeSort(employees, 0, employees.length - 1); 
        long endTime = System.currentTimeMillis(); 
 
        System.out.println("\n--- Sorted Records ---"); 
        display(employees); 
 
        System.out.println("\nTime taken: " + (endTime - startTime) + "ms"); 
    } 
 
    static void mergeSort(Employee[] a, int p, int r) { 
        if (p < r) { 
            int q = (p + r) / 2; 
            mergeSort(a, p, q); 
            mergeSort(a, q + 1, r); 
            merge(a, p, q, r); 
             
            System.out.print("Partial merge result: "); 
            for (int i = p; i <= r; i++) { 
                System.out.print(a[i].name + " "); 
            } 
            System.out.println(); 
        } 
    } 
 
    static void merge(Employee[] a, int p, int q, int r) { 
        int n1 = q - p + 1; 
        int n2 = r - q; 
 
        Employee[] L = new Employee[n1]; 
        Employee[] R = new Employee[n2]; 
 
        for (int i = 0; i < n1; i++) { 
            L[i] = a[p + i]; 
        } 
        for (int j = 0; j < n2; j++) { 
            R[j] = a[q + 1 + j]; 
        } 
 
        int i = 0, j = 0, k = p; 
 
        while (i < n1 && j < n2) { 
            if (L[i].name.compareTo(R[j].name) <= 0) { 
                a[k] = L[i]; 
                i++; 
            } else { 
                a[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
 
        while (i < n1) { 
            a[k] = L[i]; 
            i++; 
            k++; 
        } 
 
        while (j < n2) { 
            a[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
 
    static void display(Employee[] arr) { 
        for (Employee e : arr) { 
            System.out.println(e); 
        } 
    } 
} 
 
