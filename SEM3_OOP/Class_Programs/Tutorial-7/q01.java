interface Drawable {
  void draw();
  default void color() { System.out.println("Black"); } 
}
abstract class Shape implements Drawable {
  Shape() { System.out.println("Shape Created"); } 
  abstract double area();
}
class Circle extends Shape {
  private int r;
  Circle(int r) { this.r = r; }
  double area() { return 3.14 * r * r; }
  public void draw() { System.out.println("Drawing Circle"); }
}
public class q01 {
  public static void main(String[] args) {
    Drawable d = new Circle(5);
      d.draw();
      d.color(); 
    System.out.println(((Circle)d).area());
  } 
}

// Ans. B) Shape Created -> Drawing Circle -> Black -> 78.5
