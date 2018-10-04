package Lab;

import java.util.HashMap;
import java.util.Scanner;

public class CategoryA {
    public static void task1() {
        System.out.println("Задание A1"+"\n");
        // Тип int  , так как в  примере указаны целые числа , не стал делать с double , чтобы не появлялись доп условия , так как даблы нельзя без eps проверять  на точные равенства.
        int A, B, C;
        Scanner input = new Scanner(System.in);
        // сделал для удобства , чтобы не вводить 8 переменных.
        HashMap<String, Integer> coordinate = new HashMap<String, Integer>();

        // Ввод данных
        System.out.println("Введите координаты треугольника, координаты точки А:");
        coordinate.put("A1", input.nextInt());
        coordinate.put("A2", input.nextInt());
        System.out.println("Введите координаты точки B:");
        coordinate.put("B1", input.nextInt());
        coordinate.put("B2", input.nextInt());
        System.out.println("Введите координаты точки C:");
        coordinate.put("C1", input.nextInt());
        coordinate.put("C2", input.nextInt());
        System.out.println("Введите координаты точки для проверки принадлежности треугольнику:");
        coordinate.put("D1", input.nextInt());
        coordinate.put("D2", input.nextInt());
        // вычисления условий по формуле
        A = (coordinate.get("A1") - coordinate.get("D1")) * (coordinate.get("B2") - coordinate.get("A2")) - (coordinate.get("B1") - coordinate.get("A1")) * (coordinate.get("A2") - coordinate.get("D2"));
        B = (coordinate.get("B1") - coordinate.get("D1")) * (coordinate.get("C2") - coordinate.get("B2")) - (coordinate.get("C1") - coordinate.get("B1")) * (coordinate.get("B2") - coordinate.get("D2"));
        C = (coordinate.get("C1") - coordinate.get("D1")) * (coordinate.get("A2") - coordinate.get("C2")) - (coordinate.get("A1") - coordinate.get("C1")) * (coordinate.get("C2") - coordinate.get("D2"));

       // проверка  условий
        if ((A >=0) && (B >= 0) && (C >= 0) || (A <= 0) && (B <= 0) && (C <= 0))
        {
            System.out.println("IN");

        }
        else
            {
            System.out.println("OUT");
           }
    }



    public static void task2() {

          System.out.println("Задание A2"+"\n");
        int[][] matrix = {{1,3,8}, {9,2,1}, {0,3,7}}; //заданная матрица
        //вывод результата

        System.out.println("Абсолютная величина разницы между суммами диагоналей матрицы = " +" "+Math.abs(matrix[0][0]+matrix[2][2]-matrix[0][2]-matrix[2][0]));
    }
    public static void task3() {
        System.out.println("Задание A3"+"\n");
        System.out.println("Введите количество ступенек  лестницы");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        // настроенный вывод  лестницы
        for (int i = 0; i <= N; i++)
        {
            for (int j = 0; j < N-i; j++) // цикл для вывода пробелов перед #
            {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) // цикл вывода #
            {
                System.out.print("#");
            }
            System.out.println();
        }
    }
    public static void task4() {
        int K,N,A[],counter=0;
        System.out.println("Задание A4"+"\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Введите N ");
        N = input.nextInt();
        A = new int [N];
        // ввод элементов массива
        for (int i=0;i<A.length;i++)
        {
            System.out.println("Введите " + (i + 1) + " элемент массива");
            A[i] = input.nextInt();
        }
        // вывод массива на  экран
        for (int i=0;i<A.length;i++)
        {
            System.out.print(A[i] + " ");
        }
        System.out.print("Введите число K ");
        K=input.nextInt();
        // с первого элемента массива проходим по всем остальным и проверяем на условие ,длинна -1 потому что i<j по условию
        for(int i=0;i<A.length-1;i++)
        {
            // проходим с i+1 элемента до окнца массива
            for(int j=i+1;j<A.length;j++)
            {
                // проверка на выполнение условия
                if((A[i]+A[j])%K==0)
                {
                    counter+=1;
                }
            }
        }
        System.out.println(counter);
    }
    public static void task5() {
        System.out.println("Задание A5"+"\n");
        int[][] a = {
                {1,2,3,4,5,6,7,8,9,0},
                {2,2,2,2,1,2,1,2,3,1},
                {2,7,7,8,1,1,2,1,1,0},
                {6,7,7,8,1,2,3,4,6,8}
        };
        int[][] b= {
                {1,2,1},
                {1,1,2}

        };

        for (int i = 0; i <= a.length - b.length; i++) {
           Goodnumber:    //метка следующего цикла
           // циклы проверки выполнения условия
            for (int j = 0; j <= a[i].length - b[0].length; j++) {
                for (int q = 0; q < b.length; q++)
                    for (int x = 0; x < b[q].length; x++)
                        if (a[i + q][j + x] != b[q][x])
                            continue Goodnumber; //прерывает цикл подсчёта значений переменной j и продолжает его со следующей итерации цикла подсчёта переменной i
                System.out.println( + i + " " + j); //вывод нужного угла
                break ;
            }
        }

    }
}


