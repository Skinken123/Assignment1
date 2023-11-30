//Temperatures1.java
// proccessing measurement data
/**********************************************************************
A problem: processing measurement data

Temperature measurements are taken in one and the same place for a
couple of weeks. The measurements are taken regularly the same number of
measurements each week. At the end of the measurement period the
collected data is to be processed: for each week the least, the greatest and the
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

public class Tempratures1 
{
    public static void main (String[] args)
    {
    out.println("TEMPERATURES\n");

    // input tool
    Scanner in = new Scanner(System.in);
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

        for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
        {
        t[week][measurement] = in.nextDouble();
        }
    }
    out.println("");

    // show the temperatures
    out.println("the temperatures");
    for (int week = 1; week <= nofWeeks; week++)
    {
        for (int measurement = 1; measurement <= nofMeasurementsPerWeek; measurement++)
        {
        out.print(t[week][measurement] + " ");
        }
        out.println("");
    }
    out.println("");

    // the least, greatest and average temperatures - weekly and the least, greatest and average temperatures - whole period
    double[] minT = new double[nofWeeks + 1];
    double[] maxT = new double[nofWeeks + 1];
    double[] sumT = new double[nofWeeks + 1];
    double[] avgT = new double[nofWeeks + 1];

    double minTemp = t[1][1];
    double maxTemp = t[1][1];
    double sumTemp = 0;
    double avgTemp = t[1][1];
    
    for (int i = 1; i < t.length; i++)
    {
    maxT[i] = t[i][1];
    minT[i] = t[i][1];
    sumT[i] = t[i][1];
    
        for (int j = 2; j < t[i].length; j++)
        {
            if (t[i][j] > maxT[i])
            {
            maxT[i] = t[i][j];
            } 
            if (t[i][j] < minT[i])
            {
            minT[i] = t[i][j];
            } 
            sumT[i] += t[i][j];
        }
    avgT[i] = (double) sumT[i] / (t[i].length - 1);
    sumTemp += avgT[i];

    if(minTemp>minT[i])
    {
    minTemp = minT[i];
    }
    if (maxTemp<maxT[i])
    {
        maxTemp = maxT[i];
    }
    avgTemp = sumTemp/(t.length-1);
    }

    // show the least, greatest and average temperatures
    out.println("the least, greatest and average temperatures" + " - weekly");
    for (int week = 1; week <= nofWeeks; week++)
    {
        out.print(minT[week] + " ");
    }
    out.println("");
    for (int week = 1; week <= nofWeeks; week++)
    {
        out.print(maxT[week] + " ");
    }
    out.println("");
    for (int week = 1; week <= nofWeeks; week++)
    {
        out.print(avgT[week] + " ");
    }
    out.println("");
    out.println();

    // show the least, greatest and average temperature for the whole period
    out.println("the least, greatest and average temperature" + " - whole period");
    out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);

    in.close();
    }
}
