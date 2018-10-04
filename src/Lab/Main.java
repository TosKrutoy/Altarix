package Lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер задания (A1,B2.1 B3  или любые другие)");
        s = input.next();
        switch (s) {
            case "A1":
                CategoryA.task1();
                break;

            case "A2":
                CategoryA.task2();
                break;

            case "A3":
                CategoryA.task3();
                break;
            case "A4":
                CategoryA.task4();
                break;
            case "A5":
                CategoryA.task5();
                break;
            case "B1":
                CategoryB.task1();
                break;
            case "B2.1":
                CategoryB.task2_1();
                break;
            case "B2.2":
                CategoryB.task2_2();
                break;
            case "B3":
                CategoryB.task3();
                break;
            default: System.out.println("Нет такого задания");
                break;
        }
        }


    }




