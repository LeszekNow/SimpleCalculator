import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome in my calculator!");
        getAccessAndCalculate();

    }
    public static void getAccessAndCalculate() {
        Scanner scanner = new Scanner(System.in);
        String secretUsername = "Leszek";
        String secretPassword = "Kutodaktyl";
        String username;
        String password;
        do {
            System.out.println("Please enter your username: ");
            username = scanner.nextLine();
            System.out.println("Now enter your password: ");
            password = scanner.nextLine();
        } while (!(username.equals(secretUsername) && password.equals(secretPassword)));
        boolean anotherLoop = false;
        do {
            chooseOperationAndCalculate();
        }while(!anotherLoop);
    }

    public static void chooseOperationAndCalculate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your operation or Exit: \n1.add ( + ) \n2.subtract ( - )\n3.multiply ( * ) \n4.divide ( / ) \n5.square root ( √ ) \n6.cubic root (3^√) \n7.N-root ( n^√ ) \n8.power ( x^n )\n9.switch numeric system \n10.average \n11.median \n12.exit");
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("The result is: " + add(getNData()));
                break;
            case 2:
                System.out.println("The result is: " + subtract(getNData()));
                break;
            case 3:
                System.out.println("The result is: " + multiply(getNData()));
                break;
            case 4:
                System.out.println("The result is: " + divide(getNData()));
                break;
            case 5:
                System.out.println("The result is: " + sqrt(getDoubleNumber()));
                break;
            case 6:
                System.out.println("The result is: " + cbrt(getDoubleNumber()));
                break;
            case 7:
                System.out.println("The result is: " + nrt(getDoubleNumber(),getPowerNumber()));
                break;
            case 8:
                System.out.println("The result is: " + getPower(getDoubleNumber(), getPowerNumber()));
                break;
            case 9:
                System.out.println("Choose system: \n1. binary \n2. octal \n3. hexadecimal");
                int system = scanner.nextInt();
                switch (system) {
                    case 1:
                        System.out.println("The result is: " + getBinaryNumber(getIntNumber()));
                        break;
                    case 2:
                        System.out.println("The result is: " + getOctalNumber(getIntNumber()));
                        break;
                    case 3:
                        System.out.println("The result is: " + getHexadecimalNumber(getIntNumber()));
                        break;
                }
                break;
            case 10:
                System.out.println("The result is: " + getAverage(getNData()));
                break;
            case 11:
                System.out.println("The result is: " + getMedian(getNData()));
                break;
            case 12:
                System.exit(0);
        }
    }

    public static int add(int[]array) {
        int sum=0;
        for(int a:array){
            sum+=a;
        }
        return sum;
    }

    public static int subtract(int[]array){
        int sum=array[0];
        for(int i=1;i<array.length;i++){
            sum-=array[i];
        }
        return sum;
    }

    public static int multiply(int[]array) {
        int sum=1;
        for(int a:array){
            sum*=a;
        }
        return sum;
    }

    public static double divide(int[]array) {
        double sum = array[0];
            for(int i=1;i<array.length;i++) {
                if (array[i] == 0) {
                    System.out.println("Do not divide by: 0");
                }
                sum /= array[i];
            }
        return sum;
        }

        public static double sqrt(double a){
        return Math.sqrt(a);
        }

        public static double cbrt(double a){
        if(a<0){
            System.out.println("The result will be negative, You sholdn't use negative values");
        }
        return Math.cbrt(a);
        }

        public static double nrt(double a, double n){
            if(a<0){
                System.out.println("The result will be negative, You should not use negative values");
            }
            double preResult = Math.pow(a,1/n);
            double result = Math.round(preResult);
            return result;
        }

        public static double getPower(double a, double b){
        return Math.pow(a,b);
        }

        public static String getBinaryNumber(int a){
        String binaryNumber = Integer.toBinaryString(a);
        return binaryNumber;
        }

        public static String getOctalNumber (int a){
        String octalNumber = Integer.toOctalString(a);
        return octalNumber;
        }

        public static String getHexadecimalNumber(int a){
        String hexadecimalNumber = Integer.toHexString(a);
        return hexadecimalNumber;
        }

        public static double getAverage(int[]array){
        int sum = 0;
        for(int a:array){
            sum+=a;
        }
        return sum/array.length;
        }

        public static double getMedian(int[]array){
            Arrays.sort(array);
            if(array.length%2==0){
                return (array[(array.length-1)/2]+array[(array.length/2)])/2;
            }else{
                return array[(array.length-1)/2];
            }
        }
    public static int getIntNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me your number: ");
        int a = scanner.nextInt();
        return a;
    }

    public static double getDoubleNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me your number: ");
        double a = scanner.nextDouble();
        return a;
    }

    public static double getPowerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me the power: ");
        double b = scanner.nextDouble();
        return b;
    }

    public static int[] getNData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me your numbers separated with \" \":");
        String inPut = scanner.nextLine();
        String[] inPuts = inPut.split(" ");
        int[] numbers = new int[inPuts.length];
        int number;
        for (int i = 0; i < inPuts.length; i++) {
            number = Integer.parseInt(inPuts[i]);
            numbers[i] = number;
        }
        return numbers;
        }
    }