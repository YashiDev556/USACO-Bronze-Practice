//http://www.usaco.org/index.php?page=viewproblem2&cpid=664

//NOTE: Needed a bit of help with the strategy of it...


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BlockGame {

    public static void main(String[] args) throws IOException {
        //casting a character to an integer results in the position of the character (a being 1, b being 2...)
        //plus 96. One would need to subract that by 96 in order to get the position of the character.

        Scanner r = new Scanner(new File("blocks.in"));

        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));

        int numCards = r.nextInt();

        ArrayList<String[]> cards = new ArrayList<>();

        for (int i = 0; i < numCards; i++)
        {
            cards.add(new String[]{r.next(), r.next()});
        }

        int[] letterBlocks = new int[26];

        int[] tempBlocks1 = new int[26];
        int[] tempBlocks2 = new int[26];

        for(int i = 0; i < numCards; i++)
        {

            for(int j = 0; j < cards.get(i)[0].length(); j++)
            {
                tempBlocks1[cards.get(i)[0].charAt(j)-97]++;
            }

            for(int j = 0; j < cards.get(i)[1].length(); j++)
            {
                tempBlocks2[cards.get(i)[1].charAt(j)-97]++;
            }

            for(int j = 0; j < 26; j++)
            {
                if(tempBlocks1[j] >= tempBlocks2[j])
                    letterBlocks[j] += tempBlocks1[j];
                else
                    letterBlocks[j] += tempBlocks2[j];

            }

            tempBlocks1 = new int[26];
            tempBlocks2 = new int[26];

        }

        for(int num : letterBlocks)
        {
            System.out.println(num);
            pw.println(num);
        }



        pw.close();




    }




}
