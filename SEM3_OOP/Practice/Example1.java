// One class with multiple function 

class Example1{
	static void fun1(){
		System.out.println("A"); // Functions apart from main should be static
	}
	
	static void fun2(){
		System.out.println("B");
	}
	
	public static void main(String args[]){
		System.out.println("C"); // It will print only C
		fun1(); // It will run fun1 function/method, print A
		fun2(); // It will run fun2 function/method, print B
		
	}
}