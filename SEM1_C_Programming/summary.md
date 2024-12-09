
---

### **1. Basic Structure of a C Program**
Every C program follows this structure:
```c
#include <stdio.h>

int main() {
    printf("Hello, World!"); // Prints to console
    return 0;               // Indicates successful execution
}
```

---

### **2. Conditional Statements**

**If-Else Example**:
```c
#include <stdio.h>

int main() {
    int number = 5;
    if (number > 0) {
        printf("Number is positive.");
    } else {
        printf("Number is negative.");
    }
    return 0;
}
```

**Switch Example**:
```c
#include <stdio.h>

int main() {
    int day = 3;
    switch (day) {
        case 1: printf("Monday"); break;
        case 2: printf("Tuesday"); break;
        case 3: printf("Wednesday"); break;
        default: printf("Invalid day");
    }
    return 0;
}
```

---

### **3. Loops**

**For Loop Example**:
```c
#include <stdio.h>

int main() {
    for (int i = 0; i < 5; i++) {
        printf("%d ", i); // Prints 0 to 4
    }
    return 0;
}
```

**While Loop Example**:
```c
#include <stdio.h>

int main() {
    int i = 0;
    while (i < 5) {
        printf("%d ", i);
        i++;
    }
    return 0;
}
```

**Do-While Loop Example**:
```c
#include <stdio.h>

int main() {
    int i = 0;
    do {
        printf("%d ", i);
        i++;
    } while (i < 5);
    return 0;
}
```

---

### **4. Break and Continue**

**Break Example**:
```c
#include <stdio.h>

int main() {
    for (int i = 0; i < 5; i++) {
        if (i == 3) {
            break; // Exits loop when i = 3
        }
        printf("%d ", i); // Prints 0, 1, 2
    }
    return 0;
}
```

**Continue Example**:
```c
#include <stdio.h>

int main() {
    for (int i = 0; i < 5; i++) {
        if (i == 3) {
            continue; // Skips iteration when i = 3
        }
        printf("%d ", i); // Prints 0, 1, 2, 4
    }
    return 0;
}
```

---

### **5. Arrays**

**1D Array Example**:
```c
#include <stdio.h>

int main() {
    int arr[5] = {1, 2, 3, 4, 5};
    for (int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}
```

**2D Array Example (and Traversing it)**:
```c
#include <stdio.h>

int main() {
    int matrix[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    for (int i = 0; i < 3; i++) {         // Rows
        for (int j = 0; j < 3; j++) {     // Columns
            printf("%d ", matrix[i][j]);  // Access each element
        }
        printf("\n"); // Newline after each row
    }
    return 0;
}
```

---

### **6. Functions**

**Basic Function Example**:
```c
#include <stdio.h>

int add(int a, int b) {
    return a + b; // Returns sum
}

int main() {
    int result = add(3, 4);
    printf("Sum: %d", result); // Prints "Sum: 7"
    return 0;
}
```

---

### **7. Recursion**

**Factorial Example**:
```c
#include <stdio.h>

int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1; // Base case
    }
    return n * factorial(n - 1); // Recursive call
}

int main() {
    int num = 5;
    printf("Factorial of %d is %d", num, factorial(num));
    return 0;
}
```

---

### **8. Strings**

**Example of String Operations**:
```c
#include <stdio.h>
#include <string.h>

int main() {
    char str1[50] = "Hello";
    char str2[50] = "World";
    strcat(str1, str2); // Concatenate str2 to str1
    printf("Concatenated String: %s\n", str1);
    printf("String Length: %lu\n", strlen(str1)); // String length
    return 0;
}
```

---

### **9. Passing Arrays/Strings to Functions**

**Passing Array Example**:
```c
#include <stdio.h>

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
}

int main() {
    int arr[5] = {1, 2, 3, 4, 5};
    printArray(arr, 5); // Pass array to function
    return 0;
}
```

**Passing String Example**:
```c
#include <stdio.h>

void printString(char str[]) {
    printf("%s", str); // Print string
}

int main() {
    char str[50] = "Hello, World!";
    printString(str); // Pass string to function
    return 0;
}
```

---

### **10. Pointers**

**Pointer Example**:
```c
#include <stdio.h>

int main() {
    int a = 10;
    int *p = &a; // Pointer to 'a'
    printf("Value of a: %d\n", *p); // Dereference pointer
    printf("Address of a: %p\n", p); // Address of 'a'
    return 0;
}
```

**Pointer to Array**:
```c
#include <stdio.h>

int main() {
    int arr[3] = {1, 2, 3};
    int *p = arr; // Points to the first element
    for (int i = 0; i < 3; i++) {
        printf("%d ", *(p + i)); // Access elements using pointer
    }
    return 0;
}
```
