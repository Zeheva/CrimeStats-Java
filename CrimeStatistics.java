/*
File: CrimeStatistics.java
Name: BHollingsworth
Date: 05MAR17
Purpose: to find Crime Statistics
 */
package crimestatistics;


import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Hollingsworth
 * @throws java.io.IOException
 */
public class CrimeStatistics {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //start timer
        long startTime = System.currentTimeMillis();
        //pull in the scanner to record user input
        Scanner userInput = new Scanner(System.in);
//build new instance of hashmap
        DataBuilder crime = new DataBuilder();
        //build obj of hashmap
        List<Map<String, Float>> hm = crime.pullData();
//build instance of find data class to work on
        FindData hashMap = new FindData();
        //user input holder for the while loop
        String input2;
        //loop the menu 
        do {
            System.out.println("Enter the number of the question you want answered. Enter ‘Q’ to quit the program :\n"
                    + "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?\n"
                    + "2. What year was the Murder rate the highest?\n"
                    + "3. What year was the Murder rate the lowest?\n"
                    + "4. What year was the Robbery rate the highest?\n"
                    + "5. What year was the Robbery rate the lowest?\n"
                    + "6. What was the total percentage change in Motor Vehicle Theft between 1998 and 2012?\n"
                    + "7. What year was the Violent crime rate the lowest?\n"
                    + "8. What year was the Violent crime rate the highest?\n"
                    + "9. What year was the Property crime rate  the lowest?\n"
                    + "Q. Quit the program");
            String input = userInput.nextLine().toUpperCase().trim();
            input2 = input;
            System.out.println("Your selection was: " + input);
            //switch to perform work on user input
            switch (input) {
                case "1":
                    hashMap.findPopYear(hm);
                    break;
                case "2":
                    hashMap.findMaxYear(hm, "Murder and nonnegligent manslaughter rate");
                    break;
                case "3":
                    hashMap.findMinYear(hm, "Murder and nonnegligent manslaughter rate");
                    break;
                    case "4":
                    hashMap.findMaxYear(hm, "Robbery rate");
                    break;
                case "5":
                   hashMap.findMinYear(hm, "Robbery rate");
                    break;
                case "6":
                    hashMap.theftChange(hm);
                    break;
                    case "7":
                  hashMap.findMinYear(hm, "Violent crime");
                    break;
                case "8":
               hashMap.findMaxYear(hm, "Violent crime");
                    break;
                case "9":
                    hashMap.findMinYear(hm, "Burglary rate");
                    break;
            }
        } while (!"Q".equals(input2));
        //stop timer
        long stopTime = System.currentTimeMillis();
        System.out.println("Thank you for trying the US Crimes Statistics Program");
        System.out.println();
        //convert timer to sec and print
        System.out.println("Elapsed time was " + ((stopTime - startTime) / 1000.0) + " Seconds.");
     

        
    }

}



