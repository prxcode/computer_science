class q9 {
    static int count = 0;
    q9() {
        count++;
}
    public static void main(String[] args) {
        q9 a1 = new q9();
        q9 a2 = new q9();
        q9 a3 = a2;
        System.out.println(q9.count);
} }

// Ans. B) 2
