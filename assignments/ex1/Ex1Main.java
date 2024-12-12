package assignments.ex1;
import javax.swing.*;
import java.util.Scanner;


/**
 * Intro2CS, assignments.ex1.Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (true) {
            System.out.println();
            System.out.println("assignments.ex1.Ex1 class solution:");
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();


            if (num1.equals(quit)) {
                System.out.println("Quitting the program...");
                break;
            }

            boolean isValidNum1 = Ex1.isNumber(num1);
            int valueNum1 = Ex1.number2Int(num1);
            if (isValidNum1 && valueNum1 != -1) {
                System.out.println("num1= " + num1 + " is number: true , value: " + valueNum1);

                while (true) {
                    sc.nextLine();

                    System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.nextLine();

                    if (num2.equals(quit)) {
                        System.out.println("Quitting the program...");
                        break;
                    }


                    boolean isValidNum2 = Ex1.isNumber(num2);
                    int valueNum2 = Ex1.number2Int(num2);

                    if (isValidNum2 && valueNum2 != -1) {
                        System.out.println("num2= " + num2 + " is number: true , value: " + valueNum2);

                        System.out.print("Enter a base for output (a number [2,16]): ");
                        int base = sc.nextInt();

                        if (base < 2 || base > 16) {
                            System.out.println("ERR: Invalid base! Base must be between 2 and 16.");
                            continue;
                        }

                        int sum = valueNum1 + valueNum2;
                        String sumInBase = Ex1.int2Number(sum, base);
                        System.out.println(num1 + " + " + num2 + " = " + sumInBase);

                        int product = valueNum1 * valueNum2;
                        String productInBase = Ex1.int2Number(product, base);
                        System.out.println(num1 + " * " + num2 + " = " + productInBase);

                        String[] numbers = {num1, num2, sumInBase, productInBase};
                        int maxIndex = Ex1.maxIndex(numbers);
                        String maxNumber = numbers[maxIndex];
                        System.out.println("Max number over [" + String.join(",", numbers) + "] is: " + maxNumber);

                        break;
                    } else {
                        System.out.println("ERR: " + num2 + " is in the wrong format!");
                        System.out.println("Returning to num1...");
                        break;
                    }
                }

            } else {
                System.out.println("num1= " + num1 + " is number: false , value: -1");
                System.out.println("ERR: " + num1 + " is in the wrong format!");
            }
        }

        sc.close();
    }
}