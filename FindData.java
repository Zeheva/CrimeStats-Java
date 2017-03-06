/*
File: FindData.java
Name: BHollingsworth
Date: 05MAR17
Purpose: to find Crime Statistics
 */
package crimestatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brend
 */
public class FindData {
//default constructor
    public FindData() {
    }
//find min data for user input
    public void findMinYear(List<Map<String, Float>> map, String table) {

        if (map.size() > 0) {
       
            float lowest = map.get(0).get(table);
      
            int lowestIndex = 0;

            for (int s = 1; s < map.size(); s++) {
                float curValue = map.get(s).get(table);
              
                if (curValue < lowest) {
                    lowest = curValue;
                    lowestIndex = s;
                }
            }
         
            int minYear = Math.round(map.get(lowestIndex).get("Year"));
            System.out.println("The " + table + " was lowest in year: " + minYear);
          
        }

    }
    //find max data for user input
    public void findMaxYear(List<Map<String, Float>> map, String table) {

        if (map.size() > 0) {
            float highest = map.get(0).get(table);
                        int highestIndex = 0;
  

            for (int s = 1; s < map.size(); s++) {
                float curValue = map.get(s).get(table);
                if (curValue > highest) {
                    highest = curValue;
                    highestIndex = s;
                }
              
            }
            int maxYear = Math.round(map.get(highestIndex).get("Year"));
       
            System.out.println("The " + table + " was highest in year: " + maxYear);
          
        }

    }
//find the per in change of theft
    public void theftChange(List<Map<String, Float>> map){
        float yearOne = map.get(4).get("Motor vehicle theft");
         float yearTwo = map.get(18).get("Motor vehicle theft");
         float percet = popGrowth(yearOne,yearTwo);
         float percent = (100 * percet);
        
         System.out.println("The theft change for 1998 to 2012 was: " + String.format("%.0f%%", percent));
        
    }
    //find perct change for two diffent numbers
    public Float popGrowth(float a, float b) {
        float popGrowthPerc = ((b - a) / b) * 100;
        return popGrowthPerc;
    }
//find the percent change per year 
    public void findPopYear(List<Map<String, Float>> map) {
        List<String> totalList = new ArrayList<String>();
        for (int i = 0; i < 19; i++) {
            float temp = map.get(i).get("Population");
            float temp2 = map.get(i + 1).get("Population");
            float total = this.popGrowth(temp, temp2);
            float percent = (100 * total);
            totalList.add((String.format("%.0f%%", percent)));

        }
        System.out.println("The percentages in population growth for each consecutive year from 1994 – 2013 is: ");
        totalList.forEach((a) -> {
            int year = 1994;
            int year2 = 1995;
            System.out.println(year +" " + "to " + year2 + " was " + a);
            year++;
            year2++;
        });
    }

}

