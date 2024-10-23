/*Write a C program in which the user to type his own ID(1050), if the ID is valid it will 
ask him to enter his password (123) , if the password is correct the program will print 
the name of the user, otherwise, the program will print Incorrect Password and if the 
ID does not exist , the program will print Incorrect ID. (Use Switch case only) 
 
Test case: 
Please Enter Your ID: 1050 
Enter your password: 123 
Welcome! Dear Programmer*/

#include <stdio.h>

int main() {
    int userID;
    int password;
    
    // Prompt user for ID
    printf("Enter your ID: ");
    scanf("%d", &userID);
    
    // Check the ID using a switch statement
    switch (userID) {
        case 1050:  // Valid ID
            printf("Enter your password: ");
            scanf("%d", &password);
            
            // Check the password
            switch (password) {
                case 123:  // Correct password
                    printf("Welcome, User!\n");  // Print user name or welcome message
                    break;
                default:  // Incorrect password
                    printf("Incorrect Password.\n");
                    break;
            }
            break;  // End of valid ID case
        default:  // Invalid ID
            printf("Incorrect ID.\n");
            break;
    }

    return 0;  // Indicate successful termination
}
