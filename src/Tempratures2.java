// Temperatures2.java
// proccessing measurement data

/**********************************************************************
A problem: processing measurement data

Temperature readings are taken in one and the same place for a couple
of weeks. The readings are taken regularly the same number of
readings each week. At the end of the measurement period the collected
data is to be processed: for each week the least, the greatest and the
average temperature is to be determined. The least, greatest and
average temperature for the whole period is also to be computed.

A solution to the problem

This program reads the temperatures and displays them. Then the least,
greatest and average temperature for each week is computed and stored.
These results are printed on the standard output device. Finally, the
least, greatest and average temperature over the whole measurement
period is decided. These results are also printed on the standard
output device.

Author: Fadil Galjic
**********************************************************************/

import java.util.*; // Scanner, Locale
import static java.lang.System.out;

public class Tempratures2 
{
    // input tool
    public static Scanner in = null;

    public static void main (String[] args)
    {
    out.println("TEMPERATURES\n");

    // create the input tool
    in = new Scanner(System.in);
    in.useLocale(Locale.US);

    // enter the number of weeks and measurements
    out.print("number of weeks: ");
    int nofWeeks = in.nextInt();
    out.print("number of measurements per week: ");
    int nofMeasurementsPerWeek = in.nextInt();

    // storage space for temperature data
    double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

    // read the temperatures
    for (int week = 1; week <= nofWeeks; week++)
    {
    out.println("temperatures - week " + week + ":");
    read(t[week]);
    }
    out.println ("");

    // show the temperatures
    out.println("the temperatures");
    for (int week = 1; week <= nofWeeks; week++)
    {
    print(t[week]);
    }
    out.println("");

    // the least, greatest and average temperatures - weekly
    double[] minT = new double[nofWeeks + 1];
    double[] maxT = new double[nofWeeks + 1];
    double[] avgT = new double[nofWeeks + 1];
    for (int week = 1; week <= nofWeeks; week++)
    {
    minT[week] = min(splitRow(t, week));
    maxT[week] = max(splitRow(t, week));
    avgT[week] = sumAvg(splitRow(t, week));
    }

    // show the least, greatest and average temperatures
    out.println("the least, greatest and average temperatures" + " - weekly");
    print(minT);
    print(maxT);
    print(avgT);
    out.println();

    // the least, greatest and average temperatures - whole period
    double minTemp = min(minT);
    double maxTemp = max(maxT);
    double avgTemp = sumAvg(avgT);

    // show the least, greatest and average temperature for
    // the whole period
    out.println("the least, greatest and average temperature" + " - whole period");
    out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
    }

    // read reads the temperatures and stores them in a specified
    // array. The temperatures are stored from index 1, inclusive.
    public static void read (double[] temp)
    {
    if (temp.length < 2)
    throw new IllegalArgumentException("not enough space");
    for (int i = 1; i < temp.length; i++)
    temp[i] = in.nextDouble();
    }

    // print displays the temperatures in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static void print (double[] temp)
    {
    if (temp.length < 2)
    throw new IllegalArgumentException("no temperatures");
    for (int i = 1; i < temp.length - 1; i++)
    out.print(temp[i] + " ");
    out.println(temp[temp.length - 1]);
    }

    // min returns the least temperature in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static double min (double[] temp)
    {
    double min = 10000;
        for (int i = 1; i < temp.length; i++)
        {  
            if (temp[i] < min)
             {
             min = temp[i];
             } 
        }
        return min;
    }

    // max returns the greatest temperature in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static double max (double[] temp)
    {
    double max = -274;
        for (int i = 1; i < temp.length; i++)
        {
            if (temp[i] > max)
            {
            max = temp[i];
            } 
        }
        return max;
    }

    // sum returns the sum of the temperatures in a specified array.
    // Temperatures are given from index 1, inclusive.
    public static double sumAvg (double[] temp)
    {
    double sum = 0;
    int g = 0;
        for (int i = 1; i < temp.length; i++)
        {    
        sum += temp[i];
        g++;   
        }
        return (sum/g);
    }

    //splits the big array with all the data into samller arrays with only weekly data
    public static double[] splitRow(double[][] array, int index) 
    {
        double[] splitArray = new double[array[index].length];
        System.arraycopy(array[index], 0, splitArray, 0, array[index].length);

        return splitArray;
    }
}