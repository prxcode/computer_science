class q5 {
    int x;
    q5(int x) {
        this.x = x;
}
    void display() {
        System.out.println(x);
}
    public static void main(String[] args) {
        q5 e1 = new q5(10);
        q5 e2 = e1;
        e2.x = 20;
        e1.display();
    }
}

// Ans. B) 20
