// import static java.util.Arrays.asList;

import java.util.Arrays;
// import java.util.Collections;

// import java.util.Arrays;

// import static java.util.Arrays.toString;

// import java.util.Arrays;

/**
 * Practice
 */
public class Practice {

    // adjacentSum
    // 1. Write a function named largestAdjacentSum that iterates through an array
    // computing the sum of adjacent elements and returning the largest such sum.
    // You may assume that the array has at least 2 elements.
    // If you are writing in Java or C#, the function signature is int
    // largestAdjacentSum(int[ ] a)
    // If you are writing in C or C++, the function signature is
    // int largestAdjacentSum(int a[ ], int len) where len is the number of elements
    // in a
    // Examples:
    // if a is
    // return
    // 7 because 3+4 is larger than either 1+2 or 2+3 6 because 18-12 is larger than
    // -12+9 or 9-10
    // {1, 2, 3, 4}
    // {18, -12, 9, -10}
    // {1,1,1,1,1,1,1,1,1} 2 because all adjacent pairs sum to 2 {1,1,1,1,1,2,1,1,1}
    // 3 because 1+2 or 2+1 is the max sum of adjacent pairs

    public static int largestAdjacentSum(int[] a) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] + a[i + 1] > max) {
                max = a[i] + a[i + 1];
            }

        }
        return max;
    }

    // 2. The number 198 has the property that 198 = 11 + 99 + 88, i.e., if each of
    // its digits is concatenated twice and then summed, the result will be the
    // original number. It turns out that 198 is the only number with this property.
    // However, the property can be generalized so that each digit is concatenated n
    // times and then summed. For example, 2997 = 222+999+999+777 and here each
    // digit is concatenated three times. Write a function named checkContenatedSum
    // that tests if a number has this generalized property.
    // The signature of the function is
    // int checkConcatenatedSum(int n, int catlen) where n is the number and catlen
    // is the number of times to concatenate each digit before summing.
    // The function returns 1 if n is equal to the sum of each of its digits
    // contenated catlen times. Otherwise, it returns 0. You may assume that n and
    // catlen are greater than zero
    // Hint: Use integer and modulo 10 arithmetic to sequence through the digits of
    // the argument. Examples:
    // if n is
    // and catlen is return
    // reason
    // because198==11+99+88
    // because 198 != 111 + 999 + 888
    // because 2997 == 222 + 999 + 999 + 777 because2997!=22+99+99+77
    // because 13332 = 1111 + 3333 + 3333 + 3333 + 2222 because 9 == 9
    // 198 2 198 3 2997 3 2997 2 13332 4 9 1
    // 1 0 1 0 1 1

    // Redo What out whe nt oset variable inside the loop and outside loop
    public static int checkConcatenatedSum(int n, int catlen) {
        int StartInt = n;
        int digits = 0;
        int sumvalue = 0;
        // int Output = 0;
        while (n != 0) {
            int value = 0;
            digits = n % 10;
            for (int i = 0; i < catlen; i++) {
                value = value * 10 + digits;
            }
            sumvalue += value;
            n /= 10;
            // System.out.println(sumvalue);
        }
        return (StartInt == sumvalue) ? 1 : 0;
    }

    // 3
    // 3. Define an m-n sequenced array to be an array that contains one or more
    // occurrences of all the integers between m and n inclusive. Furthermore, the
    // array must be in ascending order and contain only those integers. For
    // example, {2, 2, 3, 4, 4, 4, 5} is a 2-5 sequenced array. The array {2, 2, 3,
    // 5, 5, 5} is not a 2-5 sequenced array because it is missing a 4. The array
    // {0, 2, 2, 3, 3} is not a 2-3 sequenced array because the 0 is out of range.
    // And {1,1, 3, 2, 2, 4} is not a 1-4 sequenced array because it is not in
    // ascending order.
    // Write a method named isSequencedArray that returns 1 if its argument is a m-n
    // sequenced array, otherwise it returns 0.
    // If you are writing in Java or C# the function signature is int
    // isSequencedArray(int[ ] a, int m, int n)
    // If you are writing in C or C++ the function signature is
    // int isSequencedArray(int a[ ], int len, You may assume that m<=n Examples
    // if a is
    // int m, int n) where len is the number of elements in the array a.

    public static int isSequencedArray(int[] a, int m, int n) {
        if (a[0] != m || a[a.length - 1] != n) {
            return 0;
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (Math.abs(a[i] - a[i + 1]) > 1) {
                return 0;
            }
        }
        return 1;
    }

    // 1. New Problem Set
    // 1. Write a function named largestPrimeFactor that will return the largest
    // prime factor of a number. If the number is <=1 it should return 0. Recall
    // that a prime number is a number > 1 that is divisible only by 1 and itself,
    // e.g., 13 is prime but 14 is not.
    // The signature of the function is int largestPrimeFactor(int n) Examples:
    // if n is return
    // 10 5 6936 17 1 0
    // because
    // because the prime factors of 10 are 2 and 5 and 5 is the largest one.
    // because the distinct prime factors of 6936 are 2, 3 and 17 and 17 is the
    // largest because n must be greater than 1

    public static int largestPrimeFactor(int n) {
        int count = 0;
        int run = 0;
        int max = Integer.MIN_VALUE;
        if (n <= 1) {
            return 0;
        }

        while (n != 1) {
            if (n % 2 == 0 && 2 > max) {
                n /= 2;
                max = 2;
                count++;
            }
            for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
                if ((n % i == 0) && i > max) {
                    n /= i;
                    max = i;
                    run++;
                }
            }
            if ((run == 0) && n > max) {
                max = n;
            }
            // System.out.println(n);
            System.out.println(count + run);
            break;
        }
        return max;

    }

    public static int[] encodeNumber(int n) {
        int count = 0;
        int run = 0;
        int new_n = n;
        if (n <= 1) {
            return null;
        }
        while (true) {
            if (n % 2 == 0) {
                n /= 2;

                count++;
            } else {
                for (int i = 3; i <= n; i = i + 2) {
                    if ((n % i == 0)) {
                        n /= i;
                        run++;

                        i = i - 2;

                    }
                }
                break;
            }
        }
        System.out.print("index ");
        System.out.println(count + run);
        int[] x = new int[count + run];
        int ind = 0;
        while (true) {
            if (new_n % 2 == 0) {
                new_n /= 2;
                x[ind] = 2;
                ind++;
            } else {
                for (int i = 3; i <= new_n; i = i + 2) {
                    if ((new_n % i == 0)) {
                        new_n /= i;
                        x[ind] = i;
                        ind++;
                        System.out.println(i);

                        i = i - 2;

                    }
                }
                break;
            }
        }
        return x;

    }

    // 3. Consider a simple pattern matching language that matches arrays of
    // integers. A pattern is an array of integers. An array matches a pattern if it
    // contains sequences of the pattern elements in the same order as they appear
    // in the pattern. So for example, the array {1, 1, 1, 2, 2, 1, 1, 3} matches
    // the pattern {1, 2, 1, 3} as follows:
    // {1, 1, 1, 2, 2, 1, 1, 3} {1, 2, 1, 3} (first 1 of pattern matches three 1s in
    // array)
    // {1, 1, 1, 2, 2, 1, 1, 3} {1, 2, 1, 3} (next element of pattern matches two 2s
    // in array) {1, 1, 1, 2, 2, 1, 1, 3} {1, 2, 1, 3} (next element of pattern
    // matches two 1s in array) {1, 1, 1, 2, 2, 1, 1, 3} {1, 2, 1, 3} (last element
    // of pattern matches one 3 in array)
    // The pattern must be completely matched, i.e. the last element of the array
    // must be matched by the last element of the pattern.
    // Here is an incomplete function that does this pattern matching. It returns 1
    // if the pattern matches the array, otherwise it returns 0.

    static int matchPattern(int[] a, int len, int[] pattern, int patternLen) {

        int i = 0;
        int k = 0;
        int matches = 0;
        for (i = 0; i < len; i++) {
            if (a[i] == pattern[k]) {
                matches++;
            } else if (matches == 0 || k == patternLen - 1) {
                return 0;
            } else {
                k++;
                i--;

            }

        }
        if (i == len && k == patternLen - 1)
            return 1;
        else
            return 0;
    }

    public static void doIntegerBasedRounding(int[] a, int n) {
        if (n <= 0) {
            return;
        }
        // look for remainder if more than n/2 for even/ (n+1)/2 for odd
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                int rem = a[i] % n;
                if (n % 2 == 0) {
                    a[i] = a[i] - rem + (rem >= n / 2 ? n : 0);
                } else {
                    a[i] = a[i] - rem + (rem >= (n + 1) / 2 ? n : 0);
                }
            } else {
                a[i] = a[i];
            }
        }
    }

    public static int isCubePowerful(int n) {
        if (n <= 0)
            return 0;
        int value = 0;
        int new_value = n;
        while (n != 0) {
            int digit;
            digit = n % 10;
            value += Math.pow(digit, 3);
            n /= 10;
            // System.out.println(value);
            // System.out.println(n);
        }
        return (new_value == value) ? 1 : 0;
    }

    public static int decodeArray(int[] a) {
        int sign = 1;
        int value = 0;
        if (a[0] < 0) {
            sign = -1;
        }
        for (int i = 0; i < a.length - 1; i++) {
            value = value * 10 + Math.abs(a[i] - a[i + 1]);
        }

        // System.out.println(value);
        return (a[0] < 0) ? sign * value : value;
    }

    // private static int isZeroPlentiful(int[] a) {
    // int countzero = 0;
    // int totalcount = 0;
    // for (int i = 0; i < a.length; i++) {
    // if (a[i] == 0) {
    // countzero++;
    // if (countzero > 4) {
    // totalcount++;
    // countzero = 0;
    // }
    // } else {
    // if (countzero >= 0 && countzero < 4) {
    // countzero = 0;
    // } else {
    // totalcount++;
    // countzero = 0;
    // }
    // }
    // // System.out.println(countzero);
    // }
    // return totalcount;
    // }

    // private static int isDigitIncreasing(int n) {
    // int num = n;
    // int countdigit = 0;
    // int digit;
    // // int value = 0;
    // while (n != 0) {
    // digit = n % 10;
    // n /= 10;
    // countdigit++;
    // }

    // for (int i = 0; i < 10; i++) {
    // int value = 0;
    // int totalsum = 0;
    // for (int j = 0; j < countdigit; j++) {
    // value = value * 10 + i;
    // totalsum += value;
    // }
    // if (totalsum == num)
    // return 1;
    // }
    // return 0;
    // }

    public static int decodeArraynew(int[] a) {
        int sign = (a[0] == -1) ? -1 : 1;
        // int size =0;
        int value = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 1) {
                int zero = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (a[j] == 0) {
                        zero++;
                    } else {
                        break;
                    }
                }
                // System.out.println(zero);
                value = value * 10 + zero;
            }
        }
        return (a[0] == -1) ? sign * value : value;
    }

    public static int decodeArrayallnew(int[] a) {
        int sign = (a[0] == -1) ? -1 : 1;
        int value_tanin = 0;
        for (int i = 0; i < a.length; i++) {
            int tanin = 0;
            if (a[i] == 1) {
                for (int j = i; j >= 1; j--) {
                    if (a[j - 1] == 0) {
                        tanin++;
                    } else {
                        break;
                    }
                }
            } else {
                continue;
            }
            value_tanin = value_tanin * 10 + tanin;
        }
        return (a[0] == -1) ? sign * value_tanin : value_tanin;
    }

    public static int isOnionArray(int[] a) {
        int x = 1;
        for (int j = 0, k = a.length - 1; j < a.length && k > 0; j++, k--) {
            if ((j + k == a.length - 1) && (j != k) && a[j] + a[k] > 10) {
                x = 0;
            }
        }
        return x;
    }

    public static int isPrimeHappy(int n) {
        int value = 0;
        int compare_n = n;
        if (n == 2)
            return 0;
        for (int i = 2; i < n; i++) {
            int prime = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = 1;
                }
            }

            if (prime == 0) {
                value = value + i;
                System.out.println(i);
            }
            prime = 0;
        }
        System.out.println(value);
        return (value % compare_n == 0) ? 1 : 0;
    }

    public static int[] encodeArrayReversed(int n) {
        int digit = 0;
        int countdigit = 0;
        int new_n = n;
        int n_for_size = n;
        // if (n < 0) {
        // countdigit = 1;
        // } else if (n < 0) {
        int n_for_negative = n;

        if (n_for_negative < 0) {
            new_n = new_n * (-1);
        }

        // }
        while (n != 0) {
            digit = n % 10;
            n /= 10;
            countdigit++;
        }

        int[] x_noreverse = new int[countdigit];
        int countint = 0;
        while (new_n != 0) {
            digit = new_n % 10;
            x_noreverse[countint] = digit;
            System.out.println(new_n);
            new_n /= 10;
            countint++;
        }

        for (int i = 0; i < x_noreverse.length; i++) {

            System.out.println("=============");
            System.out.println(x_noreverse[i]);

        }

        int[] x_reversed = new int[x_noreverse.length];

        for (int i = x_noreverse.length - 1, j = 0; i >= 0; i--, j++) {
            x_reversed[j] = x_noreverse[i];
            System.out.println("i" + x_noreverse[i]);
            System.out.println("j" + j);
        }

        int[] x = new int[x_reversed.length];

        for (int i = 0; i < x_reversed.length; i++) {
            if (i == 0) {
                x[i] = x_reversed[i];
            } else {
                x[i] = Math.abs(x_reversed[i]);
            }
        }

        System.out.println(Arrays.toString(x));

        System.out.println(Arrays.toString(x));
        // int countintnew = 0;
        int size_array = 0;
        // int neg;
        int count_zero = 0;
        int is_neg = 0;
        if (n_for_size < 0) {
            is_neg++;

        }

        for (int m = 0; m < x.length; m++) {
            if (x[m] == 0) {
                count_zero++;
            }

        }

        for (int m = 0; m < x.length; m++) {
            if (x[m] != 0) {
                size_array = size_array + 1 + Math.abs(x[m]);
            }

        }

        int size_is_real = size_array + is_neg + count_zero;
        System.out.println(size_is_real);

        int[] new_thanin = new int[size_is_real];
        int aa = 0;
        int sum_thanin = 0;
        for (int i = 0; i < x.length; i++) {
            if (i == 0) {
                aa = 0;
            } else {
                aa = sum_thanin + 1 * (i);
            }
            for (int j = aa; j <= aa + x[i]; j++) {
                if (j == aa + x[i]) {
                    new_thanin[j] = 1;
                    sum_thanin = sum_thanin + x[i];
                } else {
                    new_thanin[j] = 0;
                }

            }
        }

        int[] last_thanin = new int[new_thanin.length];

        if (n_for_negative < 0) {
            for (int i = 0; i < last_thanin.length; i++) {
                if (i == 0) {
                    last_thanin[i] = -1;
                } else {
                    last_thanin[i] = new_thanin[i - 1];
                }

            }
            return last_thanin;
        }

        return new_thanin;

    }

    // Redo
    public static int isSystematicallyIncreasing(int[] a) {
        int check = 1;

        if (((a[a.length - 1]) * (a[a.length - 1]) + (a[a.length - 1])) / 2 != a.length) {
            check = 0;
        }

        // if (a.length < 1) {
        // check = 0;
        // } else if (a.length == 1) {
        // if (a[0] != 1) {
        // check = 0;
        // }
        // } else {
        // if (a[1] != 1) {
        // check = 0;
        // }
        // }

        int numdiff = 0;
        int maxint = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] == 1) {
                maxint++;
                continue;
            } else if (a[i + 1] - a[i] < 0) {
                numdiff++;
                if (a[i + 1] + numdiff == a[i]) {
                    continue;
                } else {
                    check = 0;
                }
            } else {

            }
        }
        return check;
    }

    public static int isFactorialPrime(int n) {

        boolean prime = true;
        boolean factor = false;
        int num = n;

        for (int i = 2; i < num; i++) {
            if (n % i == 0) {
                prime = false;
            }
        }

        int factorial = 1;
        int minusfactorial;
        for (int i = 1; i < num; i++) {
            factorial = factorial * i;
            minusfactorial = factorial + 1;
            if (minusfactorial == num) {
                factor = true;
                break;
            }
        }
        return (prime && factor == true) ? 1 : 0;
    }

    public static int largestDifferenceOfEvens(int[] a) {
        int counteven = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                counteven++;
            }
        }

        int[] even = new int[counteven];
        if (counteven < 2) {
            return -1;
        } else {
            int index = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 == 0) {
                    even[index] = a[i];
                    index++;
                }

            }

            for (int i = 0; i < even.length; i++) {
                if (even[i] > max) {
                    max = even[i];
                } else if (even[i] < min) {
                    min = even[i];
                }
            }
            // Naive way
            // for (int i = 0; i < even.length; i++) {
            // for (int j = i+1; j < even.length; j++) {
            // if(a[i]-a[j] > max){
            // max = a[i]-a[j];
            // }
            // }
            // }
            // System.out.println(Arrays.toString(even));
            // System.out.println(max);
        }
        return max - min;
    }

    public static int largestDifferenceOfEvensNew(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int counteven = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                counteven++;
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }
        }
        if (counteven < 2) {
            return -1;
        } else {
            return max - min;
        }
    }

    // watch out for starting index
    private static int isHodder(int n) {

        boolean prime = true;
        boolean hodder = false;
        int num = n;
        int hoddernum = 0;
        // int power;
        int index = 2;

        if (n < 2) {
            prime = false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                prime = false;
            }
            // power = (int) Math.pow(2, index);
            hoddernum = ((int) Math.pow(2, index) - 1);
            if (num == hoddernum) {
                hodder = true;
            }
            index++;
            // System.out.println(hoddernum);
        }
        System.out.printf("%b-%b-%d-", prime, hodder, num);
        return (prime && hodder == true) ? 1 : 0;
    }

    public static int areAnagrams(char[] a1, char[] a2) {

        char[] first = a1;
        char[] second = a2;
        int x = 1;
        if (a1.length != a2.length) {
            x = 0;
        }
        // sort first
        int n = first.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (first[j] > first[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = first[j];
                    first[j] = first[j + 1];
                    first[j + 1] = (char) temp;
                }
        }
        System.out.println(Arrays.toString(first));
        // sort second
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (second[j] > second[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = second[j];
                    second[j] = second[j + 1];
                    second[j + 1] = (char) temp;
                }
        }
        System.out.println(Arrays.toString(second));

        for (int i = 0, j = 0; i < second.length; i++, j++) {
            if (first[i] != second[j]) {
                x = 0;
            }
        }
        return x;
    }

    // 1,1,2,3,5,8,13,21,34,...
    public static int closestFibonacci(int n) {
        int num = n;
        int num1 = 0, num2 = 1;
        int sumOfPrevTwo = 0;
        int count = 0;
        if (n < 1)
            return 0;
        if (n < 2)
            return 1;
        // create array of fibonacci
        for (int i = 0; i < num; i++) {
            if (sumOfPrevTwo < num) {
                sumOfPrevTwo = num1 + num2;
                num1 = num2;
                num2 = sumOfPrevTwo;
                count++;

            } else if (sumOfPrevTwo >= num) {
                break;
            } else {
                break;
            }
            // System.out.println(sumOfPrevTwo);
        }
        int[] x = new int[count];
        // get last element
        int index = 0;
        int sumOfPrevTwonew = 0;
        int num1new = 0, num2new = 1;
        for (int i = 0; i < num; i++) {
            if (sumOfPrevTwonew < num) {
                sumOfPrevTwonew = num1new + num2new;
                num1new = num2new;
                num2new = sumOfPrevTwonew;
                x[index] = sumOfPrevTwonew;
                index++;
            } else if (sumOfPrevTwonew >= num) {
                break;
            } else {
                break;
            }

        }
        // System.out.println(Arrays.toString(x));
        return x[x.length - 2];
    }

    public static int closestFibonaccinew(int n) {
        int first = 0, second = 1;
        int third = 0;

        if (n < 1)
            return 0;
        while (third < n) {
            first = second;
            second = third;
            third = first + second;
        }
        return (third < n) ? third : second;
    }

    public static int isVesuvian(int n) {
        // int num = n;
        int vesuvian = 0;
        // int dup = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i * i + j * j == n) {
                    vesuvian++;

                }
            }
        }
        System.out.println(vesuvian);
        return (vesuvian > 2) ? 1 : 0;
        // return (vesuvian) ? 1 : 0;
    }

    public static int isVesuviannew(int n) {
        int a = 0;
        int vesurian = 0;
        for (int i = 0; i < n; i++) {
            a = n - (i * i);
            if (((int) Math.sqrt(a) * (int) Math.sqrt(a)) == a) {
                vesurian++;
            }
            // System.out.println(a);
        }
        return (vesurian > 2) ? 1 : 0;
    }

    public static int isOneBalanced(int[] a) {
        // check if 1 equal to non-1
        boolean balance = true;
        int countone = 0;
        int countnonone = 0;

        if (a.length == 0) {
            return 1;
        }
        ;
        // count one and non-one
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                countone++;
            } else {
                countnonone++;
            }
        }

        int startnonone = 0;
        int startone = 0;

        // if non-one and one are not equal return 0 else 1
        if (countone != countnonone) {
            balance = false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 1 && startnonone == 0) {
                    continue;
                } else if (a[i] != 1 && startone == 0) {
                    startnonone++;
                } else if (a[i] == 1 && startnonone != 0) {
                    startone++;
                } else if (a[i] != 1 && startone > 0) {
                    balance = false;
                    break;
                }
                // System.out.printf("startone: %d startnonone %d", startone, startnonone);
                // System.out.println(" ");
            }

        }
        return (balance == true) ? 1 : 0;
    }

    public static int isOneBalancednew(int[] a) {

        int countone = 0;
        int countnoone = 0;
        boolean startone = false;
        boolean endone = false;

        if (a.length == 0)
            return 0;

        for (int num : a) {
            if (num == 1) {
                if (startone) {
                    endone = true;
                }
                countone++;
            } else {
                if (endone) {
                    return 0;
                }
                startone = true;
                countnoone++;
            }
        }

        if (countone != countnoone) {
            return 0;
        }

        return 1;
        // return (balance == true) ? 1 : 0;

    }

    public static int isFibonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 0;
        boolean fibo = false;

        if (n < 1)
            return 0;
        for (int i = 0; i < n; i++) {

            first = second;
            second = third;
            third = first + second;

            if (n == third) {
                fibo = true;
                break;
            }
        }
        return (fibo == true) ? 1 : 0;
    }

    public static int isTriangular(int n) {
        // watch for ending index!
        // summation = (n*(n-1))/2
        int num = n;
        boolean triangle = false;
        for (int i = 0; i <= n; i++) {
            if (((i * (i - 1)) / 2) == num) {
                triangle = true;
                break;
            }
        }
        return (triangle == true) ? 1 : 0;
    }

    public static int isMercurial(int[] n) {
        int[] arrayNum = n;
        boolean findone = false;
        boolean findthree = false;

        for (int num : arrayNum) {
            if (num == 1) {
                if (findthree)
                    return 0;
                findone = true;
            } else if (num == 3 && findone == true) {
                findthree = true;
            }
        }
        return 1;
    }

    public static int is235Array(int[] a) {
        int divtwo = 0;
        int divthree = 0;
        int divfive = 0;
        int divnone = 0;
        for (int num : a) {
            if (num % 2 == 0) {
                divtwo++;
            }
            if (num % 3 == 0) {
                divthree++;
            }
            if (num % 5 == 0) {
                divfive++;
            }
            if ((num % 2 != 0) & (num % 3 != 0) & (num % 5 != 0)) {
                divnone++;
            }
        }
        return (divtwo + divthree + divfive + divnone == a.length) ? 1 : 0;
    }

    public static int[] computeHMS(int seconds) {

        int hour, minute;

        hour = seconds / 3600;
        minute = ((seconds - (hour * 3600)) / 60);
        seconds = ((seconds - (hour * 3600)) - (minute * 60));

        int[] time = new int[] { hour, minute, seconds };

        return time;
    }

    // watch out for <,<= and ending condition index
    public static int isMartian(int[] a) {
        int countOne = 0;
        int countTwo = 0;
        int result = 1;
        for (int i = 0; i < a.length && result == 1; i++) {
            if (a[i] == 1) {
                countOne++;
            } else if (a[i] == 2) {
                countTwo++;
            }
            // run this only before the end -1 of the array
            if (i < a.length - 1) {
                if (a[i] == a[i + 1]) {
                    result = 0;
                    break;
                }
            }
        }

        if (countOne <= countTwo) {
            result = 0;
        }
        return result;
    }

    public static int isPairedN(int[] a, int n) {
        int result = 0;
        for (int i = 0; i < a.length - 1 && result == 0; i++) {
            for (int j = 0; j < a.length; j++) {
                // System.out.println(j);
                if (a[i] + a[j] == n && i + j == n) {
                    result = 1;
                    break;

                }
            }
            // System.out.println(i);

            // System.out.println("-----");
        }
        return result;
    }

    public static int isNPrimeable(int[] a, int n) {
        int prime = 1;
        int CONST = n;
        int number;
        if (a.length == 0) {
            prime = 1;
        }

        for (int num : a) {
            for (int j = 2; j < num; j++) {
                number = num + CONST;
                if (number % j == 0) {
                    prime = 0;
                    break;
                }
            }
        }
        return prime;
    }

    public static int is121Array(int[] a) {
        int countOneStart = 0;
        int countOneEnd = 0;
        int countTwo = 0;
        boolean startTwo = false;
        int is121Array = 1;

        for (int i = 0; i < a.length; i++) {

            if (a[0] != 1 || a[a.length - 1] != 1) {
                is121Array = 0;
            }

            if (a[i] == 1 || a[i] == 2) {
                if (a[i] == 1 && startTwo == false) {
                    countOneStart++;
                } else if (a[i] == 2 && startTwo == false) {
                    startTwo = true;
                    countTwo++;
                } else if (a[i] == 1 && startTwo == true) {
                    countOneEnd++;
                }
            } else if (a[i] != 1 && a[i] != 2) {
                is121Array = 0;
            }
        }
        if (countOneStart != countOneEnd) {
            is121Array = 0;
        }

        if (countTwo < 1) {
            is121Array = 0;
        }

        return is121Array;
    }

    public static int[] pairwiseSum(int[] a) {

        int[] array = new int[a.length / 2];
        if (a.length == 0 || a.length % 2 == 1) {
            return null;
        } else {
            for (int i = 0, j = 0; i < a.length / 2; i++, j = j + 2) {
                array[i] = a[j] + a[j + 1];
            }
        }
        return array;
    }

    // Watch out for 0 index ending have to +1
    public static int isSquare(int n) {
        int isSquare = 0;

        if (n < 0) {
            return isSquare = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            if (i * i == n) {
                isSquare = 1;
                break;
            }
        }
        return isSquare;
    }

    // even element perfect square and sum equal 8
    public static int isComplete(int[] a) {

        boolean even = false;
        boolean perfectsquare = false;
        boolean sumeight = false;

        if (a.length < 2) {
            return 0;
        }

        for (int num : a) {
            if (num % 2 == 0) {
                even = true;
                break;
            }
        }
        if (even == false)
            return 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i] + 1; j++) {
                if (j * j == a[i]) {
                    perfectsquare = true;
                    break;
                }
            }
            if (perfectsquare == true) {
                break;
            }
        }

        if (perfectsquare == true) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (a[i] + a[j] == 8) {
                        sumeight = true;
                    }
                }
            }
        } else {
            return 0;
        }

        return (even && perfectsquare && sumeight == true) ? 1 : 0;
    }

    public static int loopSum(int[] a, int n) {
        int j = 0;
        int sum = 0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                if (j >= a.length) {
                    j = 0;
                }
                sum += a[j];
                j++;
            }
        }
        return sum;
    }

    public static int allValuesTheSame(int[] a) {

        if (a.length == 0)
            return 0;
        if (a.length == 1)
            return 1;

        int value = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] != value) {
                return 0;
            }
        }
        return 1;
    }

    public static int hasNValues(int[] a, int n) {

        int[] array = a.clone();
        int countValue = 1;

        int len = array.length;

        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != 0) {
                countValue++;
            }
        }
        return (countValue == n) ? 1 : 0;
    }

    public static int hasNValuesnew(int[] a, int n) {
        if (a.length < n)
            return 0;

        int[] Uarray = new int[n];
        int index = 0;
        boolean uniqueflag;

        for (int num : a) {
            uniqueflag = false;
            for (int num2 : Uarray) {
                if (num == num2) {
                    uniqueflag = true;
                    break;
                }
            }
            // run if true -- if not match with what is in the new created array
            if (!uniqueflag) {
                if (index >= n)
                    return 0;
                Uarray[index] = num;
                index++;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(Uarray));
        return (index == n) ? 1 : 0;
    }

    public static int sameNumberOfFactors(int n1, int n2) {

        int countfactn1 = 0;
        int countfactn2 = 0;
        if (n1 < 0 || n2 < 0) {
            return -1;
        }
        if (n1 == 0 && n2 == 0) {
            return 0;
        }
        for (int i = 1; i < n1 + 1; i++) {
            if (n1 % i == 0) {
                countfactn1++;
            }
        }
        for (int i = 1; i < n2 + 1; i++) {
            if (n2 % i == 0) {
                countfactn2++;
            }
        }
        return (countfactn1 == countfactn2) ? 1 : 0;
    }

    public static double eval(double x, int[] a) {
        double valuesum = 0;
        // begin at the last element of array
        for (int index = a.length - 1; index >= 0; index--) {
            double value = 1;
            // watch out for second loop increased
            for (int i = 0; i < index; i++) {
                value *= x;
            }
            valuesum += value * a[index];
        }
        return valuesum;
    }

    public static int isAllPossibilities(int[] a) {

        int[] x = new int[a.length];
        int countsame = 0;

        if (a.length == 0) {
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            x[i] = i;
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (a[i] == x[j]) {
                    countsame++;
                    break;
                }
            }
        }

        return (countsame == a.length) ? 1 : 0;
    }

    public static int isAllPossibilitiesnew(int[] a) {
        if (a.length <= 0)
            return 0;

        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int anA : a) {
                if (anA == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return 0;
        }
        return 1;
    }

    public static int isLayered(int[] a) {

        if (a.length <= 1)
            return 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] < 0) {
                return 0;
            }
        }

        for (int i = 0; i < a.length; i++) {
            int startcount = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    startcount++;
                }
            }
            if (startcount < 2) {
                return 0;
            }
        }
        return 1;
    }

    public static int isLayerednew(int[] a) {
        if (a.length <= 1)
            return 0;

        int count = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return 0;

            if (a[i] == a[i + 1])
                count++;
            // when change number check if more than 2
            if (a[i] != a[i + 1]) {
                if (count < 2)
                    return 0;
                count = 1;
            }
        }
        return 1;
    }

    // redo
    // public static int updateMileage(int[] a, int miles) {

    // double sum = 0;
    // int j = 0;
    // while (miles != 0) {
    // for (int i = 0; i < a.length; i++) {
    // if (a[i] < 9 && miles != 0) {
    // a[i]++;
    // miles--;
    // } else if (a[i] >= 9 && miles != 0) {
    // a[i] = 0;
    // j++;
    // // break;
    // }

    // System.out.println(a[i]);
    // }
    // }
    // return (int) sum;
    // }

    public static int[] updateMileagenew(int[] a, int miles) {
        for (int i = 0; i < a.length && miles > 0; i++) {
            miles = a[i] + miles;
            if (miles > 9) {
                int tempMiles = miles % 10;
                miles /= 10;
                a[i] = tempMiles;
            } else {
                a[i] = miles;
                miles = 0;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        // int[] a = { 1, 1, 10, 4, 4, 3 };
        // int[] a = { 1, 1, 1, 1 };
        // int[] a = { 1, 1, 2, 2, 2, 2, 3 };
        // int[] b = { 1, 3 };
        // int[] c = { 0, -3, 0, -4, 0 };
        // int[] d = { 1, 1 };
        // int[] b = { 1, 2, 19, 4, 5 };
        // int[] c = { 1, 2, 3, 4, 15 };
        // int[] d = { 1, 3, 9, 8 };
        // int[] e = { 2 };
        // int[] f = {};
        // int[] g = { -2, 5, 0, 5, 12 };
        // int[] v = { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0 };
        // int[] w = { 0, 1, 1, 1, 1, 1, 0, 1 };
        // int[] w = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
        // 0, 0, 0, 0, 0, 0, 0, 1 };

        // int max = Integer.MIN_VALUE;
        // System.out.println(largestAdjacentSum());
        // System.out.println(checkConcatenatedSum(2997, 3));
        // System.out.println(isSequencedArray(a, 1, 5));
        // System.out.println(largestPrimeFactor(6936));
        // System.out.println(Arrays.toString(encodeNumber(6936)));
        // System.out.println(matchPattern(a, 7, b, 2));
        // System.out.println(Arrays.toString(doIntegerBasedRounding(c, 2)));
        // doIntegerBasedRounding(c, 3);
        // for (int i = 0; i < c.length; i++) {
        // System.out.println(c[i]);
        // }
        // System.out.println(isCubePowerful(0));
        // System.out.println(decodeArray(d));
        // System.out.println(isZeroPlentiful(v));
        // System.out.println(decodeArrayallnew(b));
        // System.out.println(isDigitIncreasing(34));
        // System.out.println(isOnionArray(b));
        // System.out.println(isOnionArray(c));
        // System.out.println(isOnionArray(d));
        // System.out.println(isOnionArray(e));
        // System.out.println(isOnionArray(f));
        // System.out.println(isOnionArray(g));
        // System.out.println(isPrimeHappy(32));
        // System.out.println(Arrays.toString(encodeArrayReversed(-2)));
        // System.out.println(isSystematicallyIncreasing(new int[] { 1 }));
        // System.out.println(isSystematicallyIncreasing(new int[] { 1, 2, 1, 2, 3 }));
        // System.out.println(isSystematicallyIncreasing(new int[] { 1, 1, 2, 1, 2, 3,
        // 1, 2, 3, 4 }));
        // System.out.println(isSystematicallyIncreasing(new int[] { 1, 2, 1, 2, 1, 2
        // }));
        // System.out.println(isSystematicallyIncreasing(new int[] { 1, 2, 3, 1, 2, 1
        // }));
        // System.out.println(isSystematicallyIncreasing(new int[] { 1, 1, 2, 3 }));
        // System.out.println(largestDifferenceOfEvensNew(new int[] { 1, 2, 1, 2, 10, 4,
        // 1, 6, 4 }));
        // System.out.println(largestDifferenceOfEvens(3));
        // System.out.println(isHodder(3));
        // System.out.println(isHodder(7));
        // System.out.println(isHodder(5));
        // System.out.println(isFactorialPrime(721));

        // System.out.println(areAnagrams(new char[] { 's', 'i', 't' }, new char[] {
        // 'i', 's', 't' }));
        // System.out.println(areAnagrams(new char[] { 'b', 'i', 'g' }, new char[] {
        // 'i', 's', 't' }));
        // System.out.println(areAnagrams(new char[] { 'p', 'o', 'o', 'l' }, new char[]
        // { 'p', 'o', 'l', 'l' }));

        // System.out.println(isFactorialPrime(721));
        // System.out.println(isFactorialPrime(721));
        // System.out.println(closestFibonacci(2));
        // System.out.println("---");
        // System.out.println(closestFibonaccinew(2));

        // areAnagrams(char [ ] a1, char [ ] a2)
        // System.out.println(isVesuvian(98));
        // System.out.println(isVesuviannew(65));
        // System.out.println(isOneBalancednew(new int[] { 1, 1, 1, 2, 3, -18, 45, 1
        // }));
        // System.out.println(isOneBalancednew(new int[] { 1, 1, 1, 2, 3, -18, 45, 1, 0
        // }));
        // System.out.println(isOneBalancednew(new int[] { 1, 1, 2, 3, 1, -18, 26, 1
        // }));
        // System.out.println(isOneBalancednew(new int[] {}));
        // System.out.println(isOneBalancednew(new int[] { 3, 4, 1, 1 }));
        // System.out.println(isOneBalancednew(new int[] { 1, 1, 3, 4 }));
        // System.out.println(isOneBalancednew(new int[] { 3, 3, 3, 3, 3, 3 }));
        // System.out.println(isOneBalancednew(new int[] { 1, 1, 1, 1, 1, 1 }));
        // System.out.println(isFibonacci(10));
        // System.out.println(isFibonacci(12));
        // System.out.println(isFibonacci(13));
        // System.out.println(isFibonacci(34));
        // System.out.println(isFibonacci(-50));
        // System.out.println(isTriangular(3));
        // System.out.println(isTriangular(6));
        // System.out.println(isTriangular(10));
        // System.out.println(isTriangular(13));
        // System.out.println(isTriangular(34));
        // System.out.println(isTriangular(-50));
        // System.out.println(isMercurial(new int[] { 1, 2, 10, 3, 15, 1, 2, 2 }));
        // System.out.println(isMercurial(new int[] { 5, 2, 10, 3, 15, 1, 2, 2 }));
        // System.out.println(isMercurial(new int[] { 1, 2, 10, 3, 15, 16, 2, 2 }));
        // System.out.println(isMercurial(new int[] { 3, 2, 18, 1, 0, 3, -11, 1, 3 }));
        // System.out.println(isMercurial(new int[] { 2, 3, 1, 1, 18 }));
        // System.out.println(isMercurial(new int[] { 8, 2, 1, 1, 18, 3, 5 }));
        // System.out.println(isMercurial(new int[] { 3, 3, 3, 3, 3, 3 }));
        // System.out.println(isMercurial(new int[] { 1 }));
        // System.out.println(isMercurial(new int[] {}));

        // System.out.println(is235Array(new int[] { 2, 3, 5, 7, 11 }));
        // System.out.println(is235Array(new int[] { 2, 3, 6, 7, 11 }));
        // System.out.println(is235Array(new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
        // System.out.println(is235Array(new int[] { 2, 4, 8, 16, 32 }));
        // System.out.println(is235Array(new int[] { 3, 9, 27, 7, 1, 1, 1, 1, 1 }));
        // System.out.println(is235Array(new int[] { 7, 11, 77, 49 }));
        // System.out.println(is235Array(new int[] { 2 }));
        // System.out.println(is235Array(new int[] {}));
        // System.out.println(is235Array(new int[] { 7, 2, 7, 2, 7, 2, 7, 2, 3, 7, 7
        // }));

        // System.out.println(Arrays.toString(computeHMS(3735)));
        // System.out.println(Arrays.toString(computeHMS(380)));
        // System.out.println(Arrays.toString(computeHMS(3650)));
        // System.out.println(Arrays.toString(computeHMS(3735)));
        // System.out.println(Arrays.toString(computeHMS(380)));
        // System.out.println(Arrays.toString(computeHMS(3650)));

        // System.out.println(isMartian(new int[] { 1, 3 }));
        // System.out.println(isMartian(new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 1 }));
        // System.out.println(isMartian(new int[] { 1, 3, 2 }));
        // System.out.println(isMartian(new int[] { 1, 3, 2, 2, 1, 5, 1, 5 }));
        // System.out.println(isMartian(new int[] { 1, 2, -18, -18, 1, 2 }));
        // System.out.println(isMartian(new int[] {}));
        // System.out.println(isMartian(new int[] { 1 }));
        // System.out.println(isMartian(new int[] { 2 }));

        // System.out.println(isPairedN(new int[] { 1, 4, 1, 4, 5, 6 }, 5));
        // System.out.println(isPairedN(new int[] { 1, 4, 1, 4, 5, 6 }, 6));
        // System.out.println(isPairedN(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 6));
        // System.out.println(isPairedN(new int[] { 1, 4, 1 }, 5));
        // System.out.println(isPairedN(new int[] { 8, 8, 8, 8, 7, 7, 7 }, 15));
        // System.out.println(isPairedN(new int[] { 8, -8, 8, 8, 7, 7, -7 }, -15));
        // System.out.println(isPairedN(new int[] { 3 }, 3));
        // System.out.println(isPairedN(new int[] {}, 0));

        // System.out.println(isNPrimeable(new int[] { 5, 15, 27 }, 2));
        // System.out.println(isNPrimeable(new int[] { 5, 15, 27 }, 3));
        // System.out.println(isNPrimeable(new int[] { 5, 15, 26 }, 2));
        // System.out.println(isNPrimeable(new int[] { 1, 1, 1, 1, 1, 1, 1 }, 4));
        // System.out.println(isNPrimeable(new int[] {}, 2));

        // System.out.println(is121Array(new int[] { 1, 2, 1 }));
        // System.out.println(is121Array(new int[] { 1, 1, 2, 2, 2, 1, 1 }));
        // System.out.println(is121Array(new int[] { 1, 1, 2, 2, 2, 1, 1, 1 }));
        // System.out.println(is121Array(new int[] { 1, 1, 1, 2, 2, 2, 1, 1 }));
        // System.out.println(is121Array(new int[] { 1, 1, 1, 2, 2, 2, 1, 1, 1, 3 }));
        // System.out.println(is121Array(new int[] { 1, 1, 1, 1, 1, 1 }));
        // System.out.println(is121Array(new int[] { 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1
        // }));
        // System.out.println(is121Array(new int[] { 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2
        // }));
        // System.out.println(is121Array(new int[] { 2, 2, 2 }));

        // System.out.println(Arrays.toString(pairwiseSum(new int[] { 2, 1, 18, -5 })));
        // System.out.println(Arrays.toString(pairwiseSum(new int[] { 2, 1, 18, -5, -5,
        // -15, 0, 0, 1, -1 })));
        // System.out.println(Arrays.toString(pairwiseSum(new int[] { 2, 1, 18 })));
        // System.out.println(Arrays.toString((pairwiseSum(new int[] {}))));

        // System.out.println(isComplete(new int[] { 36, -28 }));
        // System.out.println(isComplete(new int[] { 36, 28 }));
        // System.out.println(isComplete(new int[] { 4 }));
        // System.out.println(isComplete(new int[] { 3, 4, -1, 1, 5, 6 }));
        // System.out.println(isComplete(new int[] { 3, 7, 23, 13, 107, -99, 97, 81 }));

        // System.out.println(loopSum(new int[] { 1, 2, 3 }, 2));
        // System.out.println(loopSum(new int[] { -1, 2, -1 }, 7));
        // System.out.println(loopSum(new int[] { 1, 4, 5, 6 }, 4));
        // System.out.println(loopSum(new int[] { 3 }, 10));
        // System.out.println(loopSum(new int[] {}, 2));

        // System.out.println(allValuesTheSame(new int[] { 1, 1, 1, 1 }));
        // System.out.println(allValuesTheSame(new int[] { 83, 83, 83 }));
        // System.out.println(allValuesTheSame(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        // 0 }));
        // System.out.println(allValuesTheSame(new int[] { 1, -2343456, 1, -2343456 }));
        // System.out.println(allValuesTheSame(new int[] { 0, 0, 0, 0, -1 }));
        // System.out.println(allValuesTheSame(new int[] { 432123456 }));
        // System.out.println(allValuesTheSame(new int[] { -432123456 }));
        // System.out.println(allValuesTheSame(new int[] {}));

        // System.out.println(hasNValuesnew(new int[] { 1, 2, 2, 1 }, 2));
        // System.out.println(hasNValuesnew(new int[] { 1, 1, 1, 8, 1, 1, 1, 3, 3 },
        // 3));
        // System.out.println(hasNValuesnew(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
        // 10));
        // System.out.println(hasNValuesnew(new int[] { 1, 2, 2, 1 }, 3));
        // System.out.println(hasNValuesnew(new int[] { 1, 1, 1, 8, 1, 1, 1, 3, 3 },
        // 2));
        // System.out.println(hasNValuesnew(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
        // 20));

        // System.out.println(sameNumberOfFactors(-6, 21));
        // System.out.println(sameNumberOfFactors(6, 21));
        // System.out.println(sameNumberOfFactors(8, 12));
        // System.out.println(sameNumberOfFactors(23, 97));
        // System.out.println(sameNumberOfFactors(0, 1));
        // System.out.println(sameNumberOfFactors(0, 0));

        // System.out.println(eval(1.0, new int[] { 0, 1, 2, 3, 4 }));
        // System.out.println(eval(3.0, new int[] { 3, 2, 1 }));
        // System.out.println(eval(2.0, new int[] { 3, -2, -1 }));
        // System.out.println(eval(-3.0, new int[] { 3, 2, 1 }));
        // System.out.println(eval(2.0, new int[] { 3, 2 }));
        // System.out.println(eval(2.0, new int[] { 4, 0, 9 }));
        // System.out.println(eval(2.0, new int[] { 10 }));
        // System.out.println(eval(10.0, new int[] { 0, 1 }));

        // System.out.println(isAllPossibilities(new int[] { 1, 2, 0, 3 }));
        // System.out.println(isAllPossibilities(new int[] { 3, 2, 1, 0 }));
        // System.out.println(isAllPossibilities(new int[] { 1, 2, 4, 3 }));
        // System.out.println(isAllPossibilities(new int[] { 0, 2, 3 }));
        // System.out.println(isAllPossibilities(new int[] { 0 }));
        // System.out.println(isAllPossibilities(new int[] {}));

        // System.out.println(isLayered(new int[] { 1, 1, 2, 2, 2, 3, 3 }));
        // System.out.println(isLayered(new int[] { 3, 3, 3, 3, 3, 3, 3 }));
        // System.out.println(isLayered(new int[] { 1, 2, 2, 2, 3, 3 }));
        // System.out.println(isLayered(new int[] { 2, 2, 2, 3, 3, 1, 1 }));
        // System.out.println(isLayered(new int[] { 2 }));
        // System.out.println(isLayered(new int[] {}));

        System.out.println(Arrays.toString(updateMileagenew(new int[] { 8, 9, 9, 5, 0 }, 1)));
        System.out.println(Arrays.toString(updateMileagenew(new int[] { 8, 9, 9, 5, 0 }, 5)));
        System.out.println(Arrays.toString(updateMileagenew(new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, 1)));
        System.out.println(Arrays.toString(updateMileagenew(new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, 12)));

    }

}