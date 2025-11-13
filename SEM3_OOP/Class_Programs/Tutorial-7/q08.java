
abstract class Vehicle {
    abstract void move();
    static class Engine {
void start() { System.out.println("Engine Started"); } }
}
class Car extends Vehicle {
void move() { System.out.println("Car Moving"); }
}
public class q08 {
    public static void main(String[] args) {
        Vehicle.Engine e = new Vehicle.Engine();
        e.start();
        new Car().move();
} }

// Ans. A) Engine Started -> Car Moving
