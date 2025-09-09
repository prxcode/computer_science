// this keyword
// it can be used to refer current class instance variable.
class Student {
  int rollno;
  String name;
  float fee;

  Student(int r, String n, float f) {
    this.rollno = r;
    this.name = n;
    this.fee = f;
  }

  void display() {
    System.out.println(rollno + " " + name + " " + fee);
  }
}

class TestThis {
  public static void main(String[] args) {
    Student s1 = new Student(111, "ankit", 5000f);
    Student s2 = new Student(112, "sumit", 6000f);
    s1.display();
    s2.display();
  }
}
