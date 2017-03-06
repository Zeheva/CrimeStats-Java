/*
File: DataBuilder.java
Name: BHollingsworth
Date: 05MAR17
Purpose: to build Hashmap
 */
package crimestatistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author brend
 */
public class DataBuilder {
    
//build default constructor
    public DataBuilder() {
    }
//build Hash Map
    public List<Map<String, Float>> pullData() {
        try {
            final List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\brend\\Documents\\NetBeansProjects\\CrimeStatistics\\src\\crimestatistics\\Crime.csv"));
            final String[] headers = lines.get(0).split(",");
            final List<Map<String, Float>> stats1 = lines
                    .stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(line -> {
                        Map<String, Float> map = new java.util.HashMap<>();
                        for (int i = 0; i < line.length; i++) {
                            map.put(headers[i], Float.parseFloat(line[i]));
                        }
                        return map;
                    })
                    .collect(Collectors.toList());
            return stats1;
        } catch (IOException ex) {
            Logger.getLogger(HashMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
