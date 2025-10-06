import java.util.Scanner;


class UsernameEncryptor{
        static void userpass(){
        System.out.print("Enter username: ");
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        System.out.println("Original Username: "+user);
        String reverse_string =  new StringBuilder(user)
        .reverse()
	.toString()
	.toUpperCase();
        System.out.println("Encrypted Username: "+reverse_string);
}

        public static void main(String args[]){
                UsernameEncryptor.userpass();

        }
}
