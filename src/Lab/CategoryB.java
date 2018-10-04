package Lab;
import java.util.Scanner;
import java.util.*;



public class CategoryB {


    public static int n;
    public static int m;
    // так как n=3 матрица 3 на 3 для задачи B3
    public static  int[][]mas = {
            {6,5,6},
            {2,1,8},
            {1,5,1}
    };
    public static int bestsum = -1;


    public static void recursion(int x, int y, int sum) //вспомогательная рекурсивная функция для B3
    {

        // проверка на координаты точки b
        if (x == n - 1 && y == m - 1) {
            if (bestsum == -1 || sum < bestsum) {


                bestsum = sum;

            }
        } else {
            // вызов рекурсий в случае если  возможно двигаться вправо или вниз
            if (x < n - 1) {

                recursion(x + 1, y, sum + mas[x + 1][y]);
            }
            if (y < m - 1) {

                recursion(x, y + 1, sum + mas[x][y + 1]);
            }
        }
    }

    public static void task1() {
        System.out.println("Задание B1"+"\n");
        int count = 0; // счетчик скобок
        char[] openBrackets = {'(', '[', '{'};
        char[] closeBrackets = {')', ']', '}'};
        String s = " ([ ] [{ }]  ) [ ({}) ]({[]}) {[ ()] }";
        System.out.println(s);
        s = s.replaceAll(" ", "");


        // цикл пробега по всей строе
        for (int i = 0; i < s.length(); i++) {
            char Brackets = s.charAt(i);
            // цикл для подсчета открывающих скобок
            for (Character c : openBrackets) {
                if (Brackets == c) {
                    count += 1;
                }
            }
            // цикл для подсчета закрывающих скобок
            for (Character c : closeBrackets) {
                if (Brackets == c) {
                    count -= 1;
                }
            }
        }
        if (count == 0) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }

    }

    public static void task2_1() {
        System.out.println("Задание B2(cпираль)"+"\n");
        //Заполнение по спирали
        int m;
        int n;
        int s = 1;
        int source[];
        Scanner input = new Scanner(System.in);
        System.out.println("Введите N");
        n = input.nextInt();
        m = n;
        source = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            source[i] = input.nextInt();
        }
        Arrays.sort(source);
        int[][] array = new int[m][n];

        //Заполнение периметр массива по часовой стрелке.
        for (int y = 0; y < n; y++) {
            array[0][y] = source[s - 1];
            s++;
        }
        for (int x = 1; x < m; x++) {
            array[x][n - 1] = source[s - 1];
            s++;
        }
        for (int y = n - 2; y >= 0; y--) {
            array[m - 1][y] = source[s - 1];
            s++;
        }
        for (int x = m - 2; x > 0; x--) {
            array[x][0] = source[s - 1];
            s++;
        }

        int c = 1;
        int d = 1;

        while (s < m * n) {


            //Движение вправо.
            while (array[c][d + 1] == 0) {
                array[c][d] = source[s - 1];
                s++;
                d++;
            }

            //Движение вниз.
            while (array[c + 1][d] == 0) {
                array[c][d] = source[s - 1];
                s++;
                c++;
            }

            //Движемние влево.
            while (array[c][d - 1] == 0) {
                array[c][d] = source[s - 1];
                s++;
                d--;
            }

            //Движение вверх.
            while (array[c - 1][d] == 0) {
                array[c][d] = source[s - 1];
                s++;
                c--;
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] == 0) {
                    array[x][y] = source[s - 1];
                }
            }
        }
        //Выводим массив в консоль.
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] < n + m) {
                    System.out.print(array[x][y] + " ");
                } else {
                    System.out.print(array[x][y] + " ");
                }
            }
            System.out.println("");
        }
    }

    public static void task2_2() {
        System.out.println("Задание B2(змейка )"+"\n");
        int source[];
        int nik = 0; //cчетчик

        System.out.println("Введите N");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = n;
        int[][] array = new int[n][n];
        source = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            source[i] = input.nextInt();
        }
        Arrays.sort(source);
// Actual manipulation
        int a = 0, b = 0, p = 0, q = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                // перемещение снизу вверх
                for (int j = a, k = b; j >= 0 && k < n; j--, k++) {
                    array[j][k] = source[nik];
                    nik += 1;
                }
            } else {
                // передвижение сверху вниз
                for (int j = p, k = q; j < m && k >= 0; j++, k--) {
                    array[j][k] = source[nik];
                    nik += 1;
                }
            }
            // изменение индекса для перехода снизу вверх
            if (a < m - 1) {
                a++;
            } else {
                a = m - 1;
                b++;
            }
            if (q < n - 1) {
                q++;
            } else {
                p++;
                q = n - 1;
            }
        }
       // вывод матрицы
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] < n + m) {
                    System.out.print(array[x][y] + " ");
                } else {
                    System.out.print(array[x][y] + " ");
                }
            }
            System.out.println("");
        }
    }

    public static void task3() {
        System.out.println("Задание B3"+"\n");
       n=3;//размеры матрицы 3 на 3
        m = n;
        bestsum=-1;
            recursion(0, 0, mas[0][0]);
            System.out.println("Кратчайший путь = "+bestsum);

        }
    }







