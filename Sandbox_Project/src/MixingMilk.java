//http://www.usaco.org/index.php?page=viewproblem2&cpid=855

import java.io.*;
import java.util.Scanner;

public class MixingMilk {

    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(new File("mixmilk.in"));

        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));


        //These represent buckets: bucketX[0] is the capacity, bucketX[1] is the amount of milk inside
        int[] bucketA = {r.nextInt(), r.nextInt()};
        int[] bucketB = {r.nextInt(), r.nextInt()};
        int[] bucketC = {r.nextInt(), r.nextInt()};

        String move = "AtoB";

        boolean loopSwitch = true;

        int zhe;
        int yer;

        for(int i = 0; i < 100; i++)
        {


            if(move.equals("AtoB"))
            {
                while(bucketA[1] > 0 && bucketB[1] < bucketB[0])
                {
                    bucketA[1]--;
                    bucketB[1]++;
                }
                move = "BtoC";
            }

            else if(move.equals("BtoC"))
            {
                while(bucketB[1] > 0 && bucketC[1] < bucketC[0])
                {
                    bucketB[1]--;
                    bucketC[1]++;
                }
                move = "CtoA";
            }

            else if(move.equals("CtoA"))
            {
                while(bucketC[1] > 0 && bucketA[1] < bucketA[0])
                {
                    bucketC[1]--;
                    bucketA[1]++;
                }
                move = "AtoB";
            }

        }

        System.out.println(bucketA[1]);
        System.out.println(bucketB[1]);
        System.out.println(bucketC[1]);

        pw.println(bucketA[1]);
        pw.println(bucketB[1]);
        pw.println(bucketC[1]);

        pw.close();


    }


}
