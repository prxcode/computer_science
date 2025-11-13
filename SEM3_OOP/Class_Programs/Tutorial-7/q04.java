
class University {
    private String name = "OpenAI University";
    class Department {
        void show() {
            System.out.println("Dept in " + name);
        }
        class Faculty {
            void teach() {
} }
}

public class q04 {
    public static void main(String[] args) {
University.Department.Faculty f =
new University().new Department().new Faculty();
f.teach(); }
}
}

// Ans. B) Compilation Error Class not found!
