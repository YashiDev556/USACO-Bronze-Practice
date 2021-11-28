//http://www.usaco.org/index.php?page=viewproblem2&cpid=568

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SpeedingTicket {

    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(new File("speeding.in"));

        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));

        //basically, you want to look for the overlap between the road segments and the journey segments
        //you then want to compare the speed and speed limits of the overlapping segments

        int roadSegments = r.nextInt();
        int journeySegments = r.nextInt();

        //initializing the journey and the road (lists of segments)
        ArrayList<int[]> road = new ArrayList<>();
        ArrayList<int[]> journey = new ArrayList<>();

        //initializes a segment object which stores values.
        int[] segment;

        for(int i = 0; i < roadSegments; i++)
        {
            //segment is an int[] with first integer being the length, second being the speed limit
            segment = new int[]{r.nextInt(), r.nextInt()};
            road.add(segment);
        }

        for(int i = 0; i < journeySegments; i++)
        {
            //segment is an int[] with first integer being the length, second being the speed that the tractor
            //was being driven
            segment = new int[]{r.nextInt(), r.nextInt()};
            journey.add(segment);
        }

        int maximumInfraction = 0;

        while(road.size() > 0 && journey.size() > 0)
        {
            if(road.get(0)[1] < journey.get(0)[1] && (journey.get(0)[1] - road.get(0)[1]) > maximumInfraction)
                maximumInfraction = journey.get(0)[1] - road.get(0)[1];

            if(journey.get(0)[0] > road.get(0)[0])
            {
                journey.get(0)[0] -= road.get(0)[0];
                road.remove(0);
            }
            else if(journey.get(0)[0] < road.get(0)[0])
            {
                road.get(0)[0] -= journey.get(0)[0];
                journey.remove(0);
            }
            else if(journey.get(0)[0] == road.get(0)[0])
            {
                road.remove(0);
                journey.remove(0);
            }
        }

        System.out.println(maximumInfraction);

        pw.println(maximumInfraction);
        pw.close();

    }

}
