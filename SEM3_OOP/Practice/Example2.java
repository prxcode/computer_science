// Multiple classes in one java program

class Area{
	static void fun1(){
		System.out.println("A"); // There can be same function but it can't be in same class however same function can be in different classes
	}
}


class Example2{
	static void fun1(){ // Functions apart from main should be static
		System.out.println("A"); 
	}
	
	static void fun2(){
		System.out.println("B");
	}
	
	public static void main(String args[]){
		System.out.println("C"); // It will print only C
		fun1(); // It will run fun1 function/method, print A
		fun2(); // It will run fun2 function/method, print B

		Area.fun1(); // To run fun1() from other class you need to mention classname.methodname
		fun2(); // It will run fun2 function/method, print B without naming class as its in main method
	}
}