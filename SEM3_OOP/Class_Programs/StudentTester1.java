
class Student{
  String name; int age;
  public Student (String aName, int aAge){
    name = aName; age = aAge;
  }

  public void setAge(int aAge){age = aAge;}
    public void printAge() {System.out.println (age);
}
}

public class StudentTester1{
  public static void main(String[] args){
      Student s1 = new Student("abc", 10);
  Student s2 = s1;
  s2.setAge(20);
  s1.printAge();
  s2.printAge();

}
}
    
