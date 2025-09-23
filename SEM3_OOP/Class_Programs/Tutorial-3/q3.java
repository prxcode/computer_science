class q3 {
void show(int a, double b) { System.out.println("int-double");
}
void show(double a, int b) { System.out.println("double-int");
}
    public static void main(String[] args) {
        q3 t = new q3();
        t.show(10, 10);
} }

// Ans. D) Ambiguous Method Call
