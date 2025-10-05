// Double is extended version of float
// Long is extended version of int
// int(datatype) != Integer(class)

class Example5{
	public static void main(String args[]){
		int x = Integer.parseInt("123"); // It is more simple and one line to store value in variable x

		Integer x1 = Integer.valueOf("10110",2); // It will be stored as decimal as we are converting binary to decimal
		int y = x1.intValue(); // It needs reference variable x1 to store and pass to y, you can't print x1

		Double x2 = Double.valueOf("56"); // It will be stored as double as we are converting decimal to double
		double z = x2.doubleValue(); // It needs reference variable x2 to store and pass to z, you can't print x2

		System.out.println(x); // 123
		System.out.println(y); // 22
		System.out.println(z); // 56.0
	}
}