//http://www.usaco.org/index.php?page=viewproblem2&cpid=567

import java.io.*;

import java.util.Scanner;

public class PaintCoverFenceProblem {
    public static void main (String[] args) throws IOException
    {


        Scanner r = new Scanner(new File("paint.in"));

        PrintWriter pw = new PrintWriter(new FileWriter("paint.out"));





        assert r != null;
        int a = r.nextInt();
        int b = r.nextInt();
        int c = r.nextInt();
        int d = r.nextInt();

        int[] fence = new int[100]; //creates a new list of 100 integers, all of which are 0

        for(int i = a; i < b; i++)
            fence[i] = 1;
        for(int i = c; i < d; i++)
            fence[i] = 1;


        int totalPaintCover = 0;
        for(int i : fence)
            totalPaintCover += i;

        System.out.println(totalPaintCover);


        //...----***..........

        //pw.println("Something") prints out something in a file which is associated with the print writer
        pw.println(totalPaintCover);

        pw.close();
    }






}
