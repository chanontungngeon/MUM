import java.util.Arrays;

// import java.util.Arrays;
// import java.util.LinkedHashSet;

// import java.util.Arrays;

// import java.lang.Math;
// import java.util.Scanner;
public class Problems {

    // 1. Problem sum of digits
    public static int sumdigit(int a) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
    // ------------------------------------------------------------------------------
    // 34. Write a Java program to compute the area of a hexagon. Go to the editor
    // Area of a hexagon = (6 * s^2)/(4*tan(π/6))
    // where s is the length of a side
    // Input Data:
    // Input the length of a side of the hexagon: 6
    // Expected Output
    // The area of the hexagon is: 93.53074360871938

    public static double hexagon(double s) {
        return (6 * (s * s)) / (4 * Math.tan(Math.PI / 6));
    }

    // -------------------------------------------------------------
    // 48. Write a Java program to print the odd numbers from 1 to 99. Prints one
    // number per line.
    public static int[] odd(int start, int end) {
        int odd = 0;
        for (int i = start; i < end; i++) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        int[] x = new int[odd + 1];
        int j = 0;
        for (int i = start; i < end + 1; i++) {
            if (i % 2 == 1) {
                x[j] = i;
                j++;

            }
        }

        return x;
    }
    // ------------------------------------------------

    // 50. Write a Java program to print numbers between 1 to 100 which are
    // divisible by 3, 5 and by both. Go to the editor
    // Sample Output:

    // Divided by 3:
    // 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57
    // , 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99,

    // Divided by 5:
    // 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90,
    // 95,

    // Divided by 3 & 5:
    // 15, 30, 45, 60, 75, 90,

    public static int[] divisibleby(int n, int start, int end) {
        int sum_divisible = 0;
        for (int i = start; i < end; i++) {
            if (i % n == 0) {
                sum_divisible++;
            }
        }
        int[] x = new int[sum_divisible];
        int j = 0;
        for (int i = start; i < end; i++) {
            if (i % n == 0) {
                x[j] = i;
                j++;
            }
        }
        return x;
    }
    // ------------------------------------------------------------------------------

    // 65. Write a Java program to calculate the modules of two numbers without
    // using any inbuilt modulus operator. Go to the editor
    // Sample Output:

    // Input the first number : 19
    // Input the second number: 7
    // 5

    public static int calmodules(int first, int second) {
        // I.Case1
        // while (true) {
        // first = first - second;
        // if (first < second) {
        // break;
        // }
        // }
        // return first;
        // II.Case 2 (worst but eaiser to writes)
        // Recursive
        first = first - second;
        if (first > second) {
            return calmodules(first, second);
        } else {
            return first;
        }

    }
    // ------------------------------------------------------------------------------
    // 61. Write a Java program to reverse a word. Go to the editor
    // Sample Output:

    // Input a word: dsaf
    // Reverse word: fasd

    static String reversesString(String s) {
        String x = "";
        for (int i = s.length() - 1; i >= 0; i = i - 1) {
            x += s.charAt(i);
        }
        return x;

    }
    // -----------------------------------------------------
    // 66. Write a Java program to compute the sum of the first 100 prime numbers.
    // Go to the editor
    // Sample Output:
    // Sum of the first 100 prime numbers: 24133

    // static int SumPrime(int n){
    // int[] primes = new int[n];
    // int value=15;
    // int prime = 0;
    // while(true){

    // for (int i = 2; i < value; i++) {
    // if (value % i == 0) {
    // prime = 1;
    // }break;
    // }

    // }
    // return
    // }

    public static int[] prime(int max) {
        int value = 2;
        int noprime = 0;
        int excel = 0;
        int[] grab = new int[max];
        while (excel < max) {

            noprime = 0;
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0) {
                    noprime++;
                }

            }
            if (noprime == 0) {
                // System.out.println(value);
                grab[excel] = value;
                excel++;

            }
            value++;
        }
        return grab;
    }
    // -----------------------------------------------------
    // 39. Write a Java program to create and display unique three-digit number
    // using 1, 2, 3, 4. Also count how many three-digit numbers are there. Go to
    // the editor
    // Expected Output

    // 123
    // 124
    // ...

    // 431
    // 432
    // Total number of the three-digit-number is 24?

    // public static int[] unique(int[] n) {
    // int count = 0;
    // for (int i = 0; i < n.length; i++) {
    // for (int j = 0; j < n.length; j++) {
    // for (int j2 = 0; j2 < n.length; j2++) {
    // if (i != j && i != j2 && j != j2) {
    // count++;
    // }
    // }
    // }
    // }
    // int[] x = new int[count];
    // int num = 0;
    // for (int i = 0; i < n.length; i++) {
    // for (int j = 0; j < n.length; j++) {
    // for (int j2 = 0; j2 < n.length; j2++) {
    // if (i != j && i != j2 && j != j2) {
    // x[num] = i + j + j2;
    // num++;
    // }
    // }
    // }
    // }
    // return x;
    // }
    // -----------------------------------------------------
    // 74. Write a Java program to test if 10 appears as either the first or last
    // element of an array of integers. The length of the array must be greater than
    // or equal to 2. Go to the editor
    // Sample Output:
    // Test Data: array = 10, -20, 0, 30, 40, 60, 10

    // true

    static boolean check10(int[] a) {
        boolean check = false;
        if (a.length < 2) {
            System.out.println("Array is not long enough to determine.");
        }
        if (a[0] == 10 || a[a.length - 1] == 10) {
            System.out.println("There is a 10 in first or last element of the array.");
            return check = true;
        }
        if (a[0] == a[a.length - 1]) {
            System.out.println("First and Last Digit are the same!");
            return check = true;
        }

        return check;
    }
    // -----------------------------------------------------
    // 79. Write a Java program to rotate an array (length 3) of integers in left
    // direction. Go to the editor
    // Sample Output:

    // Original Array: [20, 30, 40]
    // Rotated Array: [30, 40, 20]

    static int[] rotate(int[] a) {
        int len = a.length;
        int[] x = new int[len];
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                x[a.length - 1] = a[0];
            } else {
                x[i] = a[i + 1];
            }
        }
        return x;
    }
    // -----------------------------------------------------
    // 83. Write a Java program to multiply corresponding elements of two arrays of
    // integers. Go to the editor
    // Sample Output:

    // Array1: [1, 3, -5, 4]

    // Array2: [1, 4, -5, -2]

    // Result: 1 12 25 -8
    public static int[] sum_array(int[] first, int[] second) {
        int index = 0;
        int first_sum = 0;
        int second_sum = 0;
        int len = (first.length == second.length) ? first.length : 0;
        int[] x = new int[len];
        if (first.length == second.length) {
            // nested loop O(n^2)
            // for (int i = 0; i < first.length; i++) {
            // for (int j = 0; j < second.length; j++) {
            // if (i == j) {
            // x[index] = first[i] * second[j];
            // index++;
            // }
            // }
            // }
            // single loop O(n)
            for (int i = 0, j = 0; i < x.length; i++, j++) {
                x[index] = first[i] * second[j];
                first_sum = first_sum + first[i];
                second_sum = second_sum + second[j];
                index++;
            }
            System.out.println("Sum of first array is " + first_sum + " and Sum of second array is " + second_sum);
        } else {
            System.out.println("Arrays are in different size!");
        }
        return x;
    }
    // -----------------------------------------------------

    // 86. Write a Java program start with an integer n,
    // divide n by 2 if n is even or multiply by 3 and add 1 if n is odd,
    // repeat the process until n = 1. Go to the editor

    public static int[] gameoddeven(int n) {
        int count = 0;
        int new_n = n;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
        }

        int[] x = new int[count];
        int index2 = 0;
        while (new_n != 1) {
            if (new_n % 2 == 0) {
                new_n = new_n / 2;
                x[index2] = new_n;
            } else {
                new_n = 3 * new_n + 1;
                x[index2] = new_n;
            }
            index2++;
        }
        return x;
    }
    // -----------------------------------------------------

    public static void main(String[] args) {
        // int[] a = { 1, 2, 3, 4, -2 };
        // int[] b = { 9, 2, 3, 4, 9 };
        int c = 601;
        System.out.println(Arrays.toString(gameoddeven(c)));

        // System.out.println(reversesString("Hello"));
        // System.out.println(unique([2,3,4]));
    }

}
