import java.util.Scanner; 
// node for each student 
class StudentNode { 
String name, branch; 
int id; 
double cgpa; 
StudentNode prev, next; 
StudentNode(String name, int id, String branch, double cgpa) { 
this.name = name; 
this.id = id; 
this.branch = branch; 
this.cgpa = cgpa; 
} 
} 
// doubly linked list to store students 
class StudentDLL { 
private StudentNode head, tail; 
// add student sorted by id 
public void addStudent(String name, int id, String branch, double cgpa) { 
StudentNode newNode = new StudentNode(name, id, branch, cgpa); 
if (head == null) { head = tail = newNode; System.out.println("addition success!"); return; } 
if (searchById(id) != null) { System.out.println("student with same id exists!"); return; } 
if (id < head.id) { newNode.next = head; head.prev = newNode; head = newNode; 
System.out.println("addition success!"); return; } 
if (id > tail.id) { tail.next = newNode; newNode.prev = tail; tail = newNode; System.out.println("addition 
success!"); return; } 
StudentNode cur = head; 
while (cur != null && cur.id < id) cur = cur.next; 
StudentNode prevNode = cur.prev; 
prevNode.next = newNode; newNode.prev = prevNode; 
newNode.next = cur; cur.prev = newNode; 
System.out.println("addition success!"); 
} 
// delete student by id 
public void deleteById(int id) { 
if (head == null) { System.out.println("list is empty."); return; } 
StudentNode cur = head; 
while (cur != null && cur.id != id) cur = cur.next; 
if (cur == null) { System.out.println("student not found."); return; } 
if (cur == head && cur == tail) head = tail = null; 
else if (cur == head) { head = head.next; head.prev = null; } 
else if (cur == tail) { tail = tail.prev; tail.next = null; } 
else { cur.prev.next = cur.next; cur.next.prev = cur.prev; } 
        System.out.println("deletion success!"); 
    } 
 
    // search student by id 
    public void searchStudent(int id) { 
        StudentNode n = searchById(id); 
        if (n == null) System.out.println("student not found."); 
        else { 
            System.out.println("student details are:"); 
            System.out.println("name : " + n.name); 
            System.out.println("idno : " + n.id); 
            System.out.println("branch : " + n.branch); 
            System.out.println("cgpa : " + n.cgpa); 
        } 
    } 
 
    // helper to find student by id 
    private StudentNode searchById(int id) { 
        StudentNode cur = head; 
        while (cur != null) { if (cur.id == id) return cur; cur = cur.next; } 
        return null; 
    } 
 
    // display all students descending by id 
    public void displayAllDescending() { 
        if (tail == null) { System.out.println("no students in list."); return; } 
        System.out.printf("%-10s%-8s%-8s%-6s%n","name","idno","branch","cgpa"); 
        StudentNode cur = tail; 
        while (cur != null) { 
            System.out.printf("%-10s%-8d%-8s%-6.2f%n", cur.name, cur.id, cur.branch, cur.cgpa); 
            cur = cur.prev; 
        } 
    } 
 
    // display student with highest cgpa 
    public void displayBestPerformer() { 
        if (head == null) { System.out.println("no students in list."); return; } 
        StudentNode best = head, cur = head.next; 
        while (cur != null) { if (cur.cgpa > best.cgpa) best = cur; cur = cur.next; } 
        System.out.println("best performer details are:"); 
        System.out.println("name : " + best.name); 
        System.out.println("idno : " + best.id); 
        System.out.println("branch : " + best.branch); 
        System.out.println("cgpa : " + best.cgpa); 
    } 
} 
 
public class Q1 { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        StudentDLL list = new StudentDLL(); 
        while (true) { 
            // menu 
            System.out.println("\noptions: 1.add 2.delete 3.search 4.display all 5.best 6.exit"); 
            System.out.print("enter choice: "); 
            int choice = sc.nextInt(); 
            switch (choice) { 
                case 1: 
                    System.out.print("enter name id branch cgpa: "); 
                    String name = sc.next(); 
                    int id = sc.nextInt(); 
                    String branch = sc.next(); 
                    double cgpa = sc.nextDouble(); 
                    list.addStudent(name,id,branch,cgpa); 
                    break; 
                case 2: 
                    System.out.print("enter id to delete: "); 
                    list.deleteById(sc.nextInt()); 
                    break; 
                case 3: 
                    System.out.print("enter id to search: "); 
                    list.searchStudent(sc.nextInt()); 
                    break; 
                case 4: 
                    list.displayAllDescending(); 
                    break; 
                case 5: 
                    list.displayBestPerformer(); 
                    break; 
                case 6: 
                    System.out.println("bye bye!"); 
                    sc.close(); 
                    return; 
                default: 
                    System.out.println("invalid choice, try again."); 
            } 
        } 
    } 
} 
