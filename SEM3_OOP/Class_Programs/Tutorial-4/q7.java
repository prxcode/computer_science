public class q7 {
int x;
q7(int x) { this.x = x; }
public static void modify(q7 o) {
o.x = o.x + 5;
}
public static void main(String[] args) {
q7 obj = new q7(10);
modify(obj);
System.out.println(obj.x);
}
}

// Ans B) 15
