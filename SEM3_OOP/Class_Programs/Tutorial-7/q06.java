class Outer {
  int val = 100;
  void outerMethod() {
    int local = 50;
    class Inner {
      void show() {
        System.out.println(val + local); }
    }
    new Inner().show();
  }
}

public class q06{
  public static void main(String args[]){
    new Outer().outerMethod();
  }
}

// Ans. A) 150
