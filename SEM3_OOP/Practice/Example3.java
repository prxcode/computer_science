// How to make non static functions and create objects to call functions


class Area{
	static int x; // Instance (object) memeber variable
	int y; // Instance (object) memeber variable
	private int z; // Instance (object) memeber variable which is PRIVATE
	void fun1(){
		System.out.println("fun1");
	}
	
	void fun2(){
		System.out.println("fun1");
	}
}


// Area class has int x, int y, fun1(), fun2()

class Example3{
	public static void main(String args[]){
		System.out.println("Example3");
		Area a1 = new Area();
		a1.x=5; // It will update x=5 for a1 object which is made of Area class
		Area a2 = new Area();
		a2.y=7;
		Area a3 = new Area();
		a3.z=21;
		System.out.println("hello");
		System.out.println(a1.x); // It will print 5
		System.out.println(Area.x); // It will print 5 as value got updated you can only use classname.function/variable when its static if non-static then make objects
		System.out.println(a2.y); // It will print 7
		System.out.println(a3.z); // It will print 0 if value not given but note its PRIVATE so show error

		
	}
}