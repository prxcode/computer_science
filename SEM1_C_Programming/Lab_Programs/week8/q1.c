#include <stdio.h>


int vibgyor(){
	char color;
	printf("Enter color: ");
	scanf("%c",&color);
	switch(color){
		case 'v':
		case 'V':
			printf("Violet\n");
			break;
		case 'i':
		case 'I':
			printf("Indigo");
			break;
		case 'b':
		case 'B':
			printf("Blue");
			break;
		case 'g':
		case 'G':
			printf("Green");
			break;
		case 'y':
		case 'Y':
			printf("Yellow");
			break;
		case 'o':
		case 'O':
			printf("Orange");
			break;
		case 'r':
		case 'R':
			printf("Red");
			break;
		default:
			printf("color is not in rainbow!");
			break;
		}
	}

int main(){
	vibgyor();
	return 0;
}
