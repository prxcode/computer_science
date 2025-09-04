//Constructor Example

class Example4 {
    String languages;
    
    Example4(String lang){
        languages = lang;
        System.out.println(languages + " Programming Language");
    }
    public static void main(String args[]){
        Example4 obj1 = new Example4("Java");
        Example4 obj2 = new Example4("Python");
        Example4 obj3 = new Example4("C");
    }
}
