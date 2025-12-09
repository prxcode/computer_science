// Creating Array in C and Java
// In C we write: int a[5]; a[2] = 56; printf(a[2]); -> 56
// In Java we write: int a[] = new int [5]; a[2] = 56; System.out.println(a[2]); -> 56 also System.out.println(a.length); -> 5

class Example6{
	public static void main(String args[]){
		int i, s=0;
		for (i=0; i<args.length; i++){
			System.out.println(i+" index: "+args[i]);
		}
		for (i=0; i<args.length; i++){
			s = s+Integer.parseInt(args[i]);
			
		}
		System.out.println("Sum of all numbers are: "+s);
		System.out.println("Average is: "+s/args.length);
		
	}
}
