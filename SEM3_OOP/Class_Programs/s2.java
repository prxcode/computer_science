class s2 {
  void m(s2 obj) {
    System.out.println("method is invoked");
  }

  void p() {
    m(this); // calls m() with the current object
  }

  public static void main(String args[]) {
    s2 s1 = new s2();
    s1.p(); // correctly call the instance method
  }
}
