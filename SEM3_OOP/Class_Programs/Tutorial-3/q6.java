class q6 {
    q6() {
        System.out.print("No-Arg ");
    }
    q6(int x) {
        this();
        System.out.print("Int ");
    }
    q6(double x) {
        this(5);
        System.out.print("Double ");
    }
    public static void main(String[] args) {
        new q6(3.14);
} }


// Ans. A) No-Arg Int Double
