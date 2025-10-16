import java.util.LinkedList;
public class q08 {
    public static void main(String[] args) {
LinkedList<Integer> list = new LinkedList<>(); 
list.add(1);
list.add(2);
list.add(3);
list.set(1, 10);
list.add(2, 20);
System.out.println(list);
}
}



// Ans. A) [1, 10, 20, 3]
