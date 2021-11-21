// import java.util.Arrays;

public class Hello {
    // public static double rectangle(double w,double h)
    // {
    // return w * h;
    // }

    // public static int a1(int[] a)
    // {
    // if(a.length % 2 == 0 || a.length == 0 )
    // {
    // return 0;
    // }
    // int midIndex = ((a.length)/2);
    // int midValue = a[midIndex];

    // for (int i = 0; i < a.length; i++) {
    // if (i != midIndex && midValue >= a[i])
    // {
    // return 0;
    // }
    // }
    // return 1;
    // }

    // public static int a2(int[] a)
    // {
    // if (a == null)
    // {
    // return 0;
    // }

    // int SumEven = 0;
    // int SumOdd = 0;

    // for (int i = 0; i < a.length; i++) {
    // if (a[i]%2 == 0)
    // {
    // SumEven+=a[i];
    // }
    // else
    // {
    // SumOdd+=a[i];
    // }
    // }
    // return SumOdd-SumEven;
    // }

    // public static char[] a3(char[] a,int start,int length)
    // {
    // if (start < 0 || length < 0 || start + length > a.length)
    // {
    // return null;
    // }

    // char[] x = new char[length];

    // for (int i=start,j=0; j < length; i++,j++)
    // {
    // x[j] = a[i];
    // }
    // return x;
    // }

    // public static int a4(int a)
    // {
    // int reversed = 0;
    // while(true)
    // {
    // reversed = reversed*10 + a%10;
    // a/=10;
    // if (a == 0){
    // break;
    // }
    // }
    // return reversed;
    // }

    // public static String a5(int[] first,int[] second)
    // {
    // if (first == null || second == null)
    // {
    // return null;
    // }

    // if (first.length == 0 || second.length == 0 )
    // {
    // return null;
    // }

    // int count = 0;
    // for (int i = 0; i < first.length; i++) {
    // for (int j = 0; j < second.length; j++) {
    // if(first[i]==second[j]){
    // count = count + 1;
    // }
    // }
    // }

    // int[] x = new int[count];
    // int count_used_list = 0;
    // for (int k = 0; k < first.length; k++) {
    // for (int l = 0; l < second.length; l++) {
    // if(first[k]==second[l]){
    // x[count_used_list] = first[k];
    // count_used_list++;
    // }
    // }
    // }
    // return Arrays.toString(x);
    // }

    // public static int a6(int[]a)
    // {

    // for (int i = 0; i < a.length; i++) {
    // int RightSum = 0;
    // int LeftSum = 0;
    // for (int j = i+1; j < a.length; j++) {
    // RightSum+=a[j];
    // }
    // for (int k = 0; k < i; k++) {
    // LeftSum+=a[k];
    // }
    // if (RightSum == LeftSum) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // }

    // public static int sumdigit(int a)
    // {
    // int sum = 0;
    // while(a!=0)
    // {
    // sum += a%10;
    // a/=10;
    // }
    // return sum;
    // }

    public static void main(String[] args) {

        // char[] a = {'a','b','c'};
        // int[] a = {1, 5, 3, 1, 1, 1, 1, 1, 1};
        // int[] b = {4, 2, 6, 1};
        // Scanner in = new Scanner(System.in);

        // System.out.println("a array has the length of "+ a.length);
        // System.out.println("Result is:"+a6(a));
        // System.out.println();
        // for (int i = 0; i < a.length; i++) {
        // System.out.println(a[i]);
        // }

        // System.out.println("Hello");
        // System.out.println("My Name is Golf!");
        // int x =ThreadLocalRandom.current().nextInt();
        // if (x>10) {
        // System.out.println("YES"+ x);
        // } else {
        // System.out.println("No"+x);
        // }
        // Scanner in = new Scanner(System.in);

        // System.out.println("Enter Height (m): ");
        // double h = in.nextDouble();
        // System.out.println("Enter Weight (kg): ");
        // double w = in.nextDouble();
        // in.close();
        // System.out.println(BodyMassIndex.bmi(h,w));
    }

}
