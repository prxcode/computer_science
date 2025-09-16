class Bike9 {
    final int speedlimit = 90;  // final variable cannot be reassigned

    void run() {
        // speedlimit = 400;  // ERROR: cannot assign a value to final variable
        System.out.println("Speed limit is: " + speedlimit);
    }

    public static void main(String args[]) {
        Bike9 obj = new Bike9();
        obj.run();
    }
}
