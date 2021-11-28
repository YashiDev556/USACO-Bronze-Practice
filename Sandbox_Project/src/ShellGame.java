//http://www.usaco.org/index.php?page=viewproblem2&cpid=891

import java.io.*;
import java.util.Scanner;

public class ShellGame {


    public static void main(String[] args) throws IOException {

        Scanner r = new Scanner(new File("shell.in"));

        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));

        int loops = r.nextInt();

        int[] pointsPossible = new int[3];


        char[] list1 = {'*', '.', '.'};
        char[] list2 = {'.', '*', '.'};
        char[] list3 = {'.', '.', '*'};

        int a;
        int b;
        int g;

        for(int i = 0; i < loops; i++)
        {
            a = r.nextInt() - 1;
            b = r.nextInt() - 1;
            g = r.nextInt() - 1;

            switchValues(list1, a, b);
            switchValues(list2, a, b);
            switchValues(list3, a, b);

            if(list1[g] == '*')
                pointsPossible[0]++;
            if(list2[g] == '*')
                pointsPossible[1]++;
            if(list3[g] == '*')
                pointsPossible[2]++;
        }

        int output = 0;
        int max = pointsPossible[0];
        for(int number : pointsPossible)
        {
            if(number > max)
                max = number;

            output = max;
        }

        System.out.println(output);



        pw.println(output);
        pw.close();

    }



    public static void switchValues(char[] arr, int a, int b)
    {
        char buffer = arr[a];
        arr[a] = arr[b];
        arr[b] = buffer;
    }






}
