class q4 {
    int a = 5;
    q4 modify(q4 d) {
        d.a += 10;
return d; }
    public static void main(String[] args) {
        q4 d1 = new q4();
        q4 d2 = d1.modify(d1);
        System.out.println(d1.a + " " + d2.a);
} }


// Ans. B) 15 15
