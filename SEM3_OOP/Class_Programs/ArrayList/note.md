# ArrayList

- ArrayList is a part of collection framwork and is present in java.util package.
- It provides us dynamics arrays in java.
- Slower than standard arrays.
- Good where lots of manipulation in array required.
- Arraylist -> (List) Interface -> Collection
- ArrayList is intiailized by size, however the size can increase if collections grows or shrunk if objects are removed from the collection.
- Java ArrayList allows us to randomly access the list.
- ArrayList can not be used from primitive types. like int, char, etc. Need a wrapper class for such cases.
- ArrayList```ArrayList <Type> arrL = new ArrayList <Type>();```
```java
import java.util.ArrayList;
import java.util.Arrays;
public class Test{
  public static void main(String args[]){
    int[] arr = new int[2]; //Size of the array is fixed
    arr[0] = 1;
    arr[1] = 2;
    System.out.println(arr[0]); // display element add 0th index which is 1
    
    // ArrayList 

    ArrayList<Integer> arrL = new 
    ArrayList<Integer>(); // no need to specify size of list

    arrL.add(1); // adding elements
    arrL.add(2);
    System.out.println(arrL); // display will be in list [1,2]
    System.out.println(arrL.size()); // display the size of list
    System.out.println(arrL.sort()); // display the sorted list in A -> Z order
    System.out.println(arrL.get(0)); // display element add 0th index which is 1
    
    }
}

  ```
- ArrayList```ArrayList arrL = new ArrayList();```
- ArrayList Collection```ArrayList arrL = new ArrayList(c);```
- ArrayList Size```ArrayList arrL = new ArrayList(N);```

