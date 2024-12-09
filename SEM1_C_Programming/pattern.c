

### **Pattern 1: Repeating 1s**
```
1
11
111
1111
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {       // Outer loop for rows
        for (int j = 1; j <= i; j++) {   // Inner loop for columns
            printf("1");                 // Print '1'
        }
        printf("\n"); // Newline after each row
    }
    return 0;
}
```

---

### **Pattern 2: Number Repeated by Its Value**
```
1
22
333
4444
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {       // Outer loop for rows
        for (int j = 1; j <= i; j++) {   // Inner loop for columns
            printf("%d", i);             // Print row number
        }
        printf("\n"); // Newline after each row
    }
    return 0;
}
```

---

### **Pattern 3: Right-Aligned Repeating Numbers**
```
   1
  22
 333
4444
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {         // Outer loop for rows
        for (int j = 1; j <= n - i; j++) { // Print spaces
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {     // Print row number
            printf("%d", i);
        }
        printf("\n");
    }
    return 0;
}
```

---

### **Pattern 4: Pyramid of Numbers**
```
   1
  121
 12321
1234321
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {            // Outer loop for rows
        for (int j = 1; j <= n - i; j++) {    // Print spaces
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {        // Print increasing numbers
            printf("%d", k);
        }
        for (int k = i - 1; k >= 1; k--) {    // Print decreasing numbers
            printf("%d", k);
        }
        printf("\n");
    }
    return 0;
}
```

---

### **Pattern 5: Repeating Rows**
```
1
22
333
4444
```

Similar to Pattern 2, but let's print numbers repeated in rows explicitly.

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {       // Outer loop for rows
        for (int j = 1; j <= i; j++) {   // Inner loop for columns
            printf("%d", i);             // Print the row number
        }
        printf("\n");
    }
    return 0;
}

```

### **Common Patterns with Examples**

1. **Right-Angled Triangle**:
```
*
* *
* * *
* * * *
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {       // Outer loop (rows)
        for (int j = 1; j <= i; j++) {   // Inner loop (columns)
            printf("* ");
        }
        printf("\n");
    }
    return 0;
}
```

---

2. **Number Triangle**:
```
1
1 2
1 2 3
1 2 3 4
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {       // Outer loop (rows)
        for (int j = 1; j <= i; j++) {   // Inner loop (columns)
            printf("%d ", j);
        }
        printf("\n");
    }
    return 0;
}
```

---

3. **Pyramid (Center-Aligned)**:
```
   *
  * *
 * * *
* * * *
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    for (int i = 1; i <= n; i++) {           // Outer loop (rows)
        for (int j = 1; j <= n - i; j++) {   // Print spaces
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {       // Print stars
            printf("* ");
        }
        printf("\n");
    }
    return 0;
}
```

---

4. **Diamond Pattern**:
```
   *
  * *
 * * *
* * * *
 * * *
  * *
   *
```

**Code**:
```c
#include <stdio.h>

int main() {
    int n = 4; // Number of rows for the top half
    // Top half
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n - i; j++) {
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {
            printf("* ");
        }
        printf("\n");
    }
    // Bottom half
    for (int i = n - 1; i >= 1; i--) {
        for (int j = 1; j <= n - i; j++) {
            printf(" ");
        }
        for (int k = 1; k <= i; k++) {
            printf("* ");
        }
        printf("\n");
    }
    return 0;
}
```


These are some variations of number patterns. Let me know if you’d like more patterns or a specific kind!
